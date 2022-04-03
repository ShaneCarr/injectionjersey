package auth;

import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.model.Parameter;
import org.glassfish.jersey.server.spi.internal.ValueParamProvider;

import java.util.function.Function;
// https://riptutorial.com/jersey/example/23632/basic-dependency-injection-using-jersey-s-hk2
public class AuthValueParamProvider implements ValueParamProvider {

    // this aligns the registration of the user
    // param provider given the auth attribute on a user object.
    @Override
    public Function<ContainerRequest, ?> getValueProvider(Parameter parameter) {
        if (parameter.getRawType().equals(User.class)
                && parameter.isAnnotationPresent(Auth.class)) {
            return new UserParamProvider();
        }
        return null;
    }

    private static class UserParamProvider implements Function<ContainerRequest, User> {
        @Override
        public User apply(ContainerRequest containerRequest) {
            // generate the user principle.
            /*
            use code like this later on
            final Enumeration<String> names = request.getHeaderNames();
                 while (names.hasMoreElements()) {
                    final String name = names.nextElement();
                     final Enumeration<String> values = request.getHeaders(name);
             */
            return new User("shane");
        }
    }

    @Override
    public PriorityType getPriority() {
        return Priority.HIGH;
    }
}
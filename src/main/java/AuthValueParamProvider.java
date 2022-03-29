import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.Parameter;
import org.glassfish.jersey.server.spi.internal.ValueParamProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Function;

public class AuthValueParamProvider implements ValueParamProvider {

    @Override
    public Function<ContainerRequest, ?> getValueProvider(Parameter parameter) {
        if (parameter.getRawType().equals(User.class)
                && parameter.isAnnotationPresent(Auth.class)) {
            return new UserParamProvider();
        }
        return null;
    }

    private class UserParamProvider implements Function<ContainerRequest, User> {
        @Override
        public User apply(ContainerRequest containerRequest) {
            // i guess this is whatever tokie is doing.
            return new User("shane");
        }
    }

    @Override
    public PriorityType getPriority() {
        return Priority.HIGH;
    }
}
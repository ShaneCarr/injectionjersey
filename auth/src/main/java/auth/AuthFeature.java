package auth;

import jakarta.inject.Singleton;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.spi.internal.ValueParamProvider;

public class AuthFeature implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
        context.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(AuthValueParamProvider.class)
                        .to(ValueParamProvider.class)
                        .in(Singleton.class);
            }
        });

        return true;
    }
}
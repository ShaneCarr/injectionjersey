import auth.AuthFeature;
import jakarta.ws.rs.client.Entity;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.Parameter;
import org.glassfish.jersey.server.spi.internal.ValueParamProvider;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import resource.TestResource;


import static org.assertj.core.api.Assertions.assertThat;

// https://stackoverflow.com/questions/50975973/registering-a-custom-valueparamprovider-in-jersey-2-27
// the amount of approaches to this in the internet is staggering.
//https://stackoverflow.com/questions/48655865/jersey-2-26-register-inject-in-resourceconfig-bindfactory-cannot-convert-facto
// popular for a time
//https://stackoverflow.com/questions/30397933/jersey-2-x-custom-injection-annotation-with-attributes/30426226
public class ParamInjectTest extends JerseyTest {


    @Override
    protected Application configure() {
       //return null;
        return new ResourceConfig(TestResource.class, AuthFeature.class);
    }

    @Test
    public void testIt() {
        final Response response  = target("test")
                .request()
                .post(Entity.text("Test"));

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.readEntity(String.class)).isEqualTo("shane:Test");
    }
}
package resource;
import auth.Auth;
import auth.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;


@Path("test")
@Consumes("text/plain")
public class TestResource {
    @POST
    @Produces("text/plain")
    public Response post(String text, @Auth User user) {
        return Response.ok(user.getUsername() + ":" + text).build();
    }
}
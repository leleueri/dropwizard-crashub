import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by eric on 01/03/15.
 */
@Path("/hello")
public class HelloResource {
    @GET
    public String world() throws Exception {
        Thread.sleep(10000);
        return "Hello World!";
    }
}

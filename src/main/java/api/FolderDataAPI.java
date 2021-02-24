package api;

import dto.ElementDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/repository")
@RegisterRestClient(baseUri = "https://a.todes.by:13201/reposService/api/v1/")
@Produces("application/json")
public interface FolderDataAPI {

    @Path("/root")
    @GET
    ElementDTO rootData();

    @Path("/{id}/children")
    @GET
    List<ElementDTO> childrenData(@PathParam("id") Integer id);

    @GET
    @Path("{id}")
    ElementDTO element(@PathParam("id") Integer id);
}

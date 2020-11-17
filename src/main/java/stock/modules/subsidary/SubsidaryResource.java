package stock.modules.subsidary;


import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/subsidiaries")
@Produces(MediaType.APPLICATION_JSON)
public class SubsidaryResource {

    @Inject
    SubsidaryRepository subsidaryRepository;

    @GET
    public Response findAll() {

        try {
            List<Subsidary> subsidaryList = subsidaryRepository.listAll();
            return Response.ok(subsidaryList).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        try {
            Subsidary subsidary = subsidaryRepository.getById(id);

            if (Objects.isNull(subsidary)) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(subsidary).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }

    }

    @POST
    public Response create(@Valid Subsidary subsidary) {
        try {
            Subsidary subsidaryEntity = subsidaryRepository.save(subsidary);
            return Response.ok(subsidaryEntity).status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Subsidary subsidary) {
        try {
            Subsidary subsidaryUpdated = subsidaryRepository.update(id, subsidary);
            return Response.ok(subsidaryUpdated).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        try {
            subsidaryRepository.remove(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }


}
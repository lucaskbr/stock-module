package stock.modules.local;


import stock.modules.local.services.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/locales")
@Produces(MediaType.APPLICATION_JSON)
public class LocalResource {

    @Inject
    GetLocalById getLocalById;

    @Inject
    GetAllLocales getAllLocales;

    @Inject
    CreateLocal createLocal;

    @Inject
    UpdateLocalById updateLocalById;

    @Inject
    DeleteLocalById deleteLocalById;

    @GET
    public Response findAll() {
        try {
            List<Local> providers = getAllLocales.execute();
            return Response.ok(providers).status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        try {
            Local local = getLocalById.execute(id);

            if (Objects.isNull(local)) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(local).status(Response.Status.OK).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response create(@Valid Local local) {
        try {
            Local localEntity = createLocal.execute(local);
            return Response.ok(localEntity).status(Response.Status.CREATED).build();
        }
        catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Local local) {
        try {
            Local localUpdated =  updateLocalById.execute(id, local);
            return Response.ok(localUpdated).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        try {
            deleteLocalById.execute(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }


}
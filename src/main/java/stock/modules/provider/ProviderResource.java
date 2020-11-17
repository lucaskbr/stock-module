package stock.modules.provider;

import stock.modules.provider.services.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/providers")
@Produces(MediaType.APPLICATION_JSON)
public class ProviderResource {

    @Inject
    GetProviderById getProviderById;

    @Inject
    GetAllProviders getAllProviders;

    @Inject
    CreateProvider createProvider;

    @Inject
    UpdateProviderById updateProviderById;

    @Inject
    DeleteProviderById deleteProviderById;

    @GET
    public Response findAll() {
        try {
            List<Provider> providers = getAllProviders.execute();
            return Response.ok(providers).status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        try {
            Provider provider = getProviderById.execute(id);

            if (Objects.isNull(provider)) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(provider).status(Response.Status.OK).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response create(@Valid Provider provider) {
        try {
            Provider providerEntity = createProvider.execute(provider);
            return Response.ok(providerEntity).status(Response.Status.CREATED).build();
        }
        catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Provider provider) {
        try {
            Provider providerUpdated =  updateProviderById.execute(id, provider);
            return Response.ok(providerUpdated).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        try {
            deleteProviderById.execute(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

}
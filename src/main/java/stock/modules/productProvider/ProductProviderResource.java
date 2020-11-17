package stock.modules.productProvider;


import stock.modules.productProvider.dtos.CreateProductProviderDto;
import stock.modules.productProvider.services.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/product-providers")
@Produces(MediaType.APPLICATION_JSON)
public class ProductProviderResource {

    @Inject
    GetProductProviderById getProductProviderById;

    @Inject
    GetAllProductProviders getAllProductProviders;

    @Inject
    CreateProductProvider createProductProvider;

    @Inject
    UpdateProductProviderById updateProductProviderById;

    @Inject
    DeleteProductProviderById deleteProductProviderById;

    @GET
    public Response findAll() {
        try {
            List<ProductProvider> productProviderList = getAllProductProviders.execute();
            return Response.ok(productProviderList).status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        try {
            ProductProvider productProvider = getProductProviderById.execute(id);

            if (Objects.isNull(productProvider)) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(productProvider).status(Response.Status.OK).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response create(@Valid CreateProductProviderDto createProductProviderDto) {
        try {
            CreateProductProviderDto productProviderCreated = createProductProvider.execute(createProductProviderDto);
            return Response.ok(productProviderCreated).status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, ProductProvider productProvider) {
        try {
            ProductProvider productUpdated = updateProductProviderById.execute(id, productProvider);
            return Response.ok(productUpdated).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        try {
            deleteProductProviderById.execute(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

}
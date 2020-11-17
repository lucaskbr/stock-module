package stock.modules.product;



import stock.modules.product.dtos.CreateProductDto;
import stock.modules.product.services.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    GetProductById getProductById;

    @Inject
    GetAllProducts getAllProducts;

    @Inject
    CreateProduct createProduct;

    @Inject
    UpdateProductById updateProductById;

    @Inject
    DeleteProductById deleteProductById;

    @GET
    public Response findAll() {
        try {
            List<Product> providers = getAllProducts.execute();
            return Response.ok(providers).status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        try {
            Product product = getProductById.execute(id);

            if (Objects.isNull(product)) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(product).status(Response.Status.OK).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response create(@Valid CreateProductDto createProductDto) {
        try {
            CreateProductDto product = createProduct.execute(createProductDto);
            return Response.ok(product).status(Response.Status.CREATED).build();
        }
        catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Product product) {
        try {
            Product productUpdated =  updateProductById.execute(id, product);
            return Response.ok(productUpdated).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        try {
            deleteProductById.execute(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

}
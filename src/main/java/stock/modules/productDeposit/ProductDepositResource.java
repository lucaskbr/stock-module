package stock.modules.productDeposit;


import stock.modules.productDeposit.dto.CreateProductDepositDto;
import stock.modules.productDeposit.dto.ProductDepositDto;
import stock.modules.productDeposit.services.CreateProductDeposit;
import stock.modules.productDeposit.services.DeleteProductDepositById;
import stock.modules.productDeposit.services.GetAllProductDeposits;
import stock.modules.productDeposit.services.GetProductDepositById;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/product-deposits")
@Produces(MediaType.APPLICATION_JSON)
public class ProductDepositResource {

    @Inject
    ProductDepositRepository productDepositRepository;

    @Inject
    CreateProductDeposit createProductDeposit;

    @Inject
    DeleteProductDepositById deleteProductDepositById;

    @Inject
    GetAllProductDeposits getAllProductDeposits;

    @Inject
    GetProductDepositById getProductDepositById;

    @GET
    public Response findAll(@QueryParam("depositId") Long depositId) {
        try {
        List<ProductDepositDto> productDepositList = getAllProductDeposits.execute(depositId);
            return Response.ok(productDepositList).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        try {
            ProductDeposit productDeposit = getProductDepositById.execute(id);

            if (Objects.isNull(productDeposit)) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(productDeposit).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response create(@Valid CreateProductDepositDto createProductDepositDto) {
        try {
            CreateProductDepositDto productDeposit = createProductDeposit.execute(createProductDepositDto);
            return Response.ok(productDeposit).status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, ProductDeposit productDeposit) {
        try {
            ProductDeposit productDepositUpdated = productDepositRepository.update(id, productDeposit);
            return Response.ok(productDepositUpdated).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        try {
            deleteProductDepositById.execute(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }


}
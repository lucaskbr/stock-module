package stock.modules.productMovement;

import stock.modules.productMovement.dtos.ProductMovementDto;
import stock.modules.productMovement.services.MovementProductsInDeposit;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product-movement")
@Produces(MediaType.APPLICATION_JSON)
public class ProductMovementResource {

    @Inject
    MovementProductsInDeposit createProductMovement;

    @POST
    public Response create(ProductMovementDto productMovementDto) {
        try {
            ProductMovement productMovementEntity = createProductMovement.execute(productMovementDto);
            return Response.ok(productMovementEntity).status(Response.Status.CREATED).build();
        }
        catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

}
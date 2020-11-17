package stock.modules.deposit;


import stock.modules.deposit.dtos.CreateDepositDto;
import stock.modules.deposit.services.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/deposits")
@Produces(MediaType.APPLICATION_JSON)
public class DepositResource {

    @Inject
    GetDepositById getDepositById;

    @Inject
    GetAllDeposits getAllDeposits;

    @Inject
    CreateDeposit createDeposit;

    @Inject
    UpdateDepositById updateDepositById;

    @Inject
    DeleteDepositById deleteDepositById;

    @GET
    public Response findAll() {
        try {
            List<Deposit> deposits = getAllDeposits.execute();
            return Response.ok(deposits).status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        try {
            Deposit deposit = getDepositById.execute(id);

            if (Objects.isNull(deposit)) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(deposit).status(Response.Status.OK).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response create(@Valid CreateDepositDto createDepositDto) {
        try {
            CreateDepositDto deposit = createDeposit.execute(createDepositDto);
            return Response.ok(deposit).status(Response.Status.CREATED).build();
        }
        catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Deposit deposit) {
        try {
            Deposit depositUpdated =  updateDepositById.execute(id, deposit);
            return Response.ok(depositUpdated).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        try {
            deleteDepositById.execute(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }


}
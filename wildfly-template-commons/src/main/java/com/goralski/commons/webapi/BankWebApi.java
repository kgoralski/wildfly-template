package com.goralski.commons.webapi;

import com.goralski.commons.webapi.com.goralski.commons.dto.BankDto;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by kgoralski on 19/07/16.
 */
@Path(BankWebApi.BASE_PATH)
public interface BankWebApi {

    public static final String BASE_PATH = "/bank";

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    BankDto createBank(@NotNull @QueryParam("bankName") String bankName);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    BankDto getBank(@NotNull @QueryParam("bankId") Integer bankId);

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    BankDto updateBank(BankDto bankDTO);

    @DELETE
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response deleteBank(@NotNull @QueryParam("bankId") Integer bankId);

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    List<BankDto> getBankList();
}

package com.goralski.server.web;

import com.goralski.commons.webapi.BankWebApi;
import com.goralski.commons.webapi.com.goralski.commons.dto.BankDto;
import com.goralski.server.services.BankServiceRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by kgoralski on 19/07/16.
 */
@Stateless
public class BankWebApiImpl implements BankWebApi {

    @Inject
    private BankServiceRepo bankService;

    @Override
    public BankDto createBank(String bankName) {
        try {
            return bankService.createBank(bankName);
        } catch (Exception e) {
            throw new IllegalArgumentException("BANK_ALREADY_EXISTS", e);
        }
    }

    @Override
    public BankDto getBank(Integer bankId) {
        return bankService.getBank(bankId);
    }

    @Override
    public BankDto updateBank(BankDto bankDTO) {
        return bankService.updateBank(bankDTO);
    }

    @Override
    public Response deleteBank(Integer bankId) {
        try {
            bankService.deleteBank(bankId);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't delete bank with id " + bankId, e);
        }
        return Response.noContent().build();
    }

    @Override
    public List<BankDto> getBankList() {
        return bankService.getBankList();
    }
}

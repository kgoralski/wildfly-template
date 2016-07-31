package com.goralski.server.converters;


import com.goralski.commons.webapi.com.goralski.commons.dto.BankDto;
import com.goralski.server.entities.Bank;
import com.goralski.server.utils.BaseConverter;

import javax.ejb.Stateless;

/**
 * Created by kgoralski on 19/07/16.
 */
@Stateless
public class BankToDtoConverter implements BaseConverter<Bank, BankDto> {
    @Override
    public BankDto convert(Bank from) {
        BankDto result = new BankDto();
        result.setId(from.getId());
        result.setName((from.getName()));
        return result;
    }
}

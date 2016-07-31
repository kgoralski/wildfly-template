package com.goralski.commons.webapi.com.goralski.commons.dto.builders;

import com.goralski.commons.webapi.com.goralski.commons.dto.BankDto;

/**
 * Created by kgoralski on 21/07/16.
 */
public final class BankDtoBuilder {
    private Integer id;
    private String name;

    public BankDtoBuilder() {
    }

    public static BankDtoBuilder aBankDto() {
        return new BankDtoBuilder();
    }

    public BankDtoBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public BankDtoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BankDto build() {
        BankDto bankDto = new BankDto();
        bankDto.setId(id);
        bankDto.setName(name);
        return bankDto;
    }
}

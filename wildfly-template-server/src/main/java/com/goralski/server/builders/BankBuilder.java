package com.goralski.server.builders;


import com.goralski.server.entities.Bank;

import java.util.Date;

/**
 * Created by kgoralski on 19/07/16.
 */
public final class BankBuilder {
    private Integer id;
    private String name;
    private Date date;

    public BankBuilder() {
    }

    public static BankBuilder aBank() {
        return new BankBuilder();
    }

    public BankBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public BankBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BankBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public Bank build() {
        Bank bank = new Bank();
        bank.setId(id);
        bank.setName(name);
        bank.setDate(date);
        return bank;
    }
}

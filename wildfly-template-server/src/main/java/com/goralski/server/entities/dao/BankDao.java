package com.goralski.server.entities.dao;

import com.goralski.server.entities.Bank;

import javax.ejb.Stateless;

/**
 * Created by kgoralski on 23/07/16.
 */
@Stateless
public class BankDao extends GenericDao<Bank> {

    public BankDao() {
        super(Bank.class);
    }
}

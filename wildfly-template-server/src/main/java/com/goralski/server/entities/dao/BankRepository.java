package com.goralski.server.entities.dao;

import com.goralski.server.entities.Bank;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;


/**
 * Created by kgoralski on 23/07/16.
 */
@Repository(forEntity = Bank.class)
public interface BankRepository extends EntityRepository<Bank, Integer> {
}

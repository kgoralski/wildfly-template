package com.goralski.server.services;


import com.goralski.commons.webapi.com.goralski.commons.dto.BankDto;
import com.goralski.server.builders.BankBuilder;
import com.goralski.server.entities.Bank;
import com.goralski.server.entities.dao.BankDao;
import com.goralski.server.utils.BaseConverter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kgoralski on 19/07/16.
 * More traditional way to do this
 */
@Stateless
public class BankServiceDao {

    @Inject
    private BankDao bankDao;
    @Inject
    private BaseConverter<Bank, BankDto> toDtoConverter;

    @Transactional
    public BankDto createBank(String bankName) {

        return toDtoConverter.convert(bankDao.create(new BankBuilder().withName(bankName).build()));
    }

    @Transactional
    public BankDto getBank(Integer bankId) {
        return toDtoConverter.convert(bankDao.find(Bank.class, bankId));
    }

    @Transactional
    public BankDto updateBank(BankDto bankDto) {
        Bank foundEntity = findBankOrThrowException(bankDto.getId());
        foundEntity.setName(bankDto.getName());
        return toDtoConverter.convert(bankDao.update(foundEntity));
    }

    @Transactional
    public void deleteBank(Integer bankId) {
        Bank foundEntity = findBankOrThrowException(bankId);
        bankDao.remove(foundEntity);
    }

    @Transactional
    public List<BankDto> getBankList() {
        return toDtoConverter.convertAll(bankDao.findAll()).stream().collect(Collectors.toList());
    }

    // Not really good way, but it is just an example
    private Bank findBankOrThrowException(Integer bankId) {
        Bank foundEntity = bankDao.find(Bank.class, bankId);
        if (foundEntity == null) {
            throw new IllegalArgumentException("There is no bank with id: " + bankId);
        }
        return foundEntity;
    }
}

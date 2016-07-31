package com.goralski.server.services;


import com.goralski.commons.webapi.com.goralski.commons.dto.BankDto;
import com.goralski.server.builders.BankBuilder;
import com.goralski.server.entities.Bank;
import com.goralski.server.entities.dao.BankRepository;
import com.goralski.server.utils.BaseConverter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kgoralski on 19/07/16.
 */

@Stateless
public class BankServiceRepo {

    @Inject
    private BankRepository bankRepository;
    @Inject
    private BaseConverter<Bank, BankDto> toDtoConverter;

    @Transactional
    public BankDto createBank(String bankName) {

        return toDtoConverter.convert(bankRepository.save(new BankBuilder().withName(bankName).build()));
    }

    @Transactional
    public BankDto getBank(Integer bankId) {
        return toDtoConverter.convert(bankRepository.findBy(bankId));
    }

    @Transactional
    public BankDto updateBank(BankDto bankDto) {
        Bank foundEntity = findBankOrThrowException(bankDto.getId());
        foundEntity.setName(bankDto.getName());
        return toDtoConverter.convert(bankRepository.save(foundEntity));
    }

    @Transactional
    public void deleteBank(Integer bankId) {
        Bank foundEntity = findBankOrThrowException(bankId);
        bankRepository.remove(foundEntity);
    }

    @Transactional
    public List<BankDto> getBankList() {
        return toDtoConverter.convertAll(bankRepository.findAll()).stream().collect(Collectors.toList());
    }

    // Not really good way, but it is just an example
    private Bank findBankOrThrowException(Integer bankId) {
        Bank foundEntity = bankRepository.findBy(bankId);
        if (foundEntity == null) {
            throw new IllegalArgumentException("There is no bank with id: " + bankId);
        }
        return foundEntity;
    }
}

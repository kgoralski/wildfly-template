package client;


import com.goralski.commons.webapi.BankWebApi;
import com.goralski.commons.webapi.com.goralski.commons.dto.BankDto;

import java.util.List;

/**
 * Created by kgoralski on 19/07/16.
 */

public class BankRestClient extends GenericClient<BankWebApi> {

    public BankRestClient(String resourceURI, String userName, String password) {
        super(resourceURI, BankWebApi.class, userName, password);
    }

    public BankRestClient(String resourceURI) {
        super(resourceURI, BankWebApi.class);
    }

    public BankDto createBank(String bankName) {
        return resource.createBank(bankName);
    }


    public BankDto getBank(Integer bankId) {
        return resource.getBank(bankId);
    }


    public BankDto updateBank(BankDto bankDTO) {
        return resource.updateBank(bankDTO);
    }


    public void deleteBank(Integer bankId) {
        resource.deleteBank(bankId);
    }


    public List<BankDto> getBankList() {
        return resource.getBankList();
    }
}

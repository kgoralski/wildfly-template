package client;

import com.goralski.commons.webapi.com.goralski.commons.dto.BankDto;
import com.goralski.commons.webapi.com.goralski.commons.dto.builders.BankDtoBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by kgoralski on 23/07/16.
 */
public class BankRestClientTest {
    private static final String BANK_NAME = "name";
    private BankRestClient tested;


    private int port = 8080;

    // Not really a tests, more like runners
    private static String getTestRestServiceUrl(int port) {
        return "http://172.17.0.2:8080/wildfly-template/rest/";
    }

    @Before
    public void setUp() throws Exception {
        tested = new BankRestClient(getTestRestServiceUrl(port));

        List<BankDto> bankList = tested.getBankList();
        for (BankDto bankDto : bankList) {
            tested.deleteBank(bankDto.getId());
        }
    }

    @Test
    public void shouldCreateBank() throws Exception {
        // when
        BankDto bank = tested.createBank(BANK_NAME);
        //then
        assertThat(bank.getName()).isEqualTo(BANK_NAME);
    }

    @Test
    public void shouldGetBank() throws Exception {
        // given
        BankDto bankCreated = tested.createBank(BANK_NAME);
        // when
        BankDto bank = tested.getBank(bankCreated.getId());
        // then
        assertThat(bank.getId()).isEqualTo(bankCreated.getId());
        assertThat(bank.getName()).isEqualTo(BANK_NAME);
    }

    @Test
    public void shouldUpdateBank() throws Exception {
        // given
        BankDto bankCreated = tested.createBank(BANK_NAME);
        // when
        BankDto bank = tested.updateBank(new BankDtoBuilder().withId(bankCreated.getId()).withName(BANK_NAME).build());
        // then
        assertThat(bank.getId()).isEqualTo(bankCreated.getId());
        assertThat(bank.getName()).isEqualTo(BANK_NAME);
    }

    @Test
    public void shouldDeleteBank() throws Exception {
        // given
        BankDto bankCreatedOne = tested.createBank(BANK_NAME + 1);
        tested.createBank(BANK_NAME + 2);
        // when
        tested.deleteBank(bankCreatedOne.getId());
        // then
        List<BankDto> bankList = tested.getBankList();
        assertThat(bankList).hasSize(1);

    }

    @Test
    public void shouldGetBankList() throws Exception {
        //given
        tested.createBank(BANK_NAME);
        tested.createBank(BANK_NAME + 1);
        // when
        List<BankDto> bankList = tested.getBankList();
        // then
        assertThat(bankList).hasSize(2);
    }
}
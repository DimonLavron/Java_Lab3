package ua.lviv.iot.bank.managers;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.bank.models.BankingService;
import ua.lviv.iot.bank.models.Credit;
import ua.lviv.iot.bank.models.Deposit;
import ua.lviv.iot.bank.models.Remittance;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankingServicesManagerImplTest {

    private List<BankingService> bankingServices;

    private BankingServicesManager bankingServicesManager;

    @Test
    void testGetterSetter() {
        PojoClass pojoclass;
        pojoclass = PojoClassFactory.getPojoClass(BankingServicesManagerImpl.class);
        Validator validator = ValidatorBuilder
                .create()
                .with(new SetterMustExistRule())
                .with(new GetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();
        validator.validate(pojoclass);
    }

    @Test
    public void testGetAvailableCredits() {
        bankingServices = new LinkedList<>();

        bankingServices.add(new Credit());
        bankingServices.add(new Credit());
        bankingServices.add(new Credit());

        bankingServicesManager = new BankingServicesManagerImpl(bankingServices);

        assertEquals(3, bankingServicesManager.getAvailableCredits().size());
    }

    @Test
    void getAvailableDeposits() {
        bankingServices = new LinkedList<>();

        bankingServices.add(new Deposit());
        bankingServices.add(new Deposit());
        bankingServices.add(new Deposit());
        bankingServices.add(new Deposit());

        bankingServicesManager = new BankingServicesManagerImpl(bankingServices);

        assertEquals(4, bankingServicesManager.getAvailableDeposits().size());
    }

    @Test
    void getAvailableCreditsSortedByServiceFee() {
        bankingServices = new LinkedList<>();

        Credit credit1 = new Credit();
        credit1.setServiceFee(4.5);

        Credit credit2 = new Credit();
        credit2.setServiceFee(6.5);

        Credit credit3 = new Credit();
        credit3.setServiceFee(2.5);

        List<BankingService> expectedList = new LinkedList<>();

        bankingServices.add(credit1);
        bankingServices.add(credit2);
        bankingServices.add(credit3);

        bankingServicesManager = new BankingServicesManagerImpl(bankingServices);

        expectedList.add(credit3);
        expectedList.add(credit1);
        expectedList.add(credit2);

        assertEquals(expectedList, bankingServicesManager.getAvailableCreditsSortedByServiceFee());
    }

    @Test
    void getAvailableDepositsSortedByServiceTerm() {
        bankingServices = new LinkedList<>();

        Deposit deposit1 = new Deposit();
        deposit1.setServiceTermInMonth(26);

        Deposit deposit2 = new Deposit();
        deposit2.setServiceFee(8);

        Deposit deposit3 = new Deposit();
        deposit3.setServiceFee(13);

        List<BankingService> expectedList = new LinkedList<>();

        bankingServices.add(deposit1);
        bankingServices.add(deposit2);
        bankingServices.add(deposit3);

        bankingServicesManager = new BankingServicesManagerImpl(bankingServices);

        expectedList.add(deposit2);
        expectedList.add(deposit3);
        expectedList.add(deposit1);

        assertEquals(expectedList, bankingServicesManager.getAvailableDepositsSortedByServiceTerm());
    }

    @Test
    void sortByServiceFee() {
        bankingServices = new LinkedList<>();

        Credit credit = new Credit();
        credit.setServiceFee(4.5);

        Deposit deposit = new Deposit();
        deposit.setServiceFee(6.5);

        Remittance remittance = new Remittance();
        remittance.setServiceFee(2.5);

        List<BankingService> expectedList = new LinkedList<>();

        bankingServices.add(credit);
        bankingServices.add(deposit);
        bankingServices.add(remittance);

        bankingServicesManager = new BankingServicesManagerImpl(bankingServices);

        expectedList.add(remittance);
        expectedList.add(credit);
        expectedList.add(deposit);

        bankingServicesManager.sortByServiceFee(bankingServices, false);
        assertEquals(expectedList, bankingServices);

        expectedList = new LinkedList<>();

        expectedList.add(deposit);
        expectedList.add(credit);
        expectedList.add(remittance);

        bankingServicesManager.sortByServiceFee(bankingServices, true);
        assertEquals(expectedList, bankingServices);
    }
}
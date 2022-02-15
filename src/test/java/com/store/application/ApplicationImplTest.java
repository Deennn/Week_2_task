package com.store.application;

import com.store.enums.Gender;
import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exceptions.ApplicantsAlreadyAppliedException;
import com.store.models.Applicant;
import com.store.models.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationImplTest {
    Store drogoStores = new Store("Drogo","Benin",0.00);
    ApplicationImpl application = new ApplicationImpl();


    @Test
    void shouldSuccessfullyApplyToTheStore() throws ApplicantsAlreadyAppliedException {

        Applicant lawal = new Applicant("Lawal","Lawal","a@gmail.com", "Tech", Gender.MALE, Qualification.BSC, Role.CASHIER);
        application.apply(lawal, drogoStores);
        Applicant Peter= new Applicant("Peter","Lawal","a@gmail.com", "Tech", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
        application.apply(Peter, drogoStores);
        assertEquals(2, drogoStores.getApplicants().size());

    }

    @Test
    void shouldCheckIfApplicantIsContainInApplicantList() throws ApplicantsAlreadyAppliedException {
        Applicant sol = new Applicant("Solomon","Lawal","a@gmail.com", "Tech", Gender.MALE, Qualification.BSC, Role.CASHIER);
        application.apply(sol, drogoStores);
        assertTrue(drogoStores.getApplicants().contains(sol));
    }
    void shouldThrowException() throws ApplicantsAlreadyAppliedException {

        Applicant lawal = new Applicant("Lawal","Lawal","a@gmail.com", "Tech", Gender.MALE, Qualification.BSC, Role.CASHIER);
        application.apply(lawal, drogoStores);
        Applicant lawal1= new Applicant("lawal","Lawal","a@gmail.com", "Tech", Gender.MALE, Qualification.BSC, Role.CASHIER);
        application.apply(lawal, drogoStores);
//        assertThrows();


    }
}
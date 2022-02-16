package com.store.recruitment;

import com.store.application.ApplicationImpl;
import com.store.enums.Gender;
import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exceptions.ApplicantsAlreadyAppliedException;
import com.store.exceptions.OverStaffedException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.Applicant;
import com.store.models.Staff;
import com.store.models.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class recruitmentImplTest {
    Store drogoStores = new Store("Drogo","Benin",0.00);
    Staff manager = new Staff(Role.MANAGER);
    Staff cahsier = new Staff(Role.CASHIER);
    recruitmentImpl recruit  = new recruitmentImpl();
    ApplicationImpl application = new ApplicationImpl();


    @Test
//    DisplayName()
    void shouldPassIfApplicantGenderIsFemale() throws StaffNotAuthorizedException, ApplicantsAlreadyAppliedException, OverStaffedException {
        Applicant lawal = new Applicant("Deenn","Lawal","a@gmail.com", "Tech", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
        application.apply(lawal, drogoStores);
        recruit.hire(lawal,manager,drogoStores);
        assertEquals(1,drogoStores.getStaffs().size());
    }
    @Test
    void shouldFailIFApplicantIsNotFemale() throws StaffNotAuthorizedException, ApplicantsAlreadyAppliedException, OverStaffedException {
        Applicant lawal = new Applicant("Deenn","Lawal","a@gmail.com", "Tech", Gender.MALE, Qualification.BSC, Role.CASHIER);
        application.apply(lawal, drogoStores);
        recruit.hire(lawal,manager,drogoStores);
        assertEquals(0,drogoStores.getStaffs().size());
    }
    @Test
    void shouldIfNot() throws ApplicantsAlreadyAppliedException {
        Applicant lawal = new Applicant("Deenn","Lawal","a@gmail.com", "Tech", Gender.MALE, Qualification.BSC, Role.CASHIER);
        application.apply(lawal, drogoStores);
        Assertions.assertThrows(StaffNotAuthorizedException.class, ()-> recruit.hire(lawal,cahsier, drogoStores));
    }
    @Test
    void shouldTestIfApplicantIsInList() throws StaffNotAuthorizedException, ApplicantsAlreadyAppliedException, OverStaffedException {
        Applicant lawal = new Applicant("Deenn","Lawal","a@gmail.com", "Tech", Gender.MALE, Qualification.BSC, Role.CASHIER);

        recruit.hire(lawal,manager,drogoStores);
        assertEquals(0,drogoStores.getApplicants().size());
    }
    @Test
    void shouldCheckIfApplicantIsBeenConvertedToStaff() throws StaffNotAuthorizedException, ApplicantsAlreadyAppliedException, OverStaffedException {
        Applicant lawal = new Applicant("Deenn","Lawal","a@gmail.com", "Tech", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
        application.apply(lawal, drogoStores);
        recruit.hire(lawal,manager,drogoStores);
        recruit. convertApplicantToStaffAndAddToCompany(drogoStores,lawal);
        assertEquals(drogoStores.getStaffs().get(0).getEmail(), lawal.getEmail());
    }

    @Test
    void shouldCheckIfOverStaffed() throws ApplicantsAlreadyAppliedException, OverStaffedException, StaffNotAuthorizedException {

        Applicant lawal = new Applicant("Deenn","Lawal","a@gmail.com", "Tech", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
        application.apply(lawal, drogoStores);
        Applicant lawalD = new Applicant("Deenn","Lawal","a@gmail.com", "Tech", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
        application.apply(lawalD, drogoStores);
        recruit.hire(lawal,manager, drogoStores);
        Assertions.assertThrows(OverStaffedException.class, ()-> recruit.hire(lawalD,manager, drogoStores));
    }

}
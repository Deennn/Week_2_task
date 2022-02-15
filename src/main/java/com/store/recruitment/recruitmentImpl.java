package com.store.recruitment;

import com.store.enums.Gender;
import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exceptions.OverStaffedException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.Applicant;
import com.store.models.Staff;
import com.store.models.Store;

import java.lang.module.FindException;

import static com.store.enums.Gender.FEMALE;
import static com.store.enums.Qualification.BSC;
import static com.store.enums.Qualification.HND;
import static com.store.enums.Role.CASHIER;
import static com.store.enums.Role.MANAGER;

public class recruitmentImpl implements Recruitment{


    @Override
    public void hire(Applicant applicant, Staff staff, Store store) throws StaffNotAuthorizedException, OverStaffedException {
        if (staff.getRole().equals(MANAGER)) {
            if (store.getStaffs().size() < 1 ) {
                if (store.getApplicants().contains(applicant)) {
                    if (applicant.getPositionAppliedTo().equals(CASHIER)
                            && applicant.getGender().equals(FEMALE)
                            && (applicant.getQualification().equals(BSC) || applicant.getQualification().equals(HND)) ) {
                        System.out.println("Dear " + applicant.getFirstName() + ", we happy to informed you that you've been hired as "
                                + applicant.getPositionAppliedTo() + " at " + store.getName() + ", located at " + store.getAddress() + " \n" +
                                "we delighted to have you onboard.\n        cheers...");
                        convertApplicantToStaffAndAddToCompany(store,applicant);

                    } else {
                        System.out.println("Dear "+ applicant.getFirstName() +",you didn't qualify for this job");
                    }
                } else {
                    System.out.println("Applicant is not in the List");
                }
            } else {
                throw new OverStaffedException("Sorry, we are Currently overStaffed right now");
            }


        } else {
            throw new StaffNotAuthorizedException("You Must be the Manager to be able to perform this operation");
        }
    }
    void convertApplicantToStaffAndAddToCompany(Store store, Applicant applicant) {
        Staff hiredStaff = new Staff();
        hiredStaff.setFirstName(applicant.getFirstName());
        hiredStaff.setLastName(applicant.getLastName());
        hiredStaff.setEmail(applicant.getEmail());
        hiredStaff.setRole(CASHIER);
        hiredStaff.setAddress(applicant.getAddress());
        hiredStaff.setGender(applicant.getGender());
        hiredStaff.setRole(applicant.getPositionAppliedTo());
        store.getStaffs().add(hiredStaff);
        store.getApplicants().remove(applicant);
    }
}

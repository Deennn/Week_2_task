package com.store.recruitment;

import com.store.exceptions.OverStaffedException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.Applicant;
import com.store.models.Staff;
import com.store.models.Store;

public interface Recruitment {

    void hire(Applicant applicant, Staff staff, Store store) throws StaffNotAuthorizedException, OverStaffedException;
}

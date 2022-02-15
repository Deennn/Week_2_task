package com.store.application;

import com.store.exceptions.ApplicantsAlreadyAppliedException;
import com.store.models.Applicant;
import com.store.models.Store;

public interface Application {

    void apply(Applicant applicant, Store store) throws ApplicantsAlreadyAppliedException;
}

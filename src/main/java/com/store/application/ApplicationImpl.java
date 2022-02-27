package com.store.application;

import com.store.exceptions.ApplicantsAlreadyAppliedException;
import com.store.models.Applicant;
import com.store.models.Store;

public class ApplicationImpl implements Application{


    @Override
    public void apply(Applicant applicant, Store store) throws ApplicantsAlreadyAppliedException {
        if (store.getApplicants().contains(applicant)) {
            throw new ApplicantsAlreadyAppliedException("You,ve already applied for this position");
        } else {
            store.getApplicants().add(applicant);
            System.out.println(applicant.getFirstName() + " has successfully applied for the role of "
                    + applicant.getPositionAppliedTo() + " at " + store.getName());
        }
// I would love to see if this work....
    }
}

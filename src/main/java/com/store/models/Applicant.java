package com.store.models;

import com.store.common.Person;
import com.store.enums.Gender;
import com.store.enums.Qualification;
import com.store.enums.Role;

public class Applicant extends Person {

    private Qualification qualification;
    private Role positionAppliedTo;

    public Applicant(String firstName, String lastName, String email, String address, Gender gender, Qualification qualification, Role positionAppliedTo) {
        super(firstName, lastName, email, address, gender);
        this.qualification = qualification;
        this.positionAppliedTo = positionAppliedTo;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Role getPositionAppliedTo() {
        return positionAppliedTo;
    }

    public void setPositionAppliedTo(Role positionAppliedTo) {
        this.positionAppliedTo = positionAppliedTo;
    }

    @Override
    public String toString() {
        String ss=super.toString();
        return   ss +
                "qualification=" + qualification +
                ", positionAppliedTo=" + positionAppliedTo +
                "}";
    }
}

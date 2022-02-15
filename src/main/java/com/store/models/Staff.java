package com.store.models;

import com.store.common.Person;
import com.store.enums.Gender;
import com.store.enums.Role;

public class Staff extends Person {

    private Role role;
    private int quantityToBeAddedToStore;

    public Staff() {

    }
    public Staff(Role role) {
        this.role = role;
    }
    public Staff(String firstName, String lastName, String email, String address, Gender gender, Role role) {
        super(firstName, lastName, email, address, gender);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "role=" + role +
                '}';
    }
}

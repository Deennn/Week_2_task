package com.store.models;

import com.store.common.Person;
import com.store.enums.Gender;

import java.util.HashMap;
import java.util.Map;

public class Customer extends Person {

    private double wallet;
    private int quantityWanted;
//    private Account account;
    private Map<Product,Integer> cartMap;

    public Customer(String firstName, String lastName, String email, String address, Gender gender, double wallet, int quantityWanted) {
        super(firstName, lastName, email, address, gender);
        this.wallet = wallet;
        this.quantityWanted = quantityWanted;
        this.cartMap = new HashMap<>();
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public int getQuantityWanted() {
        return quantityWanted;
    }

    public void setQuantityWanted(int quantityWanted) {
        this.quantityWanted = quantityWanted;
    }

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<Product, Integer> cartMap) {
        this.cartMap = cartMap;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "wallet=" + wallet +
                ", quantityWanted=" + quantityWanted +
                ", cartMap=" + cartMap +
                '}';
    }
}

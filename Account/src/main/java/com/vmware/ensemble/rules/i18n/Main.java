package com.vmware.ensemble.rules.i18n;

import com.vmware.ensemble.rules.i18n.model.Account.Librarian;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Librarian librarian = new Librarian("1", "admin1", "xyz@gmail.com", "username", "password");
        librarian.login("username", "password");

        librarian.addBook();
        librarian.logout();

    }
}
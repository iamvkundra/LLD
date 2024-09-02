package com.vmware.ensemble.rules.i18n.model.account;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Account {

    String id;
    String email;
    String userName;
    String password;
    LocalDateTime lastAccessed;
    Contact contact;

    public Account(String id, String email, String username, String password, Contact contact) {
        this.id = id;
        this.email= email;
        this.userName = username;
        this.password = password;
        this.contact = contact;
    }

    public String getId() {
        return this.id;
    }

    public void resetPassword(String password) {
        this.password = password;
    }

}

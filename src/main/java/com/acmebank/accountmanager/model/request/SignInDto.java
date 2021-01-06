package com.acmebank.accountmanager.model.request;

import com.sun.istack.internal.NotNull;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class SignInDto {

    @NotNull
    @NotEmpty
    @Length(max = 200)
    private String username;

    @NotNull
    @NotEmpty
    @Length(max = 20)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

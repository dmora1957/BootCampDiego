package com.company.Passwords;

import java.util.regex.Pattern;

public class PasswordFuerte extends Password{

    public PasswordFuerte() {
        this.validationPattern = Pattern.compile("^(?=.*\\d).{4,8}$");
    }
    public PasswordFuerte(String ptr) {
        super(ptr);
    }
}

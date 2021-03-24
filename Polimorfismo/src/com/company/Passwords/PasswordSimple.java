package com.company.Passwords;

import java.util.regex.Pattern;

public class PasswordSimple extends Password{

    public PasswordSimple() {
        this.validationPattern = Pattern.compile("^(?=.*\\d).{4,8}$");
    }
    public PasswordSimple(String ptr) {
        super(ptr);
    }
}

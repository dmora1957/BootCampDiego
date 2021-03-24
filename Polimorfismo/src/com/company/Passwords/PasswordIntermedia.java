package com.company.Passwords;

import java.util.regex.Pattern;

public class PasswordIntermedia extends Password{
    public PasswordIntermedia() {
        this.validationPattern = Pattern.compile("^(?=.*\\d).{4,8}$");
    }
    public PasswordIntermedia(String ptr) {
        super(ptr);
    }
}

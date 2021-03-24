package com.company.Passwords;

import java.util.regex.Pattern;

public class PasswordIntermedia extends Password{
    public PasswordIntermedia() {
        //must contain at least 1 lowercase alphabetical character
        //must contain at least 1 uppercase alphabetical character
        //must contain at least 1 numeric character
        //The string must be eight characters or longer
        this.validationPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})");
    }
    public PasswordIntermedia(String ptr) {
        super(ptr);
    }
}

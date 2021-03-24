package com.company.Passwords;

import java.util.regex.Pattern;

public class PasswordSimple extends Password{

    public PasswordSimple() {
        //must contain at least 1 lowercase alphabetical character
        //must contain at least 1 uppercase alphabetical character
        //The string must be eight characters or longer
        this.validationPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.{8,})");
    }
    public PasswordSimple(String ptr) {
        super(ptr);
    }
}

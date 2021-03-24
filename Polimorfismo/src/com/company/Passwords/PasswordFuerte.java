package com.company.Passwords;

import java.util.regex.Pattern;

public class PasswordFuerte extends Password{

    public PasswordFuerte() {
        //must contain at least 1 lowercase alphabetical character
        //must contain at least 1 uppercase alphabetical character
        //must contain at least 1 numeric character
        //must contain at least one special character, but we are escaping reserved RegEx characters to avoid conflict
        //The string must be eight characters or longer
        this.validationPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{8,})");
    }
    public PasswordFuerte(String ptr) {
        super(ptr);
    }
}

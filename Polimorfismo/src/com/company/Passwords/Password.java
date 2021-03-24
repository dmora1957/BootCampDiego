package com.company.Passwords;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    protected String value;
    protected Pattern validationPattern;

    public Password()
    {}

    public Password(String ptr)
    {
        this.validationPattern = Pattern.compile(ptr);
    }

    public void setValue(String pwd) throws Exception {
        if(!isRightFormat(pwd))
            throw new Exception("Formato incorrecto");
        this.value = value;
    }

    public boolean isRightFormat(String pwd)
    {
        Matcher matcher = validationPattern.matcher(pwd);
        return matcher.find();
    }
}

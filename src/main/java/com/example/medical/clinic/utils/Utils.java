package com.example.medical.clinic.utils;


import java.util.regex.Pattern;

public class Utils {

    public boolean isValidPassword(String password)
    {
        var regex ="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

package com.example.searchcy.Core;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Util {
    public boolean validateInfo(ArrayList<?> infoList){
        for (Object info : infoList) {
            if (info == null || info.toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}

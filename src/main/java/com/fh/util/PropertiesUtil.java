package com.fh.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtil {
	public static String getResourceString(String resFile, String key) {
        ResourceBundle rb = ResourceBundle.getBundle(resFile, Locale.getDefault());
        return rb.getString(key);
    }
}

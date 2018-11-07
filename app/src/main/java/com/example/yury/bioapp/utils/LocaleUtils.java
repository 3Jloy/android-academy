package com.example.yury.bioapp.utils;

import android.content.Context;
import android.os.Build;

import java.util.Locale;

public class LocaleUtils {
    public static Locale getCurrentLocale(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return context.getResources().getConfiguration().getLocales().get(0);
        } else{
            return context.getResources().getConfiguration().locale;
        }
    }
}

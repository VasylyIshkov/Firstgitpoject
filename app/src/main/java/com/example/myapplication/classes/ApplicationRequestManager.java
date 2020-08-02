package com.example.myapplication.classes;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication.Constants;

import java.util.ArrayList;

public class ApplicationRequestManager {
    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static void setRequest(String value, Context context) {
        setArraySize(context);
        getPrefs(context).edit().putString(Constants.REQUEST_ARRAY, value + "_" + getArraySize(context)).apply();
    }

    public static String getRequest(Context context,int id) {
        return getPrefs(context).getString(Constants.REQUEST_ARRAY+"_"+id, null);
    }

    private static void setArraySize(Context context) {
        getPrefs(context).edit().putInt(Constants.ARR_SIZE, (getArraySize(context) + 1));
    }

    private static int getArraySize(Context context) {
        return getPrefs(context).getInt(Constants.ARR_SIZE, 0);
    }

    public static ArrayList<String> getArrayPRequest(Context context) {
        int size = getArraySize(context);
        ArrayList<String> array = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
        {
            String tmp = getRequest(context,i);
            array.add(tmp.substring(0,tmp.indexOf("_")));
        }
        return array;
    }
}

package com.example.myapplication.classes;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;
import android.util.Log;

import com.example.myapplication.Constants;

import java.util.ArrayList;

public class ApplicationRequestManager {
    private Context context;
    public ApplicationRequestManager(Context context){
        this.context = context;
    }
    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static void setRequest(String value, Context context) {
        getPrefs(context).edit().putString(Constants.REQUEST_ARRAY + "_" + getArraySize(context), value).apply();
        setArraySize(context);

    }

    public static String getRequest(Context context, int id) {
        return getPrefs(context).getString(Constants.REQUEST_ARRAY + "_" + id, null);
    }

    private static void setArraySize(Context context) {
        getPrefs(context).edit().putInt(Constants.ARR_SIZE, (getArraySize(context) + 1)).apply();
    }

    private static int getArraySize(Context context) {
        return getPrefs(context).getInt(Constants.ARR_SIZE, 0);
    }

    public static ArrayList<String> getArrayPRequest(Context context) {
        int size = getArraySize(context);
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String tmp = getRequest(context, i);
            if (tmp != null)
                array.add(tmp);
        }
        return array;
    }
}

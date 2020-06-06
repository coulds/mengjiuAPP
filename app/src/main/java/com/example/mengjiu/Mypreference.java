package com.example.mengjiu;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Mypreference {
    private static Mypreference INSTANCE =null;
    private Context context;
    private SharedPreferences prefs;
    private Mypreference(){}
    public static Mypreference getInstance(){
        if (null==INSTANCE){
            INSTANCE=new Mypreference();
        }
        return INSTANCE;
    }
    public void setup(Context ctx){
        this.context=ctx;
        prefs= PreferenceManager.getDefaultSharedPreferences(context);
    }
    public void saveUser(String username,String token){
        SharedPreferences.Editor editor=prefs.edit();
        editor.putString(UserLab.USER_CURRENT,username);
        editor.putString(UserLab.USER_TOKEN,(String) token);
        editor.apply(); //或者 editor.commit();


    }

    /**
     * 返回当前登录用户名
     * @return
     */
    public String currentUser(){
        return prefs.getString(UserLab.USER_CURRENT,"未登录");
    }

    /**
     * 返回当前登录用户的Token
     * @return
     */
    public String currentToken(){
        return prefs.getString(UserLab.USER_TOKEN,"loginsuccess");
    }
}

package ws.wolfsoft.creative;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Rajan on 09-Aug-17.
 */

public class Sesion {


    private SharedPreferences prefs;

    public Sesion(Context cntx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }


    public String get_Otp() {
        String s = prefs.getString("otp", "");
        return s;
    }


    public void set_Otp(String s) {
        prefs.edit().putString("otp", s).commit();

    }
}
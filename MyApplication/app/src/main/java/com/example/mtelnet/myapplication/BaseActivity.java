package com.example.mtelnet.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.androidquery.AQuery;

import java.util.Locale;

/**
 * Created by sundy on 15/7/30.
 */
public class BaseActivity extends FragmentActivity {

    private final String TAG = "BaseActivity";
    protected Context context;
    protected AQuery aq;

    public BaseActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        aq = new AQuery(this);

    }

    //設置語言
    public void setLang(Context context) {
        String languageStr = Locale.getDefault().getLanguage();
        Resources res = context.getApplicationContext().getResources();
        Configuration conf = res.getConfiguration();

        SharedPreferences settings = context.getSharedPreferences(MyConstant.APP_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String lang = settings.getString(MyConstant.CURRENT_LANGUAGE, "");
        rtLog(TAG, "----------lang = " + lang);

        if (MyConstant.LANG_EN.equals(lang)) {
            MyConstant.Language = MyConstant.LANG_EN;
            Locale.setDefault(Locale.ENGLISH);
            conf.locale = Locale.ENGLISH;
            editor.putString(MyConstant.CURRENT_LANGUAGE, MyConstant.LANG_EN);
        } else if (MyConstant.LANG_HK.equals(lang)) {
            MyConstant.Language = MyConstant.LANG_HK;
            Locale.setDefault(Locale.TRADITIONAL_CHINESE);
            conf.locale = Locale.TRADITIONAL_CHINESE;
            editor.putString(MyConstant.CURRENT_LANGUAGE, MyConstant.LANG_HK);
        } else if (lang.length() == 0) {
            if (languageStr.equals("en")) {
                MyConstant.Language = MyConstant.LANG_EN;
                Locale.setDefault(Locale.ENGLISH);
                conf.locale = Locale.ENGLISH;
                editor.putString(MyConstant.CURRENT_LANGUAGE, MyConstant.LANG_EN);
            } else if (languageStr.equals("zh")) {
                MyConstant.Language = MyConstant.LANG_HK;
                Locale.setDefault(Locale.TRADITIONAL_CHINESE);
                conf.locale = Locale.TRADITIONAL_CHINESE;
                editor.putString(MyConstant.CURRENT_LANGUAGE, MyConstant.LANG_HK);
            } else {
                MyConstant.Language = MyConstant.LANG_EN;
                Locale.setDefault(Locale.ENGLISH);
                conf.locale = Locale.ENGLISH;
                editor.putString(MyConstant.CURRENT_LANGUAGE, MyConstant.LANG_EN);
            }
        }
        editor.commit();
        res.updateConfiguration(conf, null);
    }

    public void rtLog(String tag, String msg) {
        if (MyConstant.IsDebug) {
            Log.e(tag, msg);
        }
    }
}

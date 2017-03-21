package com.friendtime.foundation.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * 语言设置
 * Created by shenliuyong on 2016/9/21.
 */

public class LanguageUtil {

    /**
     * 判断是否是默认语言设置
     *
     * @param context
     * @return
     */
    public static boolean isSetValue(Context context) {
        Locale currentLocale = context.getResources().getConfiguration().locale;
        return currentLocale.equals(getSetLocale());
    }

    /**
     * 获取默认语言
     *
     * @return
     */
    private static Locale getSetLocale() {
        return Locale.TAIWAN;
    }

    /**
     * 设置为默认语言
     *
     * @param context
     */
    public static void resetDefaultLanguage(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.locale = getSetLocale();
        resources.updateConfiguration(config, dm);
    }


    /**
     * 设置系统地区语言
     *
     * @param context
     */
    public static void resetLanguage(Context context, Locale locale) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.locale = locale;
        resources.updateConfiguration(config, dm);
    }

    /**
     * 根据语言代码，设置locale
     * -- 语言地区代码   0. 简体中文 1.繁体中文 2.英文
     *
     * @param context
     * @param localId
     * @return
     */
    public static Locale getLocaleByLanguageId(Context context, int localId) {
        Locale locale = null;
        switch (localId) {
            case 0:
                locale = new Locale("zh", "CN");
                locale.setDefault(locale);
                break;
            case 1:
                locale = new Locale("zh", "TW");
                locale.setDefault(locale);
                break;
            default:
                break;
        }
        return locale;
    }


}

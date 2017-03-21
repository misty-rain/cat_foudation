package com.friendtime.foundation.tools;

import android.content.Context;
import android.os.Build;

import com.friendtime.foundation.utils.SPUtils;
import com.friendtime.foundation.utils.Utility;
import com.friendtimes.ft_logger.LogProxy;

/**
 * Created by wutao on 2016/12/16.
 * SDK 业务底层基本业务类
 */

public class BaseSdkTools {


    private static BaseSdkTools sdkTools;
    private String token;
    public final static String TAG = BaseSdkTools.class.getCanonicalName();

    public static BaseSdkTools getInstance() {
        if (sdkTools == null) {
            synchronized (BaseSdkTools.class) {
                if (sdkTools == null) {
                    sdkTools = new BaseSdkTools();
                }
            }
        }
        return sdkTools;
    }

    /**
     * 获得当前token
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置当前token
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获得mac 地址，如果mac 地址为空 or  000000 时 ，那就取IMEI号
     * 此方法为
     *
     * @param context
     * @return
     */
    public String getBJMGFMac(Context context) {
        String macAddress = Utility.getMac(context);
        if (macAddress != "") {

            String[] macArrays = macAddress.split("\\D+");
            int sum = 0;
            for (String s : macArrays) {
                if (!s.equals(""))
                    sum += Integer.parseInt(s);
            }
            if (sum == 0) {
                macAddress = Utility.getDeviceIMEI(context);
            }
        }
        return macAddress;

    }

    /**
     * 获取游客试玩接口参数trykey
     *
     * @param context
     */
    public String getTryKey(Context context) {
        String tempStr = "";
        //下个版本需要将trykey 保存到SD卡
        if (Build.VERSION.SDK_INT < 21)
            tempStr = Utility.getMac(context);
        else
            tempStr = SPUtils.get(context, "uuid", "").toString();
        LogProxy.d(TAG, "tempStr=" + tempStr);
        return tempStr;
    }




}

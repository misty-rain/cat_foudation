package com.friendtime.foundation.tools;

import android.content.Context;
import android.os.Build;

import com.friendtime.foundation.bean.AppInfoData;
import com.friendtime.foundation.utils.SPUtils;
import com.friendtime.foundation.utils.StringUtility;
import com.friendtime.foundation.utils.Utility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wutao on 2016/1/28.
 * 请求参数组装 工具类  ，此类中组装各种不同业务模块的 参数集合
 */
public class BaseParamsTools {
    private static final String TAG = BaseParamsTools.class.getSimpleName();


    /**
     * 获得基础参数集合 ，主要包括实例化appid、platformid、token、uuid
     *
     * @return
     */
    public Map<String, String> getFoundationParamsMap(Context context) {
        Map<String, String> params = new HashMap<String, String>();
        final String time = String.valueOf(System.currentTimeMillis());
        String uuid = SPUtils.get(context, "uuid", "").toString();
        if (uuid != "") {
            params.put("uuid", uuid);
        }
        if (BaseSdkTools.getInstance().getToken() != null)
            params.put("token", BaseSdkTools.getInstance().getToken());
        params.put("appid", AppInfoData.appId);
        params.put("platformid", AppInfoData.platformId);
        return params;
    }


    /**
     * 获得基本参数集合 ，主要用来组装基本参数的集合，避免重复在每个方法内重复组装
     *
     * @param context             上下文
     * @param isContainDeviceInfo 此变量 主要用来判断 是否组合设备信息的参数，主要包括mac、device、model 参数
     * @return
     */
    public Map<String, String> getBaseParamsMap(Context context, boolean isContainDeviceInfo) {
        Map<String, String> params = getFoundationParamsMap(context);
        if (isContainDeviceInfo) {
            params.put("mac", BaseSdkTools.getInstance().getBJMGFMac(context));
            if (Utility.getDeviceIMEI(context) != null)
                params.put("device", Utility.getDeviceIMEI(context));
            params.put("model", Build.MODEL);
        }
        return params;
    }

    /**
     * 用户中心 业务单元的基本参数
     *
     * @param context
     * @return
     */
    public Map<String, String> getUserCenterParamsMap(Context context) {
        Map<String, String> params = getFoundationParamsMap(context);
        final String time = String.valueOf(System.currentTimeMillis());
        params.put("stepMd5", "1");
        params.put("stepWeb", "1");
        params.put("sign", StringUtility.md5(params.get("uuid") + AppInfoData.appId + time + AppInfoData.
appKey + AppInfoData.APP_SECRET));
        return params;
    }
    /**
     * 初始化SDK 业务单元的基本参数 ，主要包括初始化SDK 、sdk检测
     *
     * @param context
     * @return
     */
    public Map<String, String> getInitSDKParamsMap(Context context) {
        Map<String, String> params = getFoundationParamsMap(context);
        final String time = String.valueOf(System.currentTimeMillis());
        if (AppInfoData.version != null)
            params.put("version", AppInfoData.version);
        String md5Str;
        if (StringUtility.isEmpty(params.get("uuid")))
            md5Str = AppInfoData.appId + time + AppInfoData.appKey + AppInfoData.APP_SECRET;
        else
            md5Str = params.get("uuid") + AppInfoData.appId + time + AppInfoData.appKey + AppInfoData.APP_SECRET;
        params.put("sign", StringUtility.md5(md5Str));
        return params;
    }

}

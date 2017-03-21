package com.friendtime.foundation.utils;

import android.content.Context;
import android.text.TextUtils;

import com.friendtime.foundation.config.BaseSysConstants;
import com.friendtimes.ft_logger.LogProxy;
import com.friendtimes.http.HttpUtility;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wutao on 2015/12/28. 基础业务域名拼装类 ，
 * */
public class BaseDomainUtility {

    private final String TAG = BaseDomainUtility.class.getSimpleName();
    String domainJsonStr;
    private String netHead = "https://";

    private static BaseDomainUtility baseDomainUtility;

    private BaseDomainUtility() {
    }

    public static BaseDomainUtility getInstance() {
        if (baseDomainUtility == null) {
            synchronized (HttpUtility.class) {
                if (baseDomainUtility == null) {
                    baseDomainUtility = new BaseDomainUtility();
                }
            }
        }
        return baseDomainUtility;
    }

    /**
     * 读取配置文件 json 对象
     *
     * @param context
     * @return
     */
    private JSONObject getDomainJsonStr(Context context) {
        JSONObject jsonObject = null;
        domainJsonStr = SPUtils.get(context, BaseSysConstants.CDN_JSON_FILE_NAME, "").toString();
        if (!domainJsonStr.equals("")) {
            try {
                jsonObject = new JSONObject(domainJsonStr);
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return jsonObject;
    }

    /**
     * 读取基本API domain 主要用在
     *
     * @param context
     * @return
     */
    public String getServiceSDKDomain(Context context) {
        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return netHead + jsonObject.getString("service_sdk_domain");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 读取IM API domain 主要用在 未读消息
     *
     * @param context
     * @return
     */
    public String getServiceIMDomain(Context context) {

        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return netHead + jsonObject.getString("service_im_domain");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 读取客服 API domain 主要用在
     *
     * @param context
     * @return
     */
    public String getCustomeServiceDomain(Context context) {

        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return netHead + jsonObject.getString("service_custom_domain");

            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 主要用在 读取用户中心相关 API domain
     *
     * @param context
     * @return
     */
    public String getUserCenterDomain(Context context) {

        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return netHead + jsonObject.getString("service_ucenter_domain");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 主要用在 读取上传请求相关 API domain
     *
     * @param context
     * @return
     */
    public String getUploadDomain(Context context) {

        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return netHead + jsonObject.getString("service_upload_domain");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 主要用在 读取图片存储请求 API domain
     *
     * @param context
     * @return
     */
    public String getImageResDomain(Context context) {

        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return netHead + jsonObject.getString("s_cdn_domain");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 主要用在 读取FAQ问题请求 API domain
     *
     * @param context
     * @return
     */
    public String getFAQDomain(Context context) {

        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                String resultStr = replaceRquestStrProyHeader(jsonObject.getString("faq_url"));
                if (resultStr != null)
                    return resultStr;
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 主要用在 读取FAQ 版本号
     *
     * @param context
     * @return
     */
    public String getFAQVersion(Context context) {

        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return jsonObject.getString("faq_ver");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 获取短信充值notice的参数值
     *
     * @param context
     * @return
     */
    public String getSmsNotice(Context context) {
        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return jsonObject.getString("sms_notice");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 获取意见注册、登录notice的参数值
     *
     * @param context
     * @return
     */
    public String getOneKeyNotice(Context context) {
        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return jsonObject.getString("onekey_notice");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 获取短信通道channel
     *
     * @param context
     * @return
     */
    public String getSmsChannel(Context context) {
        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return jsonObject.getString("sms_channel");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 主要用在 读取好玩友应用的包名
     *
     * @param context
     * @return
     */
    public String getHwyPackageName(Context context) {

        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return jsonObject.getString("platform_check_name");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 主要用在 读取好玩友应用下载的地址url
     *
     * @param context
     * @return
     */
    public String getHwyAppDownloadUrl(Context context) {

        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {

                String resultStr = replaceRquestStrProyHeader(jsonObject.getString("platform_download_url"));
                if (resultStr != null)
                    return resultStr;
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 获取充值卡URL
     *
     * @param context
     * @return
     */
    public String getRechargCardUrl(Context context) {
        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                String resultStr = replaceRquestStrProyHeader(jsonObject.getString("recharge_card_des_url"));
                if (resultStr != null)
                    return resultStr;

            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 获取充值卡版本号
     *
     * @return
     */
    public String getRechargCardVersion(Context context) {
        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return jsonObject.getString("recharge_card_des_ver");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 获取充值卡版本号
     *
     * @return
     */
    public String getRealConfirm(Context context) {
        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return jsonObject.getString("real_confirm");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";
    }

    /**
     * 获取请求礼包功能的url地址
     *
     * @param context
     * @return
     */
    public String getAdProductUrl(Context context) {
        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {

                String resultStr = replaceRquestStrProyHeader(jsonObject.getString("ad_product_url"));
                if (resultStr != null)
                    return resultStr;
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";

    }

    /**
     * 获取请求礼包功能的Key
     *
     * @param context
     * @return
     */
    public String getAdProductId(Context context) {
        JSONObject jsonObject = getDomainJsonStr(context);
        if (jsonObject != null) {
            try {
                return jsonObject.getString("ad_product_ids");
            } catch (JSONException e) {
                e.printStackTrace();
                LogProxy.e(TAG, e.getMessage());
            }
        }
        return "";

    }

    /**
     * 将http 替换成https 协议
     *
     * @param resultStr
     * @return
     */
    public String replaceRquestStrProyHeader(String resultStr) {
        if (TextUtils.isEmpty(resultStr))
            return null;
        StringBuilder stringBuilder = new StringBuilder(resultStr);
        stringBuilder.insert(4, "s");
        return stringBuilder.toString();
    }
}

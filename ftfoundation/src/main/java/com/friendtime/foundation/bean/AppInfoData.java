package com.friendtime.foundation.bean;


import com.friendtime.foundation.config.EnvConstants;
import com.friendtime.foundation.config.NetWorkEnvConstants;
import com.friendtime.foundation.config.PackagePlatformConstants;


/**
 * Created by wutao on 2015/12/23.
 * 应用基本配置消息类
 * 主要存储APPId、Appkey、channel platformId、version、Secret等信息
 */
public class AppInfoData {
    public static String APP_SECRET;//应用秘钥
    public static String appId; //应用Id
    public static String appKey;//应用key

    public static String channel;//应用渠道
    public static String platformId;//应用平台
    public static String version;//版本号
    public static String productId;//产品 id

    public static boolean online;//在线or 离线
    public static String adCode;//广告码

    public static int screenOrientation;// 屏幕方向  横屏 or 竖屏  1 == 竖屏 0 == 横屏
    public static String gameVersion;// 游戏版本
    public static String clientOperator;// 产品运营
    public static String proAcquisitionDomain; //产品采集域名
    public static EnvConstants globalEnv; //全局服务环境  1-测试环境 0-外网环境
    public static PackagePlatformConstants pkgPlatForm; //接入打包平台  1. bojoy 2.youcai
    public static String giftAdId; //礼包广告Id
    public static int languageCode; //地区语言 0. 简体中文 1.繁体中文 2.英文
    public static String uuid;//应用UUID，主依赖必须在初始化完成后，将服务端返回的UUID 赋予此字段
    public static String sdkVersion;//SDk 版本号，也在初始化时，赋予此字段值
    public static String googleServerClientId; //谷歌客户端id

    public static NetWorkEnvConstants getNetWorkEnvConstants() {
        return netWorkEnvConstants;
    }

    public static void setNetWorkEnvConstants(NetWorkEnvConstants netWorkEnvConstants) {
        AppInfoData.netWorkEnvConstants = netWorkEnvConstants;
    }

    public static NetWorkEnvConstants netWorkEnvConstants;//网络协议环境  http and https

    public static String getGoogleServerClientId() {
        return googleServerClientId;
    }

    public static void setGoogleServerClientId(String googleServerClientId) {
        AppInfoData.googleServerClientId = googleServerClientId;
    }

    public static String getGooglePayKey() {
        return googlePayKey;
    }

    public static void setGooglePayKey(String googlePayKey) {
        AppInfoData.googlePayKey = googlePayKey;
    }

    public static String googlePayKey;//谷歌支付key


    public AppInfoData() {
    }

    ;

    public static String getUuid() {
        return uuid;
    }

    public static void setUuid(String uuid) {
        AppInfoData.uuid = uuid;
    }

    public static String getSdkVersion() {
        return sdkVersion;
    }

    public static void setSdkVersion(String sdkVersion) {
        AppInfoData.sdkVersion = sdkVersion;
    }

    public static int getLanguageCode() {
        return languageCode;
    }

    public static void setLanguageCode(int languageCode) {
        AppInfoData.languageCode = languageCode;
    }

    public static String getAdCode() {
        return adCode;
    }

    public static void setAdCode(String adCode) {
        AppInfoData.adCode = adCode;
    }

    public static String getAppSecret() {
        return APP_SECRET;
    }

    public static void setAppSecret(String appSecret) {
        APP_SECRET = appSecret;
    }

    public static EnvConstants getGlobalEnv() {
        return globalEnv;
    }

    public static void setGlobalEnv(EnvConstants globalEnv) {
        AppInfoData.globalEnv = globalEnv;
    }


    public static String getGameVersion() {
        return gameVersion;
    }

    public static void setGameVersion(String gameVersion) {
        AppInfoData.gameVersion = gameVersion;
    }

    public static String getClientOperator() {
        return clientOperator;
    }

    public static void setClientOperator(String clientOperator) {
        AppInfoData.clientOperator = clientOperator;
    }

    public static PackagePlatformConstants getPkgPlatForm() {
        return pkgPlatForm;
    }

    public static void setPkgPlatForm(PackagePlatformConstants pkgPlatForm) {
        AppInfoData.pkgPlatForm = pkgPlatForm;
    }

    public static String getGiftAdId() {
        return giftAdId;
    }

    public static void setGiftAdId(String giftAdId) {
        AppInfoData.giftAdId = giftAdId;
    }

    public static String getProAcquisitionDomain() {
        return proAcquisitionDomain;
    }

    public static void setProAcquisitionDomain(String proAcquisitionDomain) {
        AppInfoData.proAcquisitionDomain = proAcquisitionDomain;
    }

    public static boolean isOnline() {
        return online;
    }

    public static void setOnline(boolean online) {
        AppInfoData.online = online;
    }

    public static int getScreenOrientation() {
        return screenOrientation;
    }

    public static void setScreenOrientation(int screenOrientation) {
        AppInfoData.screenOrientation = screenOrientation;
    }

    public static String getProductId() {
        return productId;
    }

    public static void setProductId(String productId) {
        AppInfoData.productId = productId;
    }


    public static String getPlatformId() {
        return platformId;
    }

    public static void setPlatformId(String platformId) {
        AppInfoData.platformId = platformId;
    }

    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        AppInfoData.version = version;
    }

    public static String getAppId() {

        return appId;
    }

    public static void setAppId(String appId) {
        AppInfoData.appId = appId;
    }

    public static String getAppKey() {
        return appKey;
    }

    public static void setAppKey(String appKey) {
        AppInfoData.appKey = appKey;
    }

    public static String getChannel() {
        return channel;
    }

    public static void setChannel(String channel) {
        AppInfoData.channel = channel;
    }

}

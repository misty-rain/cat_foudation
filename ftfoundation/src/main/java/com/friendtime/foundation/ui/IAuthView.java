package com.friendtime.foundation.ui;

/**
 * Created by wutao on 2016/6/1.
 * 用户token 视图，主要用来处理本地token失效的处理
 */
public interface IAuthView {
    /**
     * token 失效的处理
     * @param message  错误信息
     */
    void tokenExpired(String message);
}

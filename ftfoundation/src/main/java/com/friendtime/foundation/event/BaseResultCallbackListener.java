package com.friendtime.foundation.event;


import com.mistyrain.okhttp.Call;

/**
 * Created by mistyrain on 12/21/15.
 * * 在Presenter层实现，给Model层回调，更改View层的状态，确保Model层不直接操作View层
 */
public interface BaseResultCallbackListener<T> {
    /**
     * 成功回调
     *
     * @param response            成功时返回的对象
     * @param requestSessionEvent 请求的回话名称
     */
    void onSuccess(T response, int requestSessionEvent);


    /**
     * 失败时回调，简单处理，没做什么
     *
     * @param call                失败时当前请求的内容
     * @param errorCode           网络请求错误码
     * @param exception           失败时返回的异常  ，在presenter 中处理
     * @param requestSessionEvent 请求的回话名称
     * @param requestApiName      请求接口名称
     */
    void onError(Call call, int errorCode, Exception exception, int requestSessionEvent, String requestApiName);


}

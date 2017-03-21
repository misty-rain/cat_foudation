package com.friendtime.foundation.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wutao on 2016/10/27.
 * 游戏 状态
 */

public class GameStatus implements Parcelable {
    private static boolean isSdkInitSuccess;
    private static boolean isSdkLoginSuccess;
    private static boolean isGameLoginSuccess;

    public static boolean isSdkInitSuccess() {
        return isSdkInitSuccess;
    }

    public static void setSdkInitSuccess(boolean sdkInitSuccess) {
        isSdkInitSuccess = sdkInitSuccess;
    }

    public static boolean isSdkLoginSuccess() {
        return isSdkLoginSuccess;
    }

    public static void setSdkLoginSuccess(boolean sdkLoginSuccess) {
        isSdkLoginSuccess = sdkLoginSuccess;
    }

    public static boolean isGameLoginSuccess() {
        return isGameLoginSuccess;
    }

    public static void setGameLoginSuccess(boolean gameLoginSuccess) {
        isGameLoginSuccess = gameLoginSuccess;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.isSdkInitSuccess ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isSdkLoginSuccess ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isGameLoginSuccess ? (byte) 1 : (byte) 0);
    }

    public GameStatus() {
    }

    protected GameStatus(Parcel in) {
        this.isSdkInitSuccess = in.readByte() != 0;
        this.isSdkLoginSuccess = in.readByte() != 0;
        this.isGameLoginSuccess = in.readByte() != 0;
    }

    public static final Creator<GameStatus> CREATOR = new Creator<GameStatus>() {
        @Override
        public GameStatus createFromParcel(Parcel source) {
            return new GameStatus(source);
        }

        @Override
        public GameStatus[] newArray(int size) {
            return new GameStatus[size];
        }
    };
}

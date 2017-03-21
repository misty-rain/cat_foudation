package com.friendtime.foundation.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 更新实体bean
 */
public class UpdateBean implements Parcelable {
    private int isForceUpdate;
    private String forceUpdateUrl;
    private int platformid;
    private String version;


    public UpdateBean() {
    }

    ;

    protected UpdateBean(Parcel in) {
        isForceUpdate = in.readInt();
        forceUpdateUrl = in.readString();
        platformid = in.readInt();
        version = in.readString();
    }

    public static final Creator<UpdateBean> CREATOR = new Creator<UpdateBean>() {
        @Override
        public UpdateBean createFromParcel(Parcel in) {
            return new UpdateBean(in);
        }

        @Override
        public UpdateBean[] newArray(int size) {
            return new UpdateBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(isForceUpdate);
        parcel.writeString(forceUpdateUrl);
        parcel.writeInt(platformid);
        parcel.writeString(version);
    }

    public int getIsForceUpdate() {
        return isForceUpdate;
    }

    public void setIsForceUpdate(int isForcedUpdate) {
        this.isForceUpdate = isForcedUpdate;
    }

    public String getForceUpdateUrl() {
        return forceUpdateUrl;
    }

    public void setForceUpdateUrl(String forceUpdateUrl) {
        this.forceUpdateUrl = forceUpdateUrl;
    }

    public int getPlatformid() {
        return platformid;
    }

    public void setPlatformid(int platformid) {
        this.platformid = platformid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

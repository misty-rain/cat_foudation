package com.friendtime.foundation.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.List;

/**
 * Line 分享工具类
 * @author zhouhonghai
 *
 */
public class LineShareUtil {
	
	public static final int REQUEST_ACTION_PICK = 12; 
	public static final String PACKAGE_NAME = "jp.naver.line.android"; 
	public static final String CLASS_NAME = "jp.naver.line.android.activity.selectchat.SelectChatActivity"; 
	
	private List<ApplicationInfo> m_appList; 
	
	private static final LineShareUtil mLineShareUtil = new LineShareUtil();
	
	public static LineShareUtil getInstance(){
		return mLineShareUtil;
	}

	public void sendTextHandler(Context context,String sendText) {
		if (checkLineInstalled(context)) {
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setClassName(PACKAGE_NAME, CLASS_NAME);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, sendText);
			context.startActivity(intent);
		} else {
		}
	}

	private boolean checkLineInstalled(Context context) {
		PackageManager pm = context.getPackageManager();
		m_appList = pm.getInstalledApplications(0);
		boolean lineInstallFlag = false;
		for (ApplicationInfo ai : m_appList) {
			if (ai.packageName.equals(PACKAGE_NAME)) {
				lineInstallFlag = true;
				break;
			}
		}
		return lineInstallFlag;
	}
}

package com.friendtime.foundation.event;

/**
 * 
 * @author xuxiaobin
 * FileRevEvent 图片返回地址事件	
 *
 */
public class FileRevEvent {

	private String filePath;
	
	public FileRevEvent(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}

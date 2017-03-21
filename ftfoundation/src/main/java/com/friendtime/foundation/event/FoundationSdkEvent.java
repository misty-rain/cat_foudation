package com.friendtime.foundation.event;

/**
 * @author xuxiaobin
 * BJMGFSdkEvent 需返回给开发者的一些sdk事件
 */
public class FoundationSdkEvent {

	/** 充值成功 */
	public static final int RECHARGE_SUCCESS = 19;
	/** 充值失败 */
	public static final int RECHARGE_FAIL = 20;

	private int eventId;
	
	public FoundationSdkEvent(int eventId) {
		this.eventId = eventId;
	}

	public int getEventId() {
		return eventId;
	}

}

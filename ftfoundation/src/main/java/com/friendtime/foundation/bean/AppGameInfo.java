package com.friendtime.foundation.bean;

/**
 * Created by wutao on 2016/10/18.
 * 游戏基本信息类
 */

public class AppGameInfo {
    private static AppGameInfo appGameInfo;

    public static AppGameInfo getInstance() {
        if (appGameInfo == null) {
            synchronized (AppGameInfo.class) {
                if (appGameInfo == null) {
                    appGameInfo = new AppGameInfo();

                }
            }
        }
        return appGameInfo;
    }

    private AppGameInfo() {
    }

    private String serverId;
    private String roleId;
    private String roleName;
    private String roleLevel;
    private String gameId;


    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    private String unionId;
    private String userId;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    private String serverName;

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

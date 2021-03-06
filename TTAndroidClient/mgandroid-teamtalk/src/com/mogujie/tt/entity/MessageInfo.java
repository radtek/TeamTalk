
package com.mogujie.tt.entity;

import java.io.Serializable;
import java.util.Date;

import com.mogujie.tt.cache.biz.CacheHub;
import com.mogujie.tt.config.SysConstant;
import com.mogujie.tt.log.Logger;

/**
 * @Description 消息列表中的消息实体
 * @author Nana
 * @date 2014-3-15
 */
public class MessageInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String ownerId = CacheHub.getInstance().getLoginUserId(); // 用户id
    private Boolean isSend = false; // 消息是发送还是接收
    protected int relateId; // 联系id
    private String msgFromUserId = ""; // 发送信息的用户id
    private String msgFromName = ""; // 发送信息的用户名
    private String msgFromUserNick = ""; // 发送信息的用户昵称
    private String msgFromUserAvatar = ""; // 用户头像URL链接
    private byte msgType = SysConstant.MESSAGE_TYPE_TELETEXT;// 1普通信息（或含图片），100表示语音（是否包含有图片使用占位符来判断）
    private String msgOverview = ""; // 消息内容概要 显示联系人最后一条历史消息时用
    private String msgContent = ""; // 消息内容
    private int msgLoadState = -10;

    private int msgId = -1; // 数据库中存储的消息唯一ID
    private int msgParentId = -1; // 每条消息的唯一ID，消息可能是图文混排，由对个msgId组合成一条消息,如果是单条消息则为默认值，否则为图文混排的第一条消息的ID
    private String targetId = ""; // 接收信息的用户id
    private byte msgRenderType;
    private String msgAttachContent = "";
    private String savePath = null; // 图片或语音保存路径
    private String url = null; // 图片或语音链接
    private int displayType = SysConstant.DISPLAY_TYPE_TEXT; // 消息显示类型，本地显示用
    private int playTime = 0; // 语音播放时长
    private byte[] audiocontent = null; // 语音本地缓存

    private int created = 0; // 创建时间
    private int updated = 0; // 更新时间

    private int readStatus = SysConstant.MESSAGE_UNREAD;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public int getRelateId() {
        return relateId;
    }

    public void setRelateId(int relateId) {
        this.relateId = relateId;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
        this.msgParentId = msgId;
    }

    public int getMsgParentId() {
        return msgParentId;
    }

    public void setMsgParentId(int msgParentId) {
        this.msgParentId = msgParentId;
    }

    public int getDisplayType() {
        return displayType;
    }

    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public byte getMsgRenderType() {
        return msgRenderType;
    }

    public void setMsgRenderType(byte msgRenderType) {
        this.msgRenderType = msgRenderType;
    }

    public String getMsgAttachContent() {
        return msgAttachContent;
    }

    public void setMsgAttachContent(String msgAttachContent) {
        this.msgAttachContent = msgAttachContent;
    }

    public void setMsgType(byte msgType) {
        this.msgType = msgType;
    }

    public byte getMsgType() {
        return msgType;
    }

    public int getMsgLoadState() {
        return msgLoadState;
    }

    public void setMsgLoadState(int msgLoadState) {
        Logger.getLogger(MessageInfo.class).d(" setMsgLoadState  = " + msgLoadState);
        this.msgLoadState = msgLoadState;
    }

    public String getMsgFromUserId() {
        return msgFromUserId;
    }

    public void setMsgFromUserId(String msgFromUserId) {
        this.msgFromUserId = msgFromUserId;
    }

    public String getMsgFromName() {
        return msgFromName;
    }

    public void setMsgFromName(String msgFromName) {
        this.msgFromName = msgFromName;
    }

    public String getMsgFromUserNick() {
        return msgFromUserNick;
    }

    public void setMsgFromUserNick(String msgFromUserNick) {
        this.msgFromUserNick = msgFromUserNick;
    }

    public String getMsgFromUserAvatar() {
        return msgFromUserAvatar;
    }

    public void setMsgFromUserAvatar(String msgFromUserAvatar) {
        this.msgFromUserAvatar = msgFromUserAvatar;
    }

    public Date getMsgCreateTime() {
        return new Date(Long.valueOf(created) * 1000);
    }

    public void setMsgCreateTime(int msgCreateTime) {
        this.created = msgCreateTime;
    }

    public String getMsgOverview() {
        switch (this.getDisplayType()) {
            case SysConstant.DISPLAY_TYPE_TEXT:
                msgOverview = this.getMsgContent(); // 文本消息用消息体
                break;
            case SysConstant.DISPLAY_TYPE_IMAGE:
                msgOverview = SysConstant.MSG_OVERVIEW_DISPLAY_TYPE_IMAGE;
                break;
            case SysConstant.DISPLAY_TYPE_AUDIO:
                msgOverview = SysConstant.MSG_OVERVIEW_DISPLAY_TYPE_AUDIO;
                break;
            default:
                msgOverview = SysConstant.MSG_OVERVIEW_DISPLAY_TYPE_OTHERS;
                break;
        }

        return msgOverview;
    }

    public void setMsgOverview(String msgOverview) {
        this.msgOverview = msgOverview;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public byte[] getAudioContent() {
        return audiocontent;
    }

    public void setAudioContent(byte[] AudioContent) {
        audiocontent = AudioContent;
    }

    public void copyFromOtherMsgInfo(MessageInfo other) {
        if (other == null)
            return;

        this.relateId = other.relateId; // 联系id
        this.msgFromUserId = other.msgFromUserId; // 发送信息的用户id
        this.msgFromName = other.msgFromName; // 发送信息的用户名
        this.msgFromUserNick = other.msgFromUserNick; // 发送信息的用户昵称
        this.msgFromUserAvatar = other.msgFromUserAvatar; // 用户头像URL链接
        this.msgType = other.msgType;// 1普通信息（或含图片），100表示语音（是否包含有图片使用占位符来判断）
        this.msgOverview = other.msgOverview; // 消息内容概要 显示联系人最后一条历史消息时用
        this.msgContent = other.msgContent; // 消息内容
        this.msgLoadState = other.msgLoadState;
        this.msgId = other.msgId;
        this.targetId = other.targetId; // 接收信息的用户id
        this.msgRenderType = other.msgRenderType;
        this.msgAttachContent = other.msgAttachContent;
        this.savePath = other.savePath; // 图片或语音保存路径
        this.url = other.url; // 图片或语音链接
        this.displayType = other.displayType; // 消息显示类型，本地显示用
        this.playTime = other.playTime; // 语音播放时长
        this.audiocontent = other.audiocontent; // 语音本地缓存
        this.created = other.created; // 创建时间
        this.updated = other.updated; // 更新时间
        this.readStatus = other.readStatus;
        this.msgParentId = other.msgParentId;
    }

    public int getMsgReadStatus() {
        return readStatus;
    }

    public void setMsgReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    /**
     * @return the isSend
     */
    public Boolean getIsSend() {
        return isSend;
    }

    /**
     * @param isSend the isSend to set
     */
    public void setIsSend(Boolean isSend) {
        this.isSend = isSend;
    }
}

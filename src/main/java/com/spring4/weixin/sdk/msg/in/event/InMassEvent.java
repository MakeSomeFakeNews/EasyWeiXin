package com.spring4.weixin.sdk.msg.in.event;

public class InMassEvent extends InEventMessage {
	 //群发成功
    public static final String EVENT_INMASS_STATUS_SENDSUCCESS = "sendsuccess";
    //群发失败，其他失败情况是err(num)
    public static final String EVENT_INMASS_STATUS_SENDFAIL = "sendfail";

    private String msgId;
    private String status;
    private String totalCount;
    private String filterCount;
    private String sentCount;
    private String errorCount;

    public InMassEvent(String toUserName, String fromUserName, Integer createTime, String event)
    {
        super(toUserName, fromUserName, createTime, event);
    }

    public String getMsgId()
    {
        return msgId;
    }

    public void setMsgId(String msgId)
    {
        this.msgId = msgId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(String totalCount)
    {
        this.totalCount = totalCount;
    }

    public String getFilterCount()
    {
        return filterCount;
    }

    public void setFilterCount(String filterCount)
    {
        this.filterCount = filterCount;
    }

    public String getSentCount()
    {
        return sentCount;
    }

    public void setSentCount(String sentCount)
    {
        this.sentCount = sentCount;
    }

    public String getErrorCount()
    {
        return errorCount;
    }

    public void setErrorCount(String errorCount)
    {
        this.errorCount = errorCount;
    }
}

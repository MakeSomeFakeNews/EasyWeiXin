package com.spring4.weixin.sdk.msg.in;

public class InSpeechRecognittionRes extends InVoiceMessage {

	private String recognition;

    public InSpeechRecognittionRes(String toUserName, String fromUserName, Integer createTime, String msgType) {
        super(toUserName, fromUserName, createTime, msgType);
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

}

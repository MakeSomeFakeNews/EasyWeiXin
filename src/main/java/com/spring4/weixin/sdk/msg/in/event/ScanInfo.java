package com.spring4.weixin.sdk.msg.in.event;

public class ScanInfo {
    private String ScanType;
    private String ScanResult;

    public ScanInfo(String scanType, String scanResult) {
        super();
        ScanType = scanType;
        ScanResult = scanResult;
    }
    public String getScanType() {
        return ScanType;
    }
    public void setScanType(String scanType) {
        ScanType = scanType;
    }
    public String getScanResult() {
        return ScanResult;
    }
    public void setScanResult(String scanResult) {
        ScanResult = scanResult;
    }
}

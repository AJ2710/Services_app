package com.example.ajitg.allpayhere;

public class ServiceData {

    private String name;
    private String workId;

    public ServiceData() {
    }

    public ServiceData(String name, String workId) {
        this.name = name;
        this.workId = workId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }


}


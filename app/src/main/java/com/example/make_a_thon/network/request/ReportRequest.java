package com.example.make_a_thon.network.request;

public class ReportRequest {

    String content;
    String image;

    public ReportRequest(String content, String image) {

        this.content = content;
        this.image = image;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }
}

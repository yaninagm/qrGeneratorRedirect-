package com.front.qrGeneratorRedirect.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QrInfo {
    private Long id;
    private String name;
    private String urlQrId;
    private String dinamicUrl;

    public QrInfo() { }


    public QrInfo(Long id, String name, String urlQrId, String dinamicUrl) {
        this.id = id;
        this.name = name;
        this.urlQrId = urlQrId;
        this.dinamicUrl = dinamicUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlQrId() {
        return urlQrId;
    }

    public void setUrlQrId(String urlQrId) {
        this.urlQrId = urlQrId;
    }

    public String getDinamicUrl() {
        return dinamicUrl;
    }

    public void setDinamicUrl(String dinamicUrl) {
        this.dinamicUrl = dinamicUrl;
    }
}


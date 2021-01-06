package com.front.qrGeneratorRedirect.Infrastucture;

import com.front.qrGeneratorRedirect.Domain.QrInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class StaticQrService {

    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(15);
    private final WebClient localApiClient;

    @Autowired
    public StaticQrService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }
    public String getDinamicUrl(String id){
        return localApiClient
                .get().uri("/productIdentifier/dinamicUrl/"+id)
                .retrieve().bodyToMono(String.class)
                .block(REQUEST_TIMEOUT);
    }

    public QrInfo getProductIdentifier(String id){
        return localApiClient
                .get().uri("/productIdentifier/"+id)
                .retrieve().bodyToMono(QrInfo.class)
                .block(REQUEST_TIMEOUT);
    }

    public QrInfo createProductIdentifier(QrInfo qrInfo){
        qrInfo.setDinamicUrl("https://" + qrInfo.getDinamicUrl());
        return localApiClient
                .post().uri("/productIdentifier/")
                .body(Mono.just(qrInfo), QrInfo.class)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .retrieve()
                .bodyToMono(QrInfo.class)
                .block(REQUEST_TIMEOUT);
    }

    public String getQrImage(long id){
        return localApiClient
                .get().uri("/productIdentifier/qrImage/"+id)
                .retrieve().bodyToMono(String.class)
                .block(REQUEST_TIMEOUT);
    }
}
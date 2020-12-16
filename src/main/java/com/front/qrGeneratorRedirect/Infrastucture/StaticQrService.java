package com.front.qrGeneratorRedirect.Infrastucture;

import com.front.qrGeneratorRedirect.Domain.QrInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class StaticQrService {

    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(15);
    private final WebClient localApiClient;

    @Autowired
    public StaticQrService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }
    public String getDinamicUrl(long id){
        return localApiClient
                .get().uri("/productIdentifier/dinamicUrl/"+id)
                .retrieve().bodyToMono(String.class)
                .block(REQUEST_TIMEOUT);
    }

    public QrInfo getProductIdentifier(long id){
        return localApiClient
                .get().uri("/productIdentifier/"+id)
                .retrieve().bodyToMono(QrInfo.class)
                .block(REQUEST_TIMEOUT);
    }

    public String getQrImage(long id){
        return localApiClient
                .get().uri("/productIdentifier/qrImage/"+id)
                .retrieve().bodyToMono(String.class)
                .block(REQUEST_TIMEOUT);
    }
}
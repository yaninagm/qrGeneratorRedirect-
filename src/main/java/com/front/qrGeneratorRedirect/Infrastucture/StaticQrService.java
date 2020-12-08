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
    public QrInfo getQrInfo(long id){
        return localApiClient
                .get().uri("/qrByProduct/1")
                .retrieve().bodyToMono(QrInfo.class)
                .block(REQUEST_TIMEOUT);
    }
}
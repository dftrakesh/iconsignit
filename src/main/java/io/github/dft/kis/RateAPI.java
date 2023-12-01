package io.github.dft.kis;

import io.github.dft.kis.model.AccessCredential;
import io.github.dft.kis.model.RateRequest;
import io.github.dft.kis.model.RateResponse;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

public class RateAPI extends IconsIgnitSDK {

    private final String RATE_ENDPOINT = "GetCategorisedConsignRate";

    public RateAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public RateResponse getCategorisedConsignRate(RateRequest quoteRequest) {
        URI uri = baseUrl(RATE_ENDPOINT);
        HttpRequest post = post(uri, quoteRequest);

        return getRequestWrapped(post, RateResponse.class);
    }
}
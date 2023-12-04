package io.github.dft.iconsignit;

import io.github.dft.iconsignit.model.RateRequest;
import io.github.dft.iconsignit.model.RateResponse;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

public class RateAPI extends IconsIgnitSDK {

    private final String RATE_ENDPOINT = "GetCategorisedConsignRate";

    public RateAPI(String clientDomain) {
        super(clientDomain);
    }

    @SneakyThrows
    public RateResponse getCategorisedConsignRate(RateRequest quoteRequest) {
        URI uri = baseUrl(RATE_ENDPOINT);
        HttpRequest post = post(uri, quoteRequest);

        return getRequestWrapped(post, RateResponse.class);
    }
}
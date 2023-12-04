package io.github.dft.iconsignit;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import static io.github.dft.iconsignit.constantcode.ConstantCodes.*;

public class IconsIgnitSDK {

    protected HttpClient client;
    private final String baseURL;
    private final ObjectMapper objectMapper;

    public IconsIgnitSDK(String clientDomain) {
        client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.baseURL = String.format(BASE_ENDPOINT, clientDomain);
    }

    @SneakyThrows
    public <T> T getRequestWrapped(HttpRequest request, Class<T> tClass) {

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenComposeAsync(CompletableFuture::completedFuture)
            .thenApplyAsync(HttpResponse::body)
            .thenApplyAsync(responseBody -> convertBody(responseBody, tClass))
            .get();
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        return objectMapper.readValue(body, tClass);
    }

    @SneakyThrows
    private <T> String convertBodyToString(T tClass) {
        return objectMapper.writeValueAsString(tClass);
    }

    @SneakyThrows
    protected URI baseUrl(String path) {
        return new URI(HTTPS +
            baseURL +
            path);
    }

    @SneakyThrows
    protected <T> HttpRequest post(URI uri, T tClass) {
        String jsonBody = convertBodyToString(tClass);

        return HttpRequest.newBuilder(uri)
            .header(CONTENT_TYPE, HTTP_REQUEST_CONTENT_TYPE_JOSN)
            .header(ACCEPT, HTTP_REQUEST_CONTENT_TYPE_JOSN)
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
    }
}
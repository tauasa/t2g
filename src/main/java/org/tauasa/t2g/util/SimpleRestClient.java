package org.tauasa.t2g.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class SimpleRestClient {

    private static final long TIMEOUT = 10;

    private final HttpClient httpClient;
    private final String baseUrl;

    public SimpleRestClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(TIMEOUT))
                .build();
    }

    public String get(String endpoint) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(baseUrl + endpoint))
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return handleResponse(httpClient.send(request, HttpResponse.BodyHandlers.ofString()));
    }

    public String post(String endpoint, String jsonBody) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .uri(URI.create(baseUrl + endpoint))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return handleResponse(httpClient.send(request, HttpResponse.BodyHandlers.ofString()));
    }

    public String put(String endpoint, String jsonBody) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                .uri(URI.create(baseUrl + endpoint))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return handleResponse(httpClient.send(request, HttpResponse.BodyHandlers.ofString()));
    }

    public String delete(String endpoint) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(baseUrl + endpoint))
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return handleResponse(httpClient.send(request, HttpResponse.BodyHandlers.ofString()));
    }

    private static String handleResponse(HttpResponse<String> response) {
        int statusCode = response.statusCode();
        if (statusCode >= 200 && statusCode < 300) {
            return response.body();
        } else {
            throw new RuntimeException( "HTTP request failed with status code: " + statusCode);
        }
    }

    public static void main(String[] args) {
        SimpleRestClient client = new SimpleRestClient("http://localhost:8080");
        try {
            String getResponse = client.get(args[0]);
            System.out.println("GET response: " + getResponse);
            //String postResponse = client.post("/courses", "{\"name\":\"John Doe\",\"email\":\"john@example.com\"}");
            //System.out.println("POST response: " + postResponse);
        } catch (Exception e) {
            System.out.println("Usage: java SimpleRestClient <end_point>");
            e.printStackTrace();
        }
    }
}
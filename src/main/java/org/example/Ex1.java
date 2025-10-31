package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Ex1 {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        String[] endpoints = {
                "https://dummyjson.com/products",
                "https://dummyjson.com/users"
        };

        for (String endpoint : endpoints) {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endpoint))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println("Endpoint: " + endpoint);
                System.out.println("Status Code: " + response.statusCode());
                System.out.println("Response Body:\n" + response.body());
                System.out.println("--------------------------------------------------");

            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao acessar o endpoint: " + endpoint);
                e.printStackTrace();
            }
        }
    }
}

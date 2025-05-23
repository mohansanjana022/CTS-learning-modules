package com.auction.githubapiclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubApiClient {
    public static void main(String[] args) {
        try {
            // Create HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Define the request (GET to GitHub API)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.github.com/users/octocat"))
                    .GET()
                    .build();

            // Send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print status code and response body
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body:\n" + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



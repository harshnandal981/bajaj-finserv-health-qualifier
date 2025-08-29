package com.bajajfinserv.qualifier.service;

import com.bajajfinserv.qualifier.dto.SqlQueryRequest;
import com.bajajfinserv.qualifier.dto.WebhookRequest;
import com.bajajfinserv.qualifier.dto.WebhookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebhookService {
    
    private static final String GENERATE_WEBHOOK_URL = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";
    private static final String TEST_WEBHOOK_URL = "https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA";
    
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Generate webhook by sending POST request with user details
     */
    public WebhookResponse generateWebhook(String name, String regNo, String email) {
        try {
            WebhookRequest request = new WebhookRequest(name, regNo, email);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            HttpEntity<WebhookRequest> entity = new HttpEntity<>(request, headers);
            
            ResponseEntity<WebhookResponse> response = restTemplate.exchange(
                GENERATE_WEBHOOK_URL,
                HttpMethod.POST,
                entity,
                WebhookResponse.class
            );
            
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to generate webhook: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error generating webhook: " + e.getMessage(), e);
        }
    }
    
    /**
     * Submit final SQL query to the webhook URL with JWT token
     */
    public void submitSqlQuery(String webhookUrl, String accessToken, String sqlQuery) {
        try {
            SqlQueryRequest request = new SqlQueryRequest(sqlQuery);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", accessToken);
            
            HttpEntity<SqlQueryRequest> entity = new HttpEntity<>(request, headers);
            
            ResponseEntity<String> response = restTemplate.exchange(
                TEST_WEBHOOK_URL,
                HttpMethod.POST,
                entity,
                String.class
            );
            
            System.out.println("SQL Query submission response: " + response.getStatusCode());
            System.out.println("Response body: " + response.getBody());
            
        } catch (Exception e) {
            System.err.println("Error submitting SQL query: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

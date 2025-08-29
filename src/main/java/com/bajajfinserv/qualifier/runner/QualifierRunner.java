package com.bajajfinserv.qualifier.runner;

import com.bajajfinserv.qualifier.dto.WebhookResponse;
import com.bajajfinserv.qualifier.service.SqlProblemSolver;
import com.bajajfinserv.qualifier.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QualifierRunner implements CommandLineRunner {
    
    @Autowired
    private WebhookService webhookService;
    
    @Autowired
    private SqlProblemSolver sqlProblemSolver;
    
    // User details as specified in the task
    private static final String NAME = "John Doe";
    private static final String REG_NO = "REG12347";
    private static final String EMAIL = "john@example.com";
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting Bajaj Finserv Health Qualifier Application...");
        
        try {
            // Step 1: Generate webhook
            System.out.println("Step 1: Generating webhook...");
            WebhookResponse webhookResponse = webhookService.generateWebhook(NAME, REG_NO, EMAIL);
            
            if (webhookResponse != null) {
                System.out.println("Webhook generated successfully!");
                System.out.println("Webhook URL: " + webhookResponse.getWebhook());
                System.out.println("Access Token: " + webhookResponse.getAccessToken());
                
                // Step 2: Solve SQL problem based on regNo
                System.out.println("\\nStep 2: Solving SQL problem...");
                String sqlSolution = sqlProblemSolver.getSqlSolution(REG_NO);
                System.out.println("SQL Solution: " + sqlSolution);
                
                // Step 3: Submit solution to webhook
                System.out.println("\\nStep 3: Submitting solution to webhook...");
                webhookService.submitSqlQuery(
                    webhookResponse.getWebhook(),
                    webhookResponse.getAccessToken(),
                    sqlSolution
                );
                
                System.out.println("\\nQualifier flow completed successfully!");
                
            } else {
                System.err.println("Failed to generate webhook - no response received");
            }
            
        } catch (Exception e) {
            System.err.println("Error in qualifier flow: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

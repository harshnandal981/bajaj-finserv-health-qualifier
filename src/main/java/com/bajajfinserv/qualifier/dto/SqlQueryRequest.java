package com.bajajfinserv.qualifier.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SqlQueryRequest {
    @JsonProperty("finalQuery")
    private String finalQuery;
    
    public SqlQueryRequest() {}
    
    public SqlQueryRequest(String finalQuery) {
        this.finalQuery = finalQuery;
    }
    
    public String getFinalQuery() {
        return finalQuery;
    }
    
    public void setFinalQuery(String finalQuery) {
        this.finalQuery = finalQuery;
    }
}

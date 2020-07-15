package com.cashflow.implementation;

import java.time.ZoneId;
import java.time.ZonedDateTime;


/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/



public class Credential {
    private final String referenceNumber;
    private final String soapEndpointUrl;
    private final String soapAction;
    private final String agentID;
    private final String agentSequence;
    private final String token;
    private final String timeStamp;
    private final String apiVersion;
    private final String clientSoftwareVersion;
    private final String channelType;
    private final String targetAudience;
    private final String consumerId;
    private final String formFreeStaging;
    private final String productType;
    private final int maxCommitAttempt;
    
    
    public Credential() {
        this.referenceNumber = "94236715";
        this.soapEndpointUrl = "https://extws.moneygram.com/extws/services/AgentConnect1512";
        this.soapAction = "https://extws.moneygram.com/extws/services/AgentConnect1512";
        this.agentID = "43457568";
        this.agentSequence = "2";
        this.token = "TEST";
        this.apiVersion = "1512";
        this.clientSoftwareVersion = "1.0";
        this.channelType = "LOCATION";
        this.targetAudience = "AGENT_FACING";
        
        ZoneId z = ZoneId.of( "Asia/Dhaka" ) ;  
        ZonedDateTime zdt = ZonedDateTime.now( z ) ;
        this.timeStamp = zdt.toString().replace("[Asia/Dhaka]", "");
        
        // ConsumerId will be got from Database, Default value is 0
        this.consumerId = "0";
        this.formFreeStaging = "false";
        
        this.productType = "RCV";
        this.maxCommitAttempt = 3;
        
    }
    
    
    public String getReferenceNumber() {
        return this.referenceNumber;
    }
    
    public String getSoapEndpointUrl() {
        return this.soapEndpointUrl;
    }
    
    public String getSoapAction() {
        return this.soapAction;
    }
    
    public String getAgentID() {
        return this.agentID;
    }
    
    public String getAgentSequence() {
        return this.agentSequence;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public String getApiVersion() {
        return this.apiVersion;
    }
    
    public String getClientSoftwareVersion() {
        return this.clientSoftwareVersion;
    }
    
    public String getChannelType() {
        return this.channelType;
    }
    
    public String getTargetAudience() {
        return this.targetAudience;
    }
    
    public String getTimeStamp() {
        return this.timeStamp;
    }
    
    public String getConsumerId() {
        return this.consumerId;
    }
    
    public String getFormFreeStaging() {
        return this.formFreeStaging;
    }
    
    public String getProductType() {
        return this.productType;
    }
    
    public int getMaxCommitAttempt() {
        return this.maxCommitAttempt;
    }
}

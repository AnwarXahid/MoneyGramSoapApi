package com.cashflow.implementation;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.xml.soap.*;


/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/


public class ReferenceNumber {
    // ReferenceNumber Class Property
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


    
    // ReferenceNumber Constructor
    public ReferenceNumber(Credential cdt) {
        this.referenceNumber = cdt.getReferenceNumber();
        this.soapEndpointUrl = cdt.getSoapEndpointUrl();
        this.soapAction = cdt.getSoapAction();
        this.agentID = cdt.getAgentID();
        this.agentSequence = cdt.getAgentSequence();
        this.token = cdt.getToken();
        this.apiVersion = cdt.getApiVersion();
        this.clientSoftwareVersion = cdt.getClientSoftwareVersion();
        this.channelType = cdt.getChannelType();
        this.targetAudience = cdt.getTargetAudience();
        this.timeStamp = cdt.getTimeStamp();
    }
      
    
    
   
    private SOAPMessage callSoapWebService(String soapEndpointUrl, String soapAction) {
        // return response message
        SOAPMessage soapResponse = null;
        
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);
            soapConnection.close();



            // Print the SOAP Response
            System.out.println("Response MoneyGram Server on ReferenceNumber API calling:");
            soapResponse.writeTo(System.out);
            System.out.println();

            


        } catch (Exception e) {
            System.err.println("\nError occurred while sending ReferenceNumber API Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }


        return soapResponse;
    }
    
    
    
    private SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request MoneyGram Server on ReferenceNumber API calling:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }
            
            
    
    private void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "ac";
        String myNamespaceURI = "http://www.moneygram.com/AgentConnect1512";

        // Writing SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

        // Writing SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("referenceNumberRequest", myNamespace, myNamespaceURI);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("agentID", myNamespace);
        soapBodyElem1.addTextNode(this.agentID);
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("agentSequence", myNamespace);
        soapBodyElem2.addTextNode(this.agentSequence);
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("token", myNamespace);
        soapBodyElem3.addTextNode(this.token);
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("timeStamp", myNamespace);
        soapBodyElem4.addTextNode(this.timeStamp);
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("apiVersion", myNamespace);
        soapBodyElem5.addTextNode(this.apiVersion);
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("clientSoftwareVersion", myNamespace);
        soapBodyElem6.addTextNode(this.clientSoftwareVersion);
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("channelType", myNamespace);
        soapBodyElem7.addTextNode(this.channelType);
        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("targetAudience", myNamespace);
        soapBodyElem8.addTextNode(this.targetAudience);
        SOAPElement soapBodyElem9 = soapBodyElem.addChildElement("referenceNumber", myNamespace);
        soapBodyElem9.addTextNode(this.referenceNumber);

        return;
    }
            
            
    
    
    public SOAPMessage getResponse() {
        // Return Null if got any exception, else return SOAPMessage Object
        SOAPMessage response = callSoapWebService(soapEndpointUrl, soapAction);
        return response;
    }
            
    
}
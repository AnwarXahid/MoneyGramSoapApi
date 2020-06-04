package com.cashflow.implementation;



import javax.xml.soap.*;


/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/



public class CommitTransaction {
    // CommitTransaction Property
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
    private final String mgiTransactionSessionID;
    private final String productType;


    
    // CommitTransaction Constructor
    public CommitTransaction(Credential cdt, ApiResponse api_res) {
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
        this.mgiTransactionSessionID = api_res.getPay_token_id();
        this.productType = cdt.getProductType();
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
            System.out.println("Response commitTransaction Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

        } catch (Exception e) {
            System.err.println("\nError occurred while sending commitTransaction Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }


        return soapResponse;
    }
    
    
    
    private SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        
        soapMessage.setProperty(SOAPMessage.WRITE_XML_DECLARATION, "true");
        
        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request commitTransaction Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }
            
            
    
    private void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "myNamespace";
        String myNamespaceURI = "http://www.moneygram.com/AgentConnect1512";

        // Writing SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

        // Writing SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("commitTransactionRequest", myNamespace, myNamespaceURI);
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
        SOAPElement soapBodyElem9 = soapBodyElem.addChildElement("mgiTransactionSessionID", myNamespace);
        soapBodyElem9.addTextNode(this.mgiTransactionSessionID);
        SOAPElement soapBodyElem10 = soapBodyElem.addChildElement("productType", myNamespace);
        soapBodyElem10.addTextNode(this.productType);

        return;
    }
            
            
    
    
    public SOAPMessage getResponse() {
        // Return Null if got any exception, else return SOAPMessage Object
        SOAPMessage response = callSoapWebService(soapEndpointUrl, soapAction);
        return response;
    }

}

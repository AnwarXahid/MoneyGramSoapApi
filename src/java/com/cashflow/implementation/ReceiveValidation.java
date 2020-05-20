package com.cashflow.implementation;


import javax.xml.soap.*;


/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/



public class ReceiveValidation {
    private final String soapEndpointUrl;
    private final String soapAction;
    
    
    private final String referenceNumber;
    private final String agentID;
    private final String agentSequence;
    private final String token;
    private final String timeStamp;
    private final String apiVersion;
    private final String clientSoftwareVersion;
    private final String channelType;
    private final String targetAudience;
    private final String receiveCurrency;
    private final String agentCheckNumber;
    private final String agentCheckAmount;
    private final String customerCheckNumber;
    private final String customerCheckAmount;
    private final String receiverAddress;
    private final String receiverCity;
    private final String receiverCountry;
    private final String receiverPhotoIdType;
    private final String receiverPhotoIdNumber;
    private final String receiverPhotoIdCountry;
    private final String receiverDOB;
    private final String receiverBirthCountry;
    private final String consumerId;
    private final String receiverPhone;
    private final String mgiTransactionSessionID;
    private final String formFreeStaging;
    private final String receivePurposeOfTransaction;
    private final String relationshipToSender;
    private final String receiverGender;
    private final String receiverPhoneCountryCode;
    
    
    
    
    // Writing Constructor Function
    public ReceiveValidation(Credential cdt) {
        // Credential Properties
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
        
        
        this.receiveCurrency = "BDT";   // from rnr(ReferenceNumberRequest)
        this.agentCheckNumber = "0000000000";   // from rnr
        this.agentCheckAmount = "159911.930"; // from rnr
        this.customerCheckNumber = "0000000000";    // from rnr
        this.customerCheckAmount = "0.000"; //from rnr
        this.receiverAddress = "45TH STREET MOTHIJEEL"; // from customer
        this.receiverCity = "DHAKA";    // from customer
        this.receiverCountry = "BGD";   // from customer
        this.receiverPhotoIdType = "PAS";   // from customer
        this.receiverPhotoIdNumber = "903094094090";    // from customer
        this.receiverPhotoIdCountry = "BGD";    // from customer
        this.receiverDOB = "1990-01-01";    // from customer
        this.receiverBirthCountry = "BGD";  // ????static?????
        this.consumerId = "0";  // ????our system generated????
        this.receiverPhone = "0943043043008";   // from customer
        this.mgiTransactionSessionID = "434575681E15897463850767416586";    // from rnr
        this.formFreeStaging = "false"; // ???? what is this????
        this.receivePurposeOfTransaction = "FAMILY_SUPPORT"; // from customer 
        this.relationshipToSender = "FAMILY"; // from customer
        this.receiverGender = "FEMALE"; // from customer
        this.receiverPhoneCountryCode = "880";  // static
    
        
        
        // Receiver Address from customer : 3 parameter- address, city, country
        // Receiver Photo ID verification : 3 parameter- type, number, country
        // Receiver Date of Birth 
        // Receiver Phone  Number 
        // Relationship to Sender 
        // receiver gender 
        // purpose of transaction 
        // receiverBirthCountry : can be default
        // consumerID ????? don't know
        // ????formFreeStaging???? 
        
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
            System.out.println("Response ReceiveValidation API Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

        } catch (Exception e) {
            System.err.println("\nError occurred while sending ReceiveValidation API Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
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
        System.out.println("Request ReceiveValidation API Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }
            
            
    
    private void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "ac";
        String envNamespace = "soapenv";
        String myNamespaceURI = "http://www.moneygram.com/AgentConnect1512";

        // Writing SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(envNamespace, myNamespaceURI);

        // Writing SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("receiveValidationResponse", myNamespace, myNamespaceURI);
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
        SOAPElement soapBodyElem10 = soapBodyElem.addChildElement("receiveCurrency", myNamespace);
        soapBodyElem10.addTextNode(this.receiveCurrency);
        SOAPElement soapBodyElem11 = soapBodyElem.addChildElement("agentCheckNumber", myNamespace);
        soapBodyElem11.addTextNode(this.agentCheckNumber);
        SOAPElement soapBodyElem12 = soapBodyElem.addChildElement("agentCheckAmount", myNamespace);
        soapBodyElem12.addTextNode(this.agentCheckAmount);
        SOAPElement soapBodyElem13 = soapBodyElem.addChildElement("customerCheckNumber", myNamespace);
        soapBodyElem13.addTextNode(this.customerCheckNumber);
        SOAPElement soapBodyElem14 = soapBodyElem.addChildElement("customerCheckAmount", myNamespace);
        soapBodyElem14.addTextNode(this.customerCheckAmount);
        SOAPElement soapBodyElem15 = soapBodyElem.addChildElement("receiverAddress", myNamespace);
        soapBodyElem15.addTextNode(this.receiverAddress);
        SOAPElement soapBodyElem16 = soapBodyElem.addChildElement("receiverCity", myNamespace);
        soapBodyElem16.addTextNode(this.receiverCity);
        SOAPElement soapBodyElem17 = soapBodyElem.addChildElement("receiverCountry", myNamespace);
        soapBodyElem17.addTextNode(this.receiverCountry);
        SOAPElement soapBodyElem18 = soapBodyElem.addChildElement("receiverPhotoIdType", myNamespace);
        soapBodyElem18.addTextNode(this.receiverPhotoIdType);
        SOAPElement soapBodyElem19 = soapBodyElem.addChildElement("receiverPhotoIdNumber", myNamespace);
        soapBodyElem19.addTextNode(this.receiverPhotoIdNumber);
        SOAPElement soapBodyElem20 = soapBodyElem.addChildElement("receiverPhotoIdCountry", myNamespace);
        soapBodyElem20.addTextNode(this.receiverPhotoIdCountry);
        SOAPElement soapBodyElem21 = soapBodyElem.addChildElement("receiverDOB", myNamespace);
        soapBodyElem21.addTextNode(this.receiverDOB);
        SOAPElement soapBodyElem22 = soapBodyElem.addChildElement("receiverBirthCountry", myNamespace);
        soapBodyElem22.addTextNode(this.receiverBirthCountry);
        SOAPElement soapBodyElem23 = soapBodyElem.addChildElement("consumerId", myNamespace);
        soapBodyElem23.addTextNode(this.consumerId);
        SOAPElement soapBodyElem24 = soapBodyElem.addChildElement("receiverPhone", myNamespace);
        soapBodyElem24.addTextNode(this.receiverPhone);
        SOAPElement soapBodyElem25 = soapBodyElem.addChildElement("mgiTransactionSessionID", myNamespace);
        soapBodyElem25.addTextNode(this.mgiTransactionSessionID);
        SOAPElement soapBodyElem26 = soapBodyElem.addChildElement("formFreeStaging", myNamespace);
        soapBodyElem26.addTextNode(this.formFreeStaging);
        SOAPElement soapBodyElem27 = soapBodyElem.addChildElement("receivePurposeOfTransaction", myNamespace);
        soapBodyElem27.addTextNode(this.receivePurposeOfTransaction);
        SOAPElement soapBodyElem28 = soapBodyElem.addChildElement("relationshipToSender", myNamespace);
        soapBodyElem28.addTextNode(this.relationshipToSender);
        SOAPElement soapBodyElem29 = soapBodyElem.addChildElement("receiverGender", myNamespace);
        soapBodyElem29.addTextNode(this.receiverGender);
        SOAPElement soapBodyElem30 = soapBodyElem.addChildElement("receiverPhoneCountryCode", myNamespace);
        soapBodyElem30.addTextNode(this.receiverPhoneCountryCode);
        

        return;
    }
            
            
    
    
    public SOAPMessage getResponse() {
        // Return Null if got any exception, else return SOAPMessage Object
        SOAPMessage response = callSoapWebService(soapEndpointUrl, soapAction);
        return response;
    }

}

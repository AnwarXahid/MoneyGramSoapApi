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
    public ReceiveValidation(Credential cdt, ReceiverInfo rcv_info, ApiResponse api_res) {
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
        this.consumerId = cdt.getConsumerId();
        this.formFreeStaging = cdt.getFormFreeStaging();
        
        // ReceiverInfo Properties
        this.receiverAddress = rcv_info.getReceiverAddress();
        this.receiverCity = rcv_info.getReceiverCity();
        this.receiverCountry = rcv_info.getReceiverCountry();
        this.receiverPhotoIdType = rcv_info.getReceiverPhotoIdType();
        this.receiverPhotoIdNumber = rcv_info.getReceiverPhotoIdNumber();
        this.receiverPhotoIdCountry = rcv_info.getReceiverPhotoIdCountry();
        this.receiverDOB = rcv_info.getReceiverDOB();
        this.receiverBirthCountry = rcv_info.getReceiverBirthCountry();
        this.receiverPhone = rcv_info.getReceiverPhone();
        this.receivePurposeOfTransaction = rcv_info.getReceivePurposeOfTransaction(); 
        this.relationshipToSender = rcv_info.getRelationshipToSender(); 
        this.receiverGender = rcv_info.getReceiverGender(); 
        this.receiverPhoneCountryCode = rcv_info.getReceiverPhoneCountryCode(); 
        
        // Fetch from ReferenceNumberLookUp
        this.receiveCurrency = api_res.getPayout_currency(); 
        this.agentCheckNumber = api_res.getAgentCheckNumber(); 
        this.agentCheckAmount = api_res.getAgentCheckAmount(); 
        this.customerCheckNumber = api_res.getCustomerCheckNumber(); 
        this.customerCheckAmount = api_res.getCustomerCheckAmount();
        this.mgiTransactionSessionID = api_res.getPay_token_id();
        
        
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
        String myNamespaceURI = "http://www.moneygram.com/AgentConnect1512";

        // Writing SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

        // Writing SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("receiveValidationRequest", myNamespace, myNamespaceURI);
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

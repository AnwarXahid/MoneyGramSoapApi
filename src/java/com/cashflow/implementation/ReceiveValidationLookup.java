package com.cashflow.implementation;

import javax.xml.soap.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/


public class ReceiveValidationLookup {
    // Property of ReceiveValidationLookUp
    private boolean api_calling;
    
    private String readyForCommit;
    
    // Writing Constructor Function

    public ReceiveValidationLookup(Credential cdt) {
        this.readyForCommit = "false";
        
        try {
            SOAPMessage responseMessage = new ReceiveValidation(cdt).getResponse();
            SOAPPart sp = responseMessage.getSOAPPart();
            SOAPEnvelope se = sp.getEnvelope();
            SOAPBody soap_body = se.getBody();
            Node responseMsg = soap_body.getFirstChild();
            NodeList message = responseMsg.getChildNodes();
            for(int  i = 0; i < message.getLength(); ++i) {
                String nodeName = message.item(i).getNodeName();
                String nodeValue = message.item(i).getTextContent();
                  
                if(nodeName.equals("ac:readyForCommit")) {
                    this.readyForCommit = nodeValue;
                }
            }
            
            this.api_calling = true;
        } catch (Exception e) {
            this.api_calling = false;
            System.out.println("ReceiveValidationLookUp::constructorFunction:- "+e.toString());
        }
    }
    
    
    public boolean getReadyForCommit() {
        return this.readyForCommit.equalsIgnoreCase("true");
    }
    
    public boolean getSuccessfullCalling() {
        return this.api_calling;
    }
}

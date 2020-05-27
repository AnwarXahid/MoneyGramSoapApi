package com.cashflow.implementation;

import javax.xml.soap.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/


public class CommitTransactionLookUp {
    // Property of CommitTransactionLookUp
    private boolean api_calling;
    private String error_message;
    private String api_err_calling;
    
    private String code;
    private String expectedDateOfDelivery;
    private String transactionDateTime;
    
    // Writing Constructor Function

    public CommitTransactionLookUp(Credential cdt, ApiResponse api_res) {
        this.api_err_calling = "false";
        
        try {
            SOAPMessage responseMessage = new CommitTransaction(cdt, api_res).getResponse();
            SOAPPart sp = responseMessage.getSOAPPart();
            SOAPEnvelope se = sp.getEnvelope();
            SOAPBody soap_body = se.getBody();
            Node responseMsg = soap_body.getFirstChild();
            NodeList message = responseMsg.getChildNodes();
            for(int  i = 0; i < message.getLength(); ++i) {
                String nodeName = message.item(i).getNodeName();
                String nodeValue = message.item(i).getTextContent();
                  
                if(nodeName.equals("ac:flags")) {
                    this.code = nodeValue;
                } else if (nodeName.equals("ac:expectedDateOfDelivery")) {
                    this.expectedDateOfDelivery = nodeValue;
                } else if (nodeName.equals("ac:transactionDateTime")) {
                    this.transactionDateTime = nodeValue;
                } else if (nodeName.equals("detail")) {
                    // Handling error in api calling
                    Node err = message.item(i).getFirstChild().getFirstChild();
                    NodeList err_message = err.getChildNodes();
                    for(int  j = 0; j < err_message.getLength(); ++j) {
                        String err_nodeName = err_message.item(j).getNodeName();
                        String err_nodeValue = err_message.item(j).getTextContent();
                
                        if (err_nodeName.equals("ac:errorString")) {
                            this.error_message = err_nodeValue;
                            this.api_err_calling = "true";
                        }
                    }
                    
                }
            }
            
            this.api_calling = true;
        } catch (Exception e) {
            this.api_calling = false;
            System.out.println("CommitTransactionLookUp::constructorFunction:- "+e.toString());
        }
    }
    
    
    public String getCode() {
        return this.code;
    }
    
    public String getExpectedDateOfDelivery() {
        return this.expectedDateOfDelivery;
    }
    
    public String getTranactionDateTime() {
        return this.transactionDateTime;
    }
    
    public String getErrorMessage() {
        return this.error_message;
    }
    
    public boolean getErrorCalling() {
        return this.api_err_calling.equalsIgnoreCase("true");
    }
    
    public boolean getSuccessfullCalling() {
        return this.api_calling;
    }
}

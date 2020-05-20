package com.cashflow.implementation;

import javax.xml.soap.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/


public class ReferenceNumberLookup {
    // Property of ReferenceNumberLookUp
    private boolean api_calling;
    private String ok_for_agent;
    private String ok_for_pickup;
    
    
    private String code;
    private String refno; 
    private String sender_first_name; 
    private String sender_last_name;
    private String sender_mobile;
    private String sender_country;  
    private String receiver_first_name; 
    private String receiver_last_name; 
    private String payout_amount;  
    private String payout_currency;  
    private String txn_date; 
    private String status;   
    
    
    
    // Writing constructor function
    public ReferenceNumberLookup(Credential cdt) {
        this.ok_for_agent = "false";
        this.ok_for_pickup = "false";
        
        try {
            SOAPMessage responseMessage = new ReferenceNumber(cdt).getResponse();
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
                } else if(nodeName.equals("ac:senderFirstName")) {
                    this.sender_first_name = nodeValue;
                } else if(nodeName.equals("ac:senderLastName")) {
                    this.sender_last_name = nodeValue;
                } else if(nodeName.equals("ac:referenceNumber")) {
                    this.refno = nodeValue;
                } else if(nodeName.equals("ac:receiverFirstName")) {
                    this.receiver_first_name = nodeValue;
                } else if(nodeName.equals("ac:receiverLastName")) {
                    this.receiver_last_name = nodeValue;
                } else if(nodeName.equals("ac:senderHomePhone")) {
                    this.sender_mobile = nodeValue;
                } else if(nodeName.equals("ac:originatingCountry")) {
                    this.sender_country = nodeValue;
                } else if(nodeName.equals("ac:receiveCurrency")) {
                    this.payout_currency = nodeValue;
                } else if(nodeName.equals("ac:receiveAmount")) {
                    this.payout_amount = nodeValue;
                } else if(nodeName.equals("ac:dateTimeSent")) {
                    this.txn_date = nodeValue;
                } else if(nodeName.equals("ac:transactionStatus")) {
                    this.status = nodeValue;
                } else if (nodeName.equals("ac:okForAgent")) {
                    this.ok_for_agent = nodeValue;
                } else if (nodeName.equals("ac:okForPickup")) {
                    this.ok_for_pickup = nodeValue;
                }

            }
            
            this.api_calling = true;
        } catch (Exception e) {
            this.api_calling = false;
            System.out.println("ReferenceNumberLookUp::constructorFunction:- "+e.toString());
        }
    }
    
    
    public String getCode() {
        return this.code;
    }
    
    public String getSenderName() {
        return this.sender_first_name + " " + this.sender_last_name;
    }
    
    public String getReferenceNumber() {
        return this.refno;
    }
    
    public String getReceiverName() {
        return this.receiver_first_name + " " + this.receiver_last_name;
    }
    
    public String getSenderCountry() {
        return this.sender_country;
    }
    
    public String getSenderMobile() {
        return this.sender_mobile;
    }
    
    public String getPayoutCurrency() {
        return this.payout_currency;
    }
    
    public String getPayoutAmount() {
        return this.payout_amount;
    }
    
    public String getTnxDate() {
        return this.txn_date;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public boolean getOkForAgent() {
        return this.ok_for_agent.equalsIgnoreCase("true");
    }
    
    public boolean getOkForPickup() {
        return this.ok_for_pickup.equalsIgnoreCase("true");
    }
    
    public boolean getSuccessfullCalling() {
        return this.api_calling;
    }
}
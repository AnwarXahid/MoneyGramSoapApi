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
    private String api_err_calling;
    
    
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
    private String mgiTransID;
    private String agent_check_number;
    private String agent_check_amount;
    private String cus_check_num;
    private String cus_check_amount;
    private String error_message;
    
    
    
    // Writing constructor function
    public ReferenceNumberLookup(Credential cdt) {
        this.ok_for_agent = "false";
        this.ok_for_pickup = "false";
        this.api_err_calling = "false";
        
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
                } else if (nodeName.equals("ac:mgiTransactionSessionID")) {
                    this.mgiTransID = nodeValue;
                } else if (nodeName.equals("ac:agentCheckNumber")) {
                    this.agent_check_number = nodeValue;
                } else if (nodeName.equals("ac:agentCheckAmount")) {
                    this.agent_check_amount = nodeValue;
                } else if (nodeName.equals("ac:customerCheckNumber")) {
                    this.cus_check_num = nodeValue;
                } else if (nodeName.equals("ac:customerCheckAmount")) {
                    this.cus_check_amount = nodeValue;
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
    
    public String getmgiTansID() {
        return this.mgiTransID;
    }
    
    public String getAgentCheckNumber() {
        return this.agent_check_number;
    }
    
    public String getAgentCheckAmount() {
        return this.agent_check_amount;
    }
    
    public String getCustomerCheckNumber() {
        return this.cus_check_num;
    }
    
    public String getCustomerCheckAmount() {
        return this.cus_check_amount;
    }
    
    public boolean getOkForAgent() {
        return this.ok_for_agent.equalsIgnoreCase("true");
    }
    
    public boolean getOkForPickup() {
        return this.ok_for_pickup.equalsIgnoreCase("true");
    }
    
    public boolean getTransactionAvailability() {
        return this.status.equalsIgnoreCase("AVAIL");
    }
    
    
    public boolean getTransactionRcvedStatus() {
        return this.status.equalsIgnoreCase("RECVD");
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
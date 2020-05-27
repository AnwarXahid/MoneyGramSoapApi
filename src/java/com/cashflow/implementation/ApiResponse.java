package com.cashflow.implementation;


/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/



public class ApiResponse {

private String code;
private String response_code;
private String refno;
private String agent_session_id;
private String send_agent;
private String sender_name;
private String sender_address;
private String sender_mobile;
private String sender_city;
private String sender_country;
private String sender_id;
private String sender_type;
private String sender_nationality;
private String sender_dob;
private String receiver_name;
private String receiver_address;
private String receiver_country;
private String payout_amount;
private String payout_currency;
private String payment_type;
private String txn_date;
private String pay_token_id; // mgi transaction id
private String message;
private String confirm_id;
private String status;
private String paid_date;
private String paid_by;


// modified by xahid
private String agentCheckNumber; 
private String agentCheckAmount; 
private String customerCheckNumber;  
private String customerCheckAmount;



public ApiResponse() {
    this.code="";
    this.response_code="";
    this.refno="";
    this.agent_session_id="";
    this.send_agent="";
    this.sender_name="";
    this.sender_address="";
    this.sender_mobile="";
    this.sender_city="";
    this.sender_country="";
    this.sender_id="";
    this.sender_type="";
    this.sender_nationality="";
    this.sender_dob="";
    this.receiver_name="";
    this.receiver_address="";
    this.receiver_country="";
    this.payout_amount="";
    this.payout_currency="";
    this.payment_type="";
    this.txn_date="";
    this.pay_token_id=""; // mgi transaction id
    this.message="";
    this.confirm_id="";
    this.status="";
    this.paid_date="";
    this.paid_by="";
    
    
    // modified by xahid
    this.agentCheckNumber = "";
    this.agentCheckAmount = "";
    this.customerCheckNumber = "";
    this.customerCheckAmount = "";
}




public String getCode() {
return code;
}
public void setCode(String code) {
this.code = code;
}
public String getResponse_code() {
return response_code;
}
public void setResponse_code(String response_code) {
this.response_code = response_code;
}
public String getRefno() {
return refno;
}
public void setRefno(String refno) {
this.refno = refno;
}
public String getAgent_session_id() {
return agent_session_id;
}
public void setAgent_session_id(String agent_session_id) {
this.agent_session_id = agent_session_id;
}
public String getSend_agent() {
return send_agent;
}
public void setSend_agent(String send_agent) {
this.send_agent = send_agent;
}
public String getSender_name() {
return sender_name;
}
public void setSender_name(String sender_name) {
this.sender_name = sender_name;
}
public String getSender_address() {
return sender_address;
}
public void setSender_address(String sender_address) {
this.sender_address = sender_address;
}
public String getSender_mobile() {
return sender_mobile;
}
public void setSender_mobile(String sender_mobile) {
this.sender_mobile = sender_mobile;
}
public String getSender_city() {
return sender_city;
}
public void setSender_city(String sender_city) {
this.sender_city = sender_city;
}
public String getSender_country() {
return sender_country;
}
public void setSender_country(String sender_country) {
this.sender_country = sender_country;
}
public String getSender_id() {
return sender_id;
}
public void setSender_id(String sender_id) {
this.sender_id = sender_id;
}
public String getSender_type() {
return sender_type;
}
public void setSender_type(String sender_type) {
this.sender_type = sender_type;
}
public String getSender_nationality() {
return sender_nationality;
}
public void setSender_nationality(String sender_nationality) {
this.sender_nationality = sender_nationality;
}
public String getSender_dob() {
return sender_dob;
}
public void setSender_dob(String sender_dob) {
this.sender_dob = sender_dob;
}
public String getReceiver_name() {
return receiver_name;
}
public void setReceiver_name(String receiver_name) {
this.receiver_name = receiver_name;
}
public String getReceiver_address() {
return receiver_address;
}
public void setReceiver_address(String receiver_address) {
this.receiver_address = receiver_address;
}
public String getReceiver_country() {
return receiver_country;
}
public void setReceiver_country(String receiver_country) {
this.receiver_country = receiver_country;
}
public String getPayout_amount() {
return payout_amount;
}
public void setPayout_amount(String payout_amount) {
this.payout_amount = payout_amount;
}
public String getPayout_currency() {
return payout_currency;
}
public void setPayout_currency(String payout_currency) {
this.payout_currency = payout_currency;
}
public String getPayment_type() {
return payment_type;
}
public void setPayment_type(String payment_type) {
this.payment_type = payment_type;
}
public String getTxn_date() {
return txn_date;
}
public void setTxn_date(String txn_date) {
this.txn_date = txn_date;
}
public String getPay_token_id() {
return pay_token_id;
}
public void setPay_token_id(String pay_token_id) {
this.pay_token_id = pay_token_id;
}
public String getMessage() {
return message;
}
public void setMessage(String message) {
this.message = message;
}
public String getConfirm_id() {
return confirm_id;
}
public void setConfirm_id(String confirm_id) {
this.confirm_id = confirm_id;
}
public String getStatus() {
return status;
}
public void setStatus(String status) {
this.status = status;
}
public String getPaid_date() {
return paid_date;
}
public void setPaid_date(String paid_date) {
this.paid_date = paid_date;
}
public String getPaid_by() {
return paid_by;
}
public void setPaid_by(String paid_by) {
this.paid_by = paid_by;
}



// Modified by Xahid

    
    public void setAgentCheckNumber(String agentCheckNumber) {
        this.agentCheckNumber = agentCheckNumber;
    }
    
    public String getAgentCheckNumber() {
        return this.agentCheckNumber;
    }
    
    
    public void setAgentCheckAmount(String agentCheckAmount) {
        this.agentCheckAmount = agentCheckAmount;
    }
    
    public String getAgentCheckAmount() {
        return this.agentCheckAmount;
    }
    
    
    public void setCustomerCheckNumber(String customerCheckNumber) {
        this.customerCheckNumber = customerCheckNumber;
    }
    
    public String getCustomerCheckNumber() {
        return this.customerCheckNumber;
    }
    
    
    public void setCustomerCheckAmount(String customerCheckAmount) {
        this.customerCheckAmount = customerCheckAmount;
    }
    
    public String getCustomerCheckAmount() {
        return this.customerCheckAmount;
    }
}
package com.cashflow.implementation;



/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/



public class ReceiverInfo {
    private  String receiverAddress;
    private  String receiverCity;
    private  String receiverCountry;
    private  String receiverPhotoIdType;
    private  String receiverPhotoIdNumber;
    private  String receiverPhotoIdCountry;
    private  String receiverDOB;
    private  String receiverBirthCountry;
    private  String receiverPhone;
    private  String receivePurposeOfTransaction;
    private  String relationshipToSender;
    private  String receiverGender;
    private  String receiverPhoneCountryCode;
    
    
    
    
    // Writing Constructor Function
    public ReceiverInfo() {
        this.receiverAddress = ""; 
        this.receiverCity = "";    
        this.receiverCountry = "";   
        this.receiverPhotoIdType = "";   
        this.receiverPhotoIdNumber = "";   
        this.receiverPhotoIdCountry = "";    
        this.receiverDOB = "";    
        this.receiverBirthCountry = "";  
        this.receiverPhone = "";
        this.receivePurposeOfTransaction = "";
        this.relationshipToSender = ""; 
        this.receiverGender = "";
        this.receiverPhoneCountryCode = "";   
    }
    
    
    // Writing Setter and Getter Functions
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
    
    public String getReceiverAddress() {
        return this.receiverAddress;
    }
    
    
    
    
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }
    
    public String getReceiverCity() {
        return this.receiverCity;
    }
    
    
    
    
    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }
    
    public String getReceiverCountry() {
        return this.receiverCountry;
    }
    
    
    
    
    public void setReceiverPhotoIdType(String receiverPhotoIdType) {
        this.receiverPhotoIdType = receiverPhotoIdType;
    }
    
    public String getReceiverPhotoIdType() {
        return this.receiverPhotoIdType;
    }
    
    
    
    
    public void setReceiverPhotoIdNumber(String receiverPhotoIdNumber) {
        this.receiverPhotoIdNumber = receiverPhotoIdNumber;
    }
    
    public String getReceiverPhotoIdNumber() {
        return this.receiverPhotoIdNumber;
    }
    
    
    
    
    public void setReceiverPhotoIdCountry(String receiverPhotoIdCountry) {
        this.receiverPhotoIdCountry = receiverPhotoIdCountry;
    }
    
    public String getReceiverPhotoIdCountry() {
        return this.receiverPhotoIdCountry;
    }
    
    
    
    
    public void setReceiverDOB(String receiverDOB) {
        this.receiverDOB = receiverDOB;
    }
    
    public String getReceiverDOB() {
        return this.receiverDOB;
    }
    
    
    
    public void setReceiverBirthCountry(String receiverBirthCountry) {
        this.receiverBirthCountry = receiverBirthCountry;
    }
    
    public String getReceiverBirthCountry() {
        return this.receiverBirthCountry;
    }
    
    
    
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
    
    public String getReceiverPhone() {
        return this.receiverPhone;
    }
    
    
    
    public void setReceivePurposeOfTransaction(String receivePurposeOfTransaction) {
        this.receivePurposeOfTransaction = receivePurposeOfTransaction;
    }
    
    public String getReceivePurposeOfTransaction() {
        return this.receivePurposeOfTransaction;
    }
    
    
    
    public void setRelationshipToSender(String relationshipToSender) {
        this.relationshipToSender = relationshipToSender;
    }
    
    public String getRelationshipToSender() {
        return this.relationshipToSender;
    }
    
    
    
    public void setReceiverGender(String receiverGender) {
        this.receiverGender = receiverGender;
    }
    
    public String setReceiverGender() {
        return this.receiverGender;
    }
    
    
    
    public void setReceiverPhoneCountryCode(String receiverPhoneCountryCode) {
        this.receiverPhoneCountryCode = receiverPhoneCountryCode;
    }
    
    public String getReceiverPhoneCountryCode() {
        return this.receiverPhoneCountryCode;
    }
}
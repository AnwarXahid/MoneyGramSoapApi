package com.cashflow.implementation;


/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/


public class MoneygramCash {
    
    public static void main(String[] args) {
        Credential cdt = new Credential();
        ReceiverInfo rcv_info = new ReceiverInfo();
        
        ApiResponse api_res_check = payTxnCheck(cdt);
        System.err.println(api_res_check.getMessage());
        
        ApiResponse api_res_confirm = payTxnConfirm(cdt, rcv_info, api_res_check);
        System.err.println(api_res_confirm.getMessage());
    }
    
    
    
    
    private static ApiResponse payTxnCheck(Credential cdt) {
        ReferenceNumberLookup ref_num_lookup = new ReferenceNumberLookup(cdt);
        ApiResponse api_res = new ApiResponse();
        
        
        if(ref_num_lookup.getSuccessfullCalling()) {
            if (!ref_num_lookup.getErrorCalling()) {
                if (ref_num_lookup.getOkForAgent() && ref_num_lookup.getOkForPickup()) {
                    api_res.setCode(ref_num_lookup.getCode());
                    api_res.setSender_name(ref_num_lookup.getSenderName());
                    api_res.setReceiver_name(ref_num_lookup.getReceiverName());
                    api_res.setRefno(ref_num_lookup.getReferenceNumber());
                    api_res.setSender_country(ref_num_lookup.getSenderCountry());
                    api_res.setSender_mobile(ref_num_lookup.getSenderMobile());
                    api_res.setPayout_currency(ref_num_lookup.getPayoutCurrency());
                    api_res.setPayout_amount(ref_num_lookup.getPayoutAmount());
                    api_res.setTxn_date(ref_num_lookup.getTnxDate());
                    api_res.setStatus(ref_num_lookup.getStatus());
                    api_res.setPay_token_id(ref_num_lookup.getmgiTansID());
                    api_res.setAgentCheckNumber(ref_num_lookup.getAgentCheckNumber());
                    api_res.setAgentCheckAmount(ref_num_lookup.getAgentCheckAmount());
                    api_res.setCustomerCheckNumber(ref_num_lookup.getCustomerCheckNumber());
                    api_res.setCustomerCheckAmount(ref_num_lookup.getCustomerCheckAmount());

                    api_res.setMessage("Transaction is available to pick-up for this Agent.");
                    api_res.setResponse_code("1");
                } else {
                    api_res.setMessage("Transaction is not available to pick-up for this Agent!!!!");
                    api_res.setResponse_code("0");
                }
            } else {
                api_res.setMessage(ref_num_lookup.getErrorMessage());
                api_res.setResponse_code("0");
            }
        } else {
            api_res.setMessage("MoneyGram Server is not responding!!!!");
            api_res.setResponse_code("0");
        }
        
        return api_res;
    }
    
    
    private static ApiResponse payTxnConfirm(Credential cdt, ReceiverInfo rcv_info, ApiResponse api_response) {
        // Intantiate receiveValidation Class
        ReceiveValidationLookup rcv_val = new ReceiveValidationLookup(cdt, rcv_info, api_response);
        // Instantiate ApiResponse Class
        ApiResponse api_res = new ApiResponse();
        
        // Set the property of api_res object
        if(rcv_val.getSuccessfullCalling()) {
            if(!rcv_val.getErrorCalling()) {
                if (rcv_val.getReadyForCommit()) {
                    CommitTransactionLookUp com_trans = new CommitTransactionLookUp(cdt, api_response);
                    if (com_trans.getSuccessfullCalling()) {
                        if (!com_trans.getErrorCalling()) {
                            api_res.setCode(com_trans.getCode());

                            api_res.setMessage("Successfully committed the transaction and ready to print the receipt.");
                            api_res.setResponse_code("1");
                        } else {
                            api_res.setMessage(com_trans.getErrorMessage());
                            api_res.setResponse_code("0");
                        }
                    } else {
                        api_res.setMessage("Server is not responding!!!! Transaction commit FAILED!!!!");
                        api_res.setResponse_code("0");
                    }
                } else {
                    api_res.setMessage("Transaction is not ready for commit!!!!");
                    api_res.setResponse_code("0");
                }
            } else {
                api_res.setMessage(rcv_val.getErrorMessage());
                api_res.setResponse_code("0");
            }
        } else {
            api_res.setMessage("Server is not responding!!!!");
            api_res.setResponse_code("0");
        }
        
        return api_res;
    }
}

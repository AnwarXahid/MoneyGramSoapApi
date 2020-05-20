package com.cashflow.implementation;


/**
 *
 * @author Anwar Hossain Zahid
 * 
 **/


public class MoneygramCash {
    
    public static void main(String[] args) {
        Credential cdt = new Credential();
        
        ApiResponse api_res_check = payTxnCheck(cdt);
        System.err.println(api_res_check.getMessage());
        
        //ApiResponse api_res_confirm = payTxnConfirm(reference_number);
        //System.err.println(api_res_confirm.getMessage());
    }
    
    private static ApiResponse payTxnCheck(Credential cdt) {
        ReferenceNumberLookup ref_num_lookup = new ReferenceNumberLookup(cdt);
        ApiResponse api_res = new ApiResponse();
        
        
        if(ref_num_lookup.getSuccessfullCalling()) {
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
            
            api_res.setMessage("Successfully called payTxnCheck Function.");
            api_res.setResponse_code("1");
            } else {
                api_res.setMessage("Can't pick up money with this agent!!!!");
                api_res.setResponse_code("0");
            }
        } else {
            api_res.setMessage("MoneyGram Server is not responding!!!!");
            api_res.setResponse_code("0");
        }
        
        return api_res;
    }
    
    
//    private static ApiResponse payTxnConfirm(String reference_number) {
//        // Intantiate receiveValidation Class
//        ReceiveValidationLookUp rcv_val = new ReceiveValidationLookUp(reference_number);
//        // Instantiate ApiResponse Class
//        ApiResponse api_res = new ApiResponse();
//        
//        // Set the property of api_res object
//        if(rcv_val.getSuccessfullCalling()) {
//            if (rcv_val.getReadyForCommit()) {
//                CommitTransactionLookUp com_trans = new CommitTransactionLookUp();
//                if(com_trans.getSuccessfullCalling()) {
//                    api_res.setCode(com_trans.getCode());
//                    
//                    api_res.setMessage("Successfully called payTxnConfirm Function.");
//                    api_res.setResponse_code("0");
//                } else {
//                    api_res.setMessage("Can't commit the transaction!!!!");
//                    api_res.setResponse_code("1");
//                }
//            } else {
//                api_res.setMessage("Transaction is not ready for  commit!!!!");
//                api_res.setResponse_code("1");
//            }
//        } else {
//            api_res.setMessage("Can't validate the transaction!!!!");
//            api_res.setResponse_code("1");
//        }
//        
//        return api_res;
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashflow.implementation;

/**
 *
 * @author Xahid's PC
 */
public class Demo {
    public static String date = "1999-02-04";
    public static String dates[];
    public static void main(String[] args) {
        dates = date.split("-");
        System.out.println(dates[0]+ "  " + dates[1]+ " " + dates[2]);
        Credential cdt = new Credential();
        GetFieldsForProduct GFFP = new GetFieldsForProduct(cdt, "9887.22");
        GFFP.getResponse();
    }
}

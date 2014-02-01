/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Michele
 */
public class NumericInputFieldValidation implements InputFieldValidationService {
    private final static String ERROR_MSG = "Invalid Entry-Non Numeric Value";
    

    @Override
    public String validateField(String input) throws Exception {
        double numberTest;
        try{
        if (input == null){
        input = "0";
        }else{
        numberTest=Double.parseDouble(input);
        }
        return input;
        }catch (NumberFormatException ex){
                
        return ERROR_MSG;
         }}
    }
    


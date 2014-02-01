/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Michele
 */
public class AreaCalculator {
private final static double PI = 3.14159;
private final static DecimalFormat df = new DecimalFormat("#.####");
private final InputFieldValidationService validate = new NumericInputFieldValidation();
private double radius;
private double length;
private double width;
private double side1;
private double side2;
private String input;
private HttpServletRequest request;


public HttpServletRequest calculateAreas(HttpServletRequest request) throws Exception{
this.request=request;

radius=validateField("radius");
length=validateField("length");
width=validateField("width");
side1=validateField("side1");
side2=validateField("side2");

String circleReturnMsg = calculateCircleArea(radius);
String rectangleReturnMsg = calculateRectangleArea(length,width);
String triangleReturnMsg = calculateTriangleArea(side1,side2);
request.setAttribute("circleArea", circleReturnMsg);
request.setAttribute("rectangleArea",rectangleReturnMsg);
request.setAttribute("triangleArea",triangleReturnMsg);
    
return request;
}  


private String calculateCircleArea(double radius){
String circleMessage;
if (radius != 0){
String area = df.format(Math.pow(radius,2)*PI);
circleMessage = "The area of a circle with a radius of "+radius+" is "+area+".";
}else{
circleMessage = "Insufficient information was entered.  Circle area was not calculated";
}
return circleMessage;
} 

private String calculateRectangleArea(double length, double width){
String rectangleMessage;
if (length !=0 && width !=0){
String area = df.format(length*width);
rectangleMessage = "The area of the rectangle with a length of "+length+" and a "
        + "width of "+width+" is "+area+".";
}else{
rectangleMessage = "Insufficent information was entered.  Rectangle area was "
        + "not calculated";
}
return rectangleMessage;
}

private String calculateTriangleArea(double side1, double side2){
String triangleMessage;
if(side1 !=0 || side2 != 0){
double side3 = Math.sqrt((Math.pow(side1, 2))/(Math.pow((side2*.5), 2)));
String area = df.format((side2*.5)*side3);
triangleMessage = "The area of a triangle with a base of "+side2+" and a height"
        + " of "+side3+" is "+area+".";
}else{
triangleMessage = "Insufficent information was entered.  Triangle area was "
        + "not calculated";
}
return triangleMessage;
}

private Double validateField (String input) throws Exception{
Double convertedInput=0.0;
input=request.getParameter(input);
 
    try {
        convertedInput=Double.parseDouble(validate.validateField(input));
    } catch (Exception ex) {
        Logger.getLogger(AreaCalculator.class.getName()).log(Level.SEVERE, null, ex);
    }
return convertedInput;
}


    public static void main(String[] args) {
        AreaCalculator calc = new AreaCalculator();
        String result1 = calc.calculateTriangleArea(5, 8);
        //String result = calc.calculateRectangleArea(10.0, 15.0);
        System.out.println(result1);
    }


    
}

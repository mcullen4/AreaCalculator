<%-- 
    Document   : areaCalculator
    Created on : Jan 31, 2014, 1:48:49 PM
    Author     : Michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area Calculator</title>
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.0/jquery.validate.min.js"></script>
        <script src="areaCalculatorClientSideValidation.js"></script>
    </head>
   <body id="body" class="body">
       <%
           
       %>
        <div id="container" class="container">
            <div id="header" class="header"></div>
            <div id="content" class="content">
                <form id="form1" name="form1" method="POST" action="CalcControl">
                <table>
                    <tr>
                        <td><img src="Circle.png" alt="Image Not Available"></td>
                        <td><input type="text" id="radius" name="radius" placeholder="Radius"></td>
                        <td></td>
                        <td><p>${circleArea}</p></td>
                    </tr> 
                    <tr>
                        <td><img src="Triangle.png" alt="Image Not Available"></td>
                        <td><input type="text" id="side1" name="side1" placeholder="Side 1"></td>
                        <td><input type="text" id="side2" name="side2" placeholder="Side 2"></td>
                        <td><p>${triangleArea}</p></td>
                    </tr> 
                    <tr>
                        <td><img src="Rectangle.png" alt="Image Not Available"></td>
                        <td><input type="text" id="length" name="length" placeholder="Length"></td>
                        <td><input type="text" id="width" name="width" placeholder="Width"></td>
                        <td><p>${rectangleArea}</p></td>
                    </tr> </table>
                    <table>
                    <tr class="submit"><td><input type="submit" class="submit" id="calculateArea" name="calculateArea" value="Calculate Area(s)"></td></tr>
                </table>
                </form>
                
            </div>
 
        </div>
    </body>
</html>

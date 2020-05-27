<%-- 
    Document   : index
    Created on : May 20, 2020, 11:34:48 AM
    Author     : fahmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Title Page</title>
    </head>
    <body>
        <h1>MoneyGram Cash Receive</h1>
        <p>Input the following fields:</p>
        <form action="/message.jsp" target="_blank" method="post">
            <label for="radd">Receiver Address:</label><br>
            <input type="text" id="radd" name="radd"><br>
            
            <label for="rcity">Receiver City:</label><br>
            <input type="text" id="rcity" name="rcity">
            
            <label for="rgender">Receiver Gender:</label><br>
            <input type="radio" id="male" name="gender" value="male">
            <label for="male">Male</label><br>
            <input type="radio" id="female" name="gender" value="female">
            <label for="female">Female</label><br>
            <input type="radio" id="other" name="gender" value="other">
            <label for="other">Other</label><br>
            
            <input type="submit" value="Submit">
        </form>
    </body>
</html>

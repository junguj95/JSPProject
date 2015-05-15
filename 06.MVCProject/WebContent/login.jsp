<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    <h1>로그인</h1>
    <hr>
    
    <form action ="login" method="post">
    	<label for="id">아이디 : </label>
    	<input type = "text" name = "id" id="id" ><br>
    <label for="pwd">비밀번호 : </label>
    	<input type = "password" name ="pwd" id="pwd"><br>
    	<input type = "submit" value="로그인">
    </form>
    
    
    </body>
    </html>
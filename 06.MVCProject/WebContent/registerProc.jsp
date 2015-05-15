<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="exam.dao.*, exam.dto.*" %>
    <%
    String id = request.getParameter("id");
	//out.print(id);
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
    
	
    MemberDAO dao = new MemberDAO();
    
    Member member = new Member(); //캐리어 역할 멤버 객체를 만들어서
    
    member.setId(id); //값 저장
    member.setPwd(pwd);
    member.setName(name);
    member.setGender(gender);
    member.setAge(Integer.parseInt(age));
    member.setAddr(addr);
    
    //3. SQL문 실행
    dao.insertMember(member); //보내기
    
    
    
    
    %>
    <!DOCTYPE html>
    
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    
    </body>
    </html>
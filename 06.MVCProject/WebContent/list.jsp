<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ page import = "exam.dao.*" %>
  <%@ page import = "exam.dto.*" %>
  <%@ page import = "java.util.*" %>
    <!DOCTYPE html>
    
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    <h1>회원리스트</h1>
    <hr>
    <%
    
    	MemberDAO dao = new MemberDAO();
    List<Member> list = dao.listMember();
    
    %>
    
    <table border = "1">
    	<tr>
    		<td>아이디 </td>
    		<th>이름 </th>
    		<td>나이	</td>
    		</tr>
    		<%
    		for(int i=0; i<list.size(); i++){
    			
    			Member m = list.get(i);
    		%>
    			
    			<tr>
    				<td><%= m.getId() %></td>
    				<td><%= m.getName() %></td>
    				<td><%= m.getAge() %></td>
    			</tr>
    		<%
    			
    		}
    		%>
    </table>
    
    </body>
    </html>
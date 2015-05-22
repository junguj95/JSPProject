<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet Example</title>
		<link rel="Stylesheet" type="text/css" href="../css/bootstrap.css"></link>
	</head>
	
	<body>
		<!-- 메뉴 시작  -->
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">게시판관리</a>
		    </div>
		
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="#">글쓰기<span class="sr-only">(current)</span></a></li>
		        <li><a href="list.jsp">리스트</a></li>
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<!-- 게시판 글쓰기  시작  -->
		<form class="form-horizontal">
		  <fieldset>
		    <legend>게시판 수정 </legend>
		    
		    <div class="form-group">
		      <label for="inputEmail" class="col-lg-2 control-label">이름 : </label>
		      <div class="col-lg-10">
		        <input type="text" class="form-control" id="subject" placeholder="이름을 입력하세요.">
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label for="inputEmail" class="col-lg-2 control-label">제목 : </label>
		      <div class="col-lg-10">
		        <input type="text" class="form-control" id="subject" placeholder="제목을 입력하세요.">
		      </div>
		    </div>
		   
		    <div class="form-group">
		      <label for="textArea" class="col-lg-2 control-label">내용 : </label>
		      <div class="col-lg-10">
		        <textarea class="form-control" rows="10" id="textArea"></textarea>
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label for="file" class="col-lg-2 control-label">첨부파일 : </label>
		      <div class="col-lg-10">
		        <input type="file" class="form-control" id="file" placeholder="파일을 선택하세요.">
		      </div>
		    </div>
		    
		    
		    <div class="form-group">
		      <div class="col-lg-10 col-lg-offset-2">
		        <button type="reset" class="btn btn-default">취소</button>
		        <button type="submit" class="btn btn-primary">글쓰기</button>
		      </div>
		    </div>
		  </fieldset>
		</form>
	</body>
</html>
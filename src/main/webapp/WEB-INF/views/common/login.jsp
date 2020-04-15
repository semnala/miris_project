<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.6">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <style>
    .form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
<title>HRMS</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form class="form-signin" method="post">
  	<h1 class="h3 mb-3 font-weight-normal">Human Resource Management System</h1>
  	<label for="inputEmail" class="sr-only">Email address</label>
  	<input type="text" id="id" name="id" class="form-control" placeholder="Email address" required autofocus>
  	<label for="inputPassword" class="sr-only">Password</label>
  	<input type="password" id="passwd" name="passwd" class="form-control" placeholder="Password" required>
  		<div class="checkbox mb-3">
    	<label>
      		<input type="checkbox" value="remember-me"> 아이디 저장
    	</label>
  	</div>
  	<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
  	<p class="mt-5 mb-3 text-muted">※ 접근권한은 경영지원실에 문의</p>
</form>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
</head>
<body class="h-dvh bg-white flex items-center justify-center">
	<input type="hidden" id="logged" data-logged="${checkLogged}" />
	<%-- locationForm == true ~ login and  --%>
	<input type="hidden" id="locationForm" data-locationForm="${locationForm}" />
	<f:form modelAttribute="account"
		action="/account/login"
		id="login-form"
		class=" [&>input]:rounded-lg [&>input]:border [&>input]:border-gray-400 w-[32rem] rounded-lg bg-gray-200 shadow-lg shadow-gray-500  flex flex-col px-6 py-10 justify-center ">
		<h2
			class="text-2xl text-center uppercase font-bold font-[500] text-orange-500">Đăng
			nhập</h2>
			
		<f:label for="username" path="username">Username</f:label>
		<f:input id="username" type="text" path="username" />
		<f:label for="password" path="password">Password</f:label>
		<f:input type="password" path="password" />
		<div
			class="pt-4 grid-cols-2 gap-4 grid [&>*]:px-4 [&>*]:text-white [&>*]:rounded-lg [&>*]:py-2 [&>*]:border [&>*]:border-gray-400	">
			<button type="submit" class=" bg-blue-500">Đăng nhập</button>
			<button type="button" id="reg-btn" class="bg-gray-400">Đăng ký</button>
		</div>
    <span>${error}</span>
		<span>${message}</span>
	</f:form>
		<f:form modelAttribute="account"
		id="register-form"
		action="/account/register"
		class=" [&>input]:rounded-lg [&>input]:border [&>input]:border-gray-400 w-[32rem] rounded-lg bg-gray-200 shadow-lg shadow-gray-500  flex flex-col px-6 py-10 justify-center ">
		<h2
			class="text-2xl text-center uppercase font-bold font-[500] text-orange-500">Đăng
			nhập</h2>
		<f:label for="fullname" path="fullname">Fullname</f:label>
		<f:input id="fullname" type="text" path="fullname" />
		<f:label for="username" path="username">Username</f:label>
		<f:input id="username" type="text" path="username" />
		<f:label for="password" path="password">Password</f:label>
		<f:input type="password" path="password" />
		<label for="password">Password confirm</label>
		<input type="password"/>
		<f:label for="email" path="email">Email</f:label>
		<f:input id="email" type="text" path="email" />
		<div
			class="pt-4 grid-cols-2 gap-4 grid [&>*]:px-4 [&>*]:text-white [&>*]:rounded-lg [&>*]:py-2 [&>*]:border [&>*]:border-gray-400	">
			<button type="button" id="login-btn" class="bg-gray-400" >Đăng nhập</button>
			<button type="submit" class="bg-blue-500" >Đăng ký</button>
		</div>
		<span>${registerMes}</span>
	</f:form>
	<script type="text/javascript" src="/js/common.js"></script>
	<script type="text/javascript" src="/js/account.js"></script>
</body>
</html>
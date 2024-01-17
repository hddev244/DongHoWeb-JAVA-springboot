<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div
	class="w-full bg-[#333333]  flex flex-col justify-between  text-gray-50">
	<div
		class="w-full flex justify-center h-10 border-neutral-600 border-b  z-50">
		<div
			class="w-[1080px] h-full flex justify-between [&>*]:items-center [&>*]:flex ">
			<div class="space-x-2 text-sm">
				<i class="far fa-map"></i><span class="me-2"> 137 Nguyễn Thị
					Thập - Hòa Minh - Liên Chiểu - ĐN</span> <i class="fas fa-phone"></i><span>0847
					511 175</span>
			</div>
			<div class="space-x-2">
				<a href=""><i class="fa-brands fa-square-facebook"></i></a> <a
					href=""><i class="fa-brands fa-instagram"></i></a> <a href=""><i
					class="fa-brands fa-square-twitter"></i></a>
			</div>
		</div>
	</div>
	<div class="w-full min-h-36 z-50">
		<div id="headerContainer"
			class="w-full z-50 [&>.navigation]:hover:transition-all [&>.navigation]:hover:duration-500 [&>.navigation]:hover:ease-out [&>.navigation]:hover:h-14">
			<div class=" w-full h-24  bg-[#333333] flex justify-center">
				<div class="w-[1080px] h-full flex justify-between items-center  ">
					<div>
						<a href="/"><img class="h-16"
							src="/images/logos/logo-mona-2.png" alt="logo" /></a>
					</div>
					<div class="flex rounded-lg overflow-hidden">
						<input placeholder="Tìm kiêm..." type="text"
							class="border-0 text-gray-900" />
						<button class="px-6 bg-[#C89979]">
							<i class="fa-solid fa-magnifying-glass"></i>
						</button>
					</div>
					<div class="flex space-x-4 items-center">
						<button 
						id="navLogInBtn"
						onclick="handleNavLoginBtn()"
							class="border border-transparent hover:border-gray-500 hover:rounded-lg font-[500] p-2 ">Đăng
							nhập</button>
						<a href=""><i class="text-xl fa-solid fa-heart"></i></a>
						<div class="relative flex items-center  pe-4">
							<i class="text-2xl fa-brands fa-opencart"></i> <span
								class="absolute block text-sm bg-yellow-700 size-5 text-center rounded-full right-0 bottom-[-8px]">2</span>
						</div>
					</div>
				</div>
			</div>
			<div
				class="navigation w-full bg-[#333333] h-14 border-neutral-600 border-t overflow-hidden "
				id="navbar">
				<div class="max-w-[1080px] h-full m-auto ">
					<!-- Navbar -->
					<%@ include file="./Navbar.jsp"%>
				</div>
			</div>
		</div>
	</div>
</div>

<div
id="loginContainer2"
	class="fixed h-dvh w-dvw bg-black z-30 top-0  opacity-50 flex items-center justify-center hidden">
</div>
<div
id="loginContainer"
	class="fixed h-dvh w-dvw z-40 top-0  items-center justify-center hidden">
	<div
		class="[&>input]:rounded-lg [&>input]:border [&>input]:border-gray-400 w-[32rem] rounded-lg bg-gray-200 shadow-lg shadow-gray-500  flex flex-col px-6 py-10 justify-center ">
		<h2 class="text-2xl text-center uppercase font-bold font-[500] text-orange-500">Đăng nhập</h2>
		<%-- 		<f:label for="username" path="">Username</f:label> --%>
		<%-- 		<f:input id="username" type="text" path=""/> --%>
		<%-- 		<f:label for="username" path="">Password</f:label> --%>
		<%-- 		<f:input type="password" path=""/> --%>
		<label for="username" path="">Username</label> <input id="username"
			type="text" path="" /> <label for="username" path="">Password</label>
		<input type="password" path="" />
		<div class="pt-4 grid-cols-2 gap-4 grid [&>*]:px-4 [&>*]:text-white [&>*]:rounded-lg [&>*]:py-2 [&>*]:border [&>*]:border-gray-400	">
			<button onclick="handleLoginBtn()" class="bg-blue-500">Đăng nhập</button>
			<button class="bg-gray-400">Đăng ký</button>
		</div>
	</div>
</div>
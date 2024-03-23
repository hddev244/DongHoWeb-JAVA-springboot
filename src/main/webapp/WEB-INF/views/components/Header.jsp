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
					<div class="flex w-96 rounded-lg  relative">
						<input id="searchProductNav" placeholder="Tìm kiêm..." type="text"
							class="border-0 rounded-s-lg flex-1 text-gray-900" />
						<button class="px-6 bg-[#C89979] rounded-e-lg">
							<i class="fa-solid fa-magnifying-glass "></i>
						</button>
            <div id="searchProductNav-show" class ="z-50 w-96 flex flex-col bg-gray-200 bottom-[-8px] hidden py-2 text-black translate-y-[100%] absolute">
            </div>
					</div>
					<div class="flex space-x-4 items-center">
					<c:choose>
						<c:when test="${account == null}">	
						<a href="/login" onclick="handleNavLoginBtn()"
							class="border border-transparent hover:border-gray-500 hover:rounded-lg font-[500] p-2 ">Đăng
							nhập</a>
						</c:when>
						<c:otherwise>
							<a href="/logout"
							class="border border-transparent hover:border-gray-500 hover:rounded-lg font-[500] p-2 ">Đăng
							Xuất</a>
						</c:otherwise>
					</c:choose>
					
						<a href="/cart">
						<div class="relative flex items-center  pe-4">
							<i class="text-2xl fa-brands fa-opencart"></i>
							 <span id="cart-counter"
								class="absolute block text-sm bg-yellow-700 size-5 text-center rounded-full right-0 bottom-[-8px]">
								0
								</span>
						</div>
						</a>
					</div>
				</div>
			</div>
			<div
				class="navigation w-full bg-[#333333] h-14 border-neutral-600 border-t overflow-hidden "
				id="navbar">
				<div class="max-w-[1080px] h-full m-auto ">

					<c:choose>
						<c:when test="${account != null}">	
							<c:choose>
								<c:when test="${account.admin}">	
									<%@ include file="../admin/components/Navbar.jsp"%>
								</c:when>
								<c:otherwise>
									<%@ include file="../components/Navbar.jsp"%>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<%@ include file="../components/Navbar.jsp"%>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="w-full h-[32rem] overflow-hidden relative">
	<%@ include file="./components/Carousel.jsp"%>
</div>

<!-- xu hướng banner -->
<section class="w-full mt-16">
	<div class="w-[1080px] m-auto flex justify-between   [&>*]:border">
		<a href="" class="h-[235px] w-[530px] overflow-hidden relative">
			<div
				class="absolute top-[50%] translate-y-[-50%]  text-white flex flex-col justify-center px-8 z-10">
				<span>Xu hướng 2024</span> <span> <i
					class="w-16 my-4 border-yellow-600  block border-b-2"></i>
				</span> <span class="uppercase text-3xl font-bold">Đồng hồ nam</span>
			</div> <img alt=""
			class="h-full w-full object-cover  transition ease-in-out delay-50 duration-700 hover:scale-110"
			src="/images/common/trend-1.jpg">
		</a> <a href="" class="h-[235px] w-[530px] overflow-hidden relative">
			<div
				class="absolute top-[50%] translate-y-[-50%]  text-white flex flex-col justify-center px-8 z-10">
				<span>Xu hướng 2024</span> <span> <i
					class="w-16 my-4 border-yellow-600  block border-b-2"></i>
				</span> <span class="uppercase text-3xl font-bold">Đồng hồ nữ</span>
			</div> <img alt=""
			class="h-full w-full object-cover  transition ease-in-out delay-50 duration-700 hover:scale-110"
			src="/images/common/trend-2.jpg">
		</a>
	</div>
</section>

<!-- Sản phẩm phổ biến -->
<section class="w-full pt-8">
	<div class="w-[1080px] m-auto">
		<h1 class="font-bold text-3xl py-6">Sản phẩm phổ biến</h1>
		<div class="w-full relative overflow-hidden py-10 px-4">
			<%@ include file="./components/Product-list-card.jsp"%>
		</div>
	</div>
</section>

<!-- Danh sách sản phẩm -->
<section class="w-full pt-8">
	<div
		class="w-[1080px] flex justify-between m-auto [&>*]:rounded-xl  [&>*]:border">
		<a href="" class="h-60 w-[530px] overflow-hidden relative">
			<div
				class="max-w-72 absolute top-10 text-white flex flex-col justify-center px-8 z-10">
				<span class="uppercase text-3xl font-bold">Cổ điển</span> <span>
					<i class="w-20 my-4 border-yellow-600  block border-b-2"></i>
				</span> <span>Đa dạng về phong cách, kiểu dáng, màu sắc, kích cỡ…</span>
			</div> <img alt=""
			class="h-full w-full object-cover  transition ease-in-out delay-50 duration-700 hover:scale-110"
			src="/images/common/banner-03.jpg">
		</a> <a href="" class="h-60 w-[530px] overflow-hidden relative">
			<div
				class="max-w-72 absolute bottom-6  text-white flex flex-col justify-center px-8 z-10">
				<span class="uppercase text-3xl font-bold">SMART WATCH</span> <span>
					<i class="w-20 my-4 border-yellow-600  block border-b-2"></i>
				</span> <span>Đa dạng về phong cách, kiểu dáng, màu sắc, kích cỡ…</span>
			</div> <img alt=""
			class="h-full w-full object-cover  transition ease-in-out delay-50 duration-700 hover:scale-110"
			src="/images/common/banner-04.jpg">
		</a>
	</div>
</section>

<section class="w-full pt-4">
	<div class="w-[1080px] m-auto">
		<h1 class="font-bold text-2xl py-4">Sản phẩm bán chạy</h1>
		<div class="w-full grid grid-cols-5 gap-5">
			<c:forEach var="product" items="${products}">
				<%@ include file="./components/Product-card.jsp"%>
			</c:forEach>
		</div>
	</div>
</section>
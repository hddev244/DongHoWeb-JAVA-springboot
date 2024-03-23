<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="p-10 [&>*>.swiper-slide]:justify-center [&>*>.swiper-slide]:items-center [&>*>.swiper-slide]:text-conter [&>*>.swiper-slide]:bg-white [&>*>.swiper-slide]:flex ">
	<div
		style="--swiper-navigation-color: #fff; --swiper-pagination-color: #fff"
		class="swiper w-full h-full product-detail-slide2 w-full">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img src="/images/products/product-01.png" alt="product-detail" />
			</div>
			<c:forEach var="img" items="${product.images}">	
				<div class="swiper-slide">
					<img src="${img.url}" alt="product-detail" />
				</div>
			</c:forEach>
		</div>
		<div class="swiper-button-next text-gray-300 "></div>
		<div class="swiper-button-prev text-gray-300 "></div>
	</div>
	<div thumbsSlider="" class="swiper w-full h-full product-detail-slide1">
		<div class="swiper-wrapper [&>.swiper-slide>img]:outline  [&>.swiper-slide>img]:border-2 [&>.swiper-slide>img]:w-full [&>.swiper-slide]:overflow-hidden  [&>.swiper-slide]:rounded-lg [&>.swiper-slide]:opacity-40   [&>.swiper-slide-thumb-active]:!opacity-100  ">
			<div class="swiper-slide swiper-slide-thumb-active">
				<img src="/images/products/product-01.png" alt="product-detail" />
			</div>
			<c:forEach var="img" items="${product.images}">	
				<div class="swiper-slide">
					<img src="${img.url}" alt="product-detail" />
				</div>
			</c:forEach>
		</div>
	</div>
</div>

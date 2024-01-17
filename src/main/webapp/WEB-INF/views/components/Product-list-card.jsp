<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div
	class="h-full w-full product-list-card [&>.swiper-button]:hover:block ">
	<div
		class=" swiper-wrapper [&>*>img]:h-full [&>*>img]:object-cover [&>*]:bg-center [&>*]:bg-cover [&>*]:relative [&>*>*]:block [&>*>*]:w-full  ">
		<c:forEach var="product" items="${products}">
			<div class="swiper-slide">
				<%@ include file="/WEB-INF/views/components/Product-card.jsp"%>
			</div>
		</c:forEach>
	</div>
	<div class="swiper-button swiper-button-next hidden  product-list-card-button-next"></div>
	<div class="swiper-button swiper-button-prev  hidden product-list-card-button-prev"></div>
</div>
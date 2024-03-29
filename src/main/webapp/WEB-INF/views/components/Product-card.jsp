<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div
	class="min-h-56 border bg-gray-100 rounded-lg overflow-hidden  transition hover:scale-105  hover:shadow-lg ease-in-out duration-700 ">
	<a href="/product/detail?id=${product.id}"> <img alt="product image"
		class="border-b-2 w-full aspect-[1/1] object-cover"
		src="${empty product.images ? 
			'http://localhost:8080/images/products/PRO1707831097543.png' 
			: product.images[0].url
			}">
	</a>
	<div
		class="w-full flex space-y-2 flex-col text-center max-w-44 m-auto py-6">
		<span class="font-bold ">${product.name}</span> <span
			class="font-[500] text-[#EE9458]">
			<fmt:formatNumber value="${product.price*1000}" type="number" />
			 <i>vnđ</i></span>
		<button 
			data-productId="${product.id}"
			class="add-to-cart-btn bg-[#C89979] p-1 font-[400] text-xl text-white hover:bg-[#B46F41] transition rounded-md">
			Thêm vào giỏ
		</button>
	</div>
</div>
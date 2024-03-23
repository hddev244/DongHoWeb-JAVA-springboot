<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="w-full pt-8">
	<div class="w-[1080px] m-auto">
		<h1
			class="font-bold text-3xl text-gray-500 text-center py-6 uppercase">${genderSpecific}</h1>
		<div class="w-full">
			<img class="m-auto w-full mb-4" alt="banner-for-men"
				src="/images/banners/banner-danh-muc-dong-ho-nam.avif"> <i
				class="text-sm text-gray-500">Những mẫu đồng hồ nam đẹp luôn là
				món phụ kiện thời trang hoàn hảo cho tất cả các dịp, giúp nam giới
				tự tin hơn – khẳng định phong cách. Đặc biệt khi mà nhiều thương
				hiệu đồng hồ nam thời trang quốc tế du nhập vào Việt Nam, việc mua
				sắm chiếc đồng hồ đeo tay nam phù hợp rất dễ dàng bởi sự đa dạng về
				mẫu mã, màu sắc, tính năng và kiểu dáng. Shop Đồng Hồ Hải Triều hiện
				là đại lý ủy quyền của gần 30 thương hiệu, mang cả thế giới đồng hồ
				về trưng bày tại hơn 25 chi nhánh trên toàn quốc.</i>
			<div class="my-4 grid grid-cols-2 gap-4">
				<a href=""> <img class="" alt="banner-for-men"
					src="/images/banners/BST-dong-ho-nam-ban-chay.avif">
				</a>
				<a href=""> <img class="" alt="banner-for-men"
					src="/images/banners/BST-dong-ho-nu-ban-chay.avif">
				</a>
			</div>
		</div>
		<form class="my-10">
			<ul class="flex gap-2 [&>*]:bg-gray-200 [&>*]:border [&>*]:rounded-md [&>*]:p-2 [&>*]:px-4 [&>*>i]:me-2 [&>*>i]:text-gray-500 ">
				<li><i class="fa-solid fa-filter"></i>Bộ lọc</li>
				<li><i class="fa-regular fa-copyright"></i>Thương hiệu</li>
				<li><i class="fa-regular fa-money-bill-1"></i>Mức giá</li>
				<li><i class="fa-solid fa-palette"></i>Màu mặt số</li>
				<li><i class="fa-solid fa-expand"></i>Kích thước mặt số</li>
				<li><i class="fa-solid fa-venus-mars"></i>Giới tính</li>
			</ul>
		</form>
		<div class="col-span-3">

			<article class="w-full grid grid-cols-4 gap-6">
				<c:forEach var="product" items="${products}">
					<%@ include file="/WEB-INF/views/components/Product-card.jsp"%>
				</c:forEach>
			</article>
		</div>
	</div>
</section>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section class="w-full">
	<div class="grid grid-cols-2 w-[1080px] m-auto">
		<div>
			<%@ include file="/WEB-INF/views/components/Product-detail-slide.jsp"%>
			<div></div>
		</div>
		<div class="flex flex-col pt-24 space-y-1">
			<h1 class="text-4xl uppercase font-[700] ">Casio</h1>
			<span class="text-xl uppercase text-gray-500 font-[500] " >${product.name} – ${product.brand.name}  – ${product.genderSpecific? "Nam": "Nữ"}</span>
			<span class="text-md uppercase text-gray-500">Mã Số Sản Phẩm: A168WG-9WDF</span>
			 <span class="text-xl uppercase text-red-600 font-[600] "><fmt:formatNumber value="${product.price*1000}" type="number" /> ₫</span> 
			 <i class="text-gray-500 text-md">Đồng
				hồ Casio A168WG-9WDF với hình dáng truyền thống của hãng, phù hợp
				cho cả nam lẫn nữ, tông màu vàng chủ đạo từng chi tiết vỏ, mặt số và
				dây đeo tạo nên thời trang sang trọng, quý phái và thanh lịch.</i>
			<div class="flex py-4 flex-col text-white [&>*]:border [&>*]:p-2 [&>*]:rounded-lg space-y-2">
				<button class="bg-gray-500 uppercase">Xem showroom còn hàng</button>
				<button 
					data-productId="${product.id}"
					class="add-to-cart-btn bg-red-800 uppercase font-bold">Thêm vào giỏ hàng</button>
				<button class="bg-blue-500">Mua trả góp - duyệt hồ sơ trong 3 phút</button>

			</div>
			<span>Có thanh toán: Trả góp khi mua Online (Qua thẻ tín dụng)</span>
			<span>Gọi đặt mua: 1900.6777 (8:00-1:30)</span>
			<div class="flex flex-col bg-gray-200 border p-4 rounded-lg ">
				<span>Dịch vụ gói quà miễn phí khi mua tại cửa hàng.</span>
				<span>Khi thanh toán qua Home PayLater tại Hải Triều:</span>
				<span>- Giảm 50% tối đa 100K cho đơn từ 200K</span>
				<span>- Giảm 5% tối đa 300K</span>
				<span>- Giảm 7% tối đa 500K cho đơn từ 5.5M</span>
			</div>
		</div>
		<div class=" text-sm font-[500] leading-4 col-span-2 grid grid-cols-4 py-10 [&>*>i]:text-3xl [&>*]:opacity-70 [&>*>i]:me-4 [&>*>i]:text-red-500 gap-4 [&>*]:border [&>*]:p-3 [&>*]:flex [&>*]:rounded-lg [&>*]:items-center">
		<a href=""><i class="fa-solid fa-business-time"></i>Tăng thời gian bảo hành lên đến 5 năm</a>
		<a href=""><i class="fa-solid fa-coins"></i>Hoàn tiền gấp 10 lần khi phát hiện hàng giả</a>
		<a href=""><i class="fa-solid fa-door-open"></i>Trung tâm bảo hành đạt tiêu chuẩn quốc tế</a>
		<a href=""><i class="fa-solid fa-car-battery"></i>Thay pin miễn phí suốt đời	</a>
		<a href=""><i class="fa-solid fa-truck-arrow-right"></i>Giao hàng siêu tốc 2h ship cod miễn phí</a>
		<a href=""><i class="fa-solid fa-calendar-days"></i>Kinh nghiệm và dịch vụ hơn 30 năm</a>
		<a href=""><i class="fa-solid fa-hands-asl-interpreting"></i>Sai kích cỡ? Không ưng ý? Đổi hàng trong 7 ngày</a>
		</div>
	</div>
</section>
<section>
	<div class="grid grid-cols-2 w-[1080px] m-auto">
	</div>
</section>
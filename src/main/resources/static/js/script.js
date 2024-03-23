/**
 * 
 */
var swiper = new Swiper(".mySwiper", {
	effect: "Flip",
	loop: true,
	freeMode: true,
	navigation: {
		nextEl: ".swiper-button-next",
		prevEl: ".swiper-button-prev",
	},
	pagination: {
		el: ".swiper-pagination-carousel",
		clickable: true,
	},
	autoplay: {
		delay: 5000,
	},
});

var swiper1 = new Swiper(".product-list-card", {
	slidesPerView: 4,
	spaceBetween: 30,
	slidesPerGroup: 4,
	freeMode: true,
	navigation: {
		nextEl: ".product-list-card-button-next",
		prevEl: ".product-list-card-button-prev",
	},
});

var swiper2 = new Swiper(".product-detail-slide1", {
	loop: true,
	spaceBetween: 10,
	slidesPerView: 4,
	freeMode: true,
	watchSlidesProgress: true,
});
var swiper3 = new Swiper(".product-detail-slide2", {
	loop: true,
	spaceBetween: 10,
	navigation: {
		nextEl: ".swiper-button-next",
		prevEl: ".swiper-button-prev",
	},
	thumbs: {
		swiper: swiper2,
	},
});

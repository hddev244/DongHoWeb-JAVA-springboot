<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đồng hồ MONA</title>
<link rel="stylesheet" href="/css/swiper.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
</head>
<body class="">
	<div class="">
		<!-- Header -->
		<%@ include file="/WEB-INF/views/components/Header.jsp"%>
		<article >
				<jsp:include page="${viewsPage}"></jsp:include>
		</article>
		<!-- footer -->
		<%@ include file="../components/Footer.jsp"%>
	</div>

<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/swiper-bundle.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>
</div>
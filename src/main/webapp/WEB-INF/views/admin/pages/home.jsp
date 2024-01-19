<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<session class=" ">
<div class="size-[500px] m-auto">
	<canvas id="myChart1"></canvas>
</div>
<div class="size-[500px] m-auto">
	<canvas id="myChart2"></canvas>
</div>
</session>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
	const ctx = document.getElementById('myChart1');
	const ctx2 = document.getElementById('myChart2');
	const data = {
		labels : [ 'Thành Công', 'Huấn luyện', 'Tuấn','4' ],
		datasets : [ {
			label : 'My First Dataset',
			data : [ 300, 50, 400,100 ],
			backgroundColor : [ 'rgb(255, 99, 132)', 'rgb(54, 162, 235)',
					'rgb(255, 205, 86)','#333' ],
			hoverOffset : 4
		} ]
	};
	new Chart(ctx, {
		type : 'doughnut',
		data : data,
		options : {
			scales : {
				y : {
					beginAtZero : true
				}
			},
			plugins : {
				title : {
					display : true,
					text : 'Custom Chart Title'
				}
			},
		}
	});
	new Chart(ctx2, {
		type : 'line',
		data : data,
		options : {
			scales : {
				y : {
					beginAtZero : true
				}
			},
			plugins : {
				title : {
					display : true,
					text : 'Custom Chart Title'
				}
			},
		}
	});
</script>

const createChart = (data) =>{
  const $ctx2 = document.getElementById('myChart2');

	new Chart($ctx2, {
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
					text : 'Thống kê doanh thu theo sản phẩm'
				}
			},
		}
	});
}


const getReportRevenue = async () => {
  const url = "http://localhost:8080/admin/api/report/revenue-by-product";
  try {
    // Thực hiện fetch để tải lên tệp
    const response = await fetch(url);
    // Kiểm tra xem tải lên tệp có thành công không
    if (response.ok) {
      // Nếu tải lên tệp thành công thì lưu dữ liệu trả về và hiển thị
      const data = await response.json();
      let labels = [];
      let dataValues = [];
      data.map((item) => {
        labels.push(item.group.name);
        dataValues.push(item.revenues*1000);
      })
      const dataChart = {
        labels : labels,
        datasets : [ {
          label : 'My First Dataset',
          data : dataValues,
          backgroundColor : [ 'rgb(255, 99, 132)', 'rgb(54, 162, 235)',
              'rgb(255, 205, 86)','#333' ],
          hoverOffset : 8
        } ]
      };
      const $ctx = document.getElementById('myChart1');
      new Chart($ctx, {
        type : 'doughnut',
        data : dataChart,
        options : {
          scales : {
            y : {
              beginAtZero : true
            }
          },
          plugins : {
            title : {
              fullSize:true,
              display : true,
              text : 'Thống kê doanh thu theo sản phẩm',
              font: {
                size: 20
              }
            }
          },
        }
      });
    }
  } catch (error) {
    console.error('Lỗi khi thực hiện fetch:', error);
  }
}
getReportRevenue();
// URL of the API endpoint you want to retrieve data from
var apiUrl = "http://localhost:8080/admin/product/images";
const productId = document.querySelector('#productId').value;

function addProductsToImagesContainer(images) {
      const productImagesContainer = document.getElementById("product-images");
      productImagesContainer.innerHTML = `
      <label for="imageUpload">
            <div class="aspect-[1] border flex items-center text-center justify-center">
                  Thêm ảnh
            </div>
      </label>`;
      images.forEach(img => {
            const productImageDiv = document.createElement("div");
            productImageDiv.classList.add("relative");
            productImageDiv.innerHTML = `
                                          <img class="aspect-[1] object-cover border" src="${img.url}" alt="product image">
                                          <a href="#" class="text-gray-400 absolute top-1 right-1" onclick="deleteImage(${img.id})"><i class="fa-regular fa-circle-xmark"></i></a>
                                          `;
            productImagesContainer.appendChild(productImageDiv);
      });
}

// Make a GET request to the API endpoint
async function fetchDataFromAPI() {
      if (productId != "") {
            try {
                  const url = apiUrl + "?productId="+productId;
                  // Thực hiện fetch để tải lên tệp
                  const response = await fetch(url);
                  // Kiểm tra xem tải lên tệp có thành công không
                  if (response.ok) {
                        const data = await response.json();
                        addProductsToImagesContainer(data)
                  } else {
                        console.error('Lỗi khi tải lên tệp');
                  }
            } catch (error) {
                  console.error('Lỗi khi thực hiện fetch:', error);
            }
      }
}

fetchDataFromAPI();

const imageChooser = document.getElementById('imageUpload');
const progressBar = document.getElementById('progressBar');


imageChooser.addEventListener('change', async function (e) {
      if (productId.value != "") {
            if (imageChooser.value != null) {
                  var data = new FormData();
                  const files = imageChooser.files;
                  for (const file of files) {
                        data.append('files', file);
                  }
                  data.append('productId', productId);
                  try {
                        // Thực hiện fetch để tải lên tệp
                        const response = await fetch(apiUrl, {
                              method: 'POST',
                              body: data
                        });
                        // Kiểm tra xem tải lên tệp có thành công không
                        if (response.ok) {
                              fetchDataFromAPI();
                        } else {
                              console.error('Lỗi khi tải lên tệp');
                        }
                  } catch (error) {
                        console.error('Lỗi khi thực hiện fetch:', error);
                  }
                  // Đặt giá trị của input file về null để làm sạch input
                  imageChooser.value = null;
            }
      } else {
            alert('Lưu sản phẩm trước khi thêm ảnh');
      }
});

const deleteImage = async (imgId) => {
      var data = new FormData();
      data.append('imgId', imgId);
      try {
            // Thực hiện fetch để tải lên tệp
            const response = await fetch(apiUrl, {
                  method: 'DELETE',
                  body: data,
                  onUploadProgress: function (progressEvent) {
                        const progress = Math.round((progressEvent.loaded / progressEvent.total) * 100);
                        progressBar.value = progress;
                  }
            });

            // Kiểm tra xem tải lên tệp có thành công không
            if (response.ok) {
                  console.log("olk");
                  fetchDataFromAPI();
            } else {
                  console.error('Lỗi khi tải lên tệp');
            }
      } catch (error) {
            console.error('Lỗi khi thực hiện fetch:', error);
      }
      // Đặt giá trị của input file về null để làm sạch input
      imageChooser.value = null;
}



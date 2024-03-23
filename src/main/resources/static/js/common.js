/**
 * 
 */
window.addEventListener('scroll', function () {
  const navbar = document.getElementById('navbar');
  const headerContainer = document.getElementById('headerContainer');
  const scrollPosition = window.scrollY;
  if (scrollPosition >= 36) {
    navbar.classList.add("h-0")
    headerContainer.style.position = 'fixed';
    headerContainer.style.top = '0';
  } else {
    headerContainer.style.position = 'relative';
    navbar.classList.remove("h-0")
  }
});


function showSuccessMessage() {
  const successMessage = document.getElementById("successMessage");
  console.log(successMessage)
  successMessage.style.display = "block"; // Hiển thị thông báo
  setTimeout(function () {
    successMessage.style.display = "none"; // Ẩn thông báo sau 3 giây
  }, 2000);
}
function debounce(func, delay) {
  let timeoutId;
  return function() {
      const context = this;
      const args = arguments;
      
      clearTimeout(timeoutId);
      timeoutId = setTimeout(() => {
          func.apply(context, args);
      }, delay);
  };
}

const $searchProductNav = document.getElementById('searchProductNav');
const $searchProductNavShow = document.getElementById('searchProductNav-show');
$searchProductNav.addEventListener('input', debounce( async () =>{
  const urlAPI = "http://localhost:8080/api/product/search?keyword="+$searchProductNav.value;
  try {
    const response = await fetch(urlAPI)
    if (response.ok) {
     $searchProductNavShow.style.display = "block";
     $searchProductNavShow.innerHTML = '';
     const data = await response.json();
     data.content.forEach(product => {
      // Create elements
      const anchorElement = document.createElement("a");
      anchorElement.classList.add("flex","mx-2", "border","border-gray-400", "rounded-lg", "overflow-hidden");
      anchorElement.href = `/product/detail?id=${product.id}`; // Set href attribute as needed

      const imageElement = document.createElement("img");
      imageElement.src = product.images[0].url;
      imageElement.classList.add("size-20");

      const divElement = document.createElement("div");
      divElement.classList.add("p-2");

      const productNameElement = document.createElement("p");
      productNameElement.classList.add("text-sm", "font-bold");
      productNameElement.textContent = product.name; // Assuming "name" is a property of each product

      const priceElement = document.createElement("p");
      priceElement.classList.add("text-sm", "font-bold");
      priceElement.textContent = "Giá: " + product.price*1000; // Assuming "price" is a property of each product

      // Append elements to their parent
      divElement.appendChild(productNameElement);
      divElement.appendChild(priceElement);

      anchorElement.appendChild(imageElement);
      anchorElement.appendChild(divElement);

      // Append the anchor element to the parent container
      $searchProductNavShow.appendChild(anchorElement);
    });
     console.log(data);
    } else {
      $searchProductNavShow.style.display = "none";
      console.error('Lỗi khi tải lên tệp');
    }
  } catch (error) {

  }
}, 500)) 

// $searchProductNav.addEventListener('blur', function() {
//   $searchProductNavShow.style.display = "none";
// });

// Bắt sự kiện khi click vào document
document.addEventListener('click', function(event) {
  // Kiểm tra xem sự kiện click có xảy ra bên ngoài searchProductNavShow không
  if (!$searchProductNavShow.contains(event.target) && event.target !== $searchProductNav) {
    // Ẩn searchProductNavShow nếu click không phải là vào nó
    $searchProductNavShow.style.display = "none";
  }
});
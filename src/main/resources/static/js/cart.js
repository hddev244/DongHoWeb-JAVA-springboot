const addToCartBtns = document.querySelectorAll('.add-to-cart-btn');
const decreaseOneProduct = document.querySelectorAll('.sub-qty');
const increaseOneProduct = document.querySelectorAll('.add-qty');

addToCartBtns.forEach(button => {
  button.addEventListener('click', async (e) => {
    const productId = e.target.getAttribute('data-productId');
    const url = "http://localhost:8080/api-cart";
    var data = new FormData();
    data.append('productId', productId);
    try {
      // Thực hiện fetch để tải lên tệp
      const response = await fetch(url, {
        method: 'POST',
        body: data
      });
      // Kiểm tra xem tải lên tệp có thành công không
      if (response.ok) {
        setCartCounters();
        showSuccessMessage();
      } else {
        console.error('Lỗi khi tải lên tệp');
      }
    } catch (error) {
      console.error('Lỗi khi thực hiện fetch:', error);
    }
  })
});

decreaseOneProduct.forEach(button => {
  button.addEventListener('click', async () => {
    const $id = button.getAttribute('data-cart-id');
    const urlAPI = "http://localhost:8080/api-cart/decreaseOne";
    var data = new FormData();
    data.append('id', $id);
    try {
      const response = await fetch(urlAPI, {
        method: 'PUT',
        body: data
      })
      if (response.ok) {
        const data = await response.json();
        if (data.quantity == 0) {
          var element = document.getElementById($id);
          element.parentNode.removeChild(element);
        }
        else {
          updateCartItem($id, data);
        }
      } else {
        console.error('Lỗi khi tải lên tệp');
      }
    } catch (error) {

    }
  });
});
increaseOneProduct.forEach(button => {
  button.addEventListener('click', async () => {
    const $id = button.getAttribute('data-cart-id');
    const urlAPI = "http://localhost:8080/api-cart/increaseOne";
    var data = new FormData();
    data.append('id', $id);
    try {
      const response = await fetch(urlAPI, {
        method: 'PUT',
        body: data
      })
      if (response.ok) {
        const data = await response.json();
        updateCartItem($id, data);
      } else {
        console.error('Lỗi khi tải lên tệp');
      }
    } catch (error) {

    }
  });
});

const updateCartItem = ($id, data) => {
  document.getElementById('qty' + $id).innerHTML = data.quantity;
  document.getElementById('total' + $id).innerHTML = new Intl.NumberFormat().format(data.quantity * data.product.price * 1000) + " ₫";
}

const setCartCounters = async () => {
  const url = "http://localhost:8080/api-cart";
  try {
    // Thực hiện fetch để tải lên tệp
    const response = await fetch(url);
    // Kiểm tra xem tải lên tệp có thành công không
    if (response.ok) {
      const data = await response.json();
      document.querySelector('#cart-counter').innerHTML = data.length;
    } else {
      console.error('Lỗi khi tải lên tệp');
    }
  } catch (error) {
    console.error('Lỗi khi thực hiện fetch:', error);
  }
}

const deleteItem = async (id) => {
  const urlAPI = "http://localhost:8080/api-cart";
  var data = new FormData();
  data.append('id', id);
  try {
    const response = await fetch(urlAPI, {
      method: 'DELETE',
      body: data
    })
    if (response.ok) {
      var element = document.getElementById(id);
      element.parentNode.removeChild(element);
    } else {
      console.error('Lỗi khi tải lên tệp');
    }
  } catch (error) {

  }
}

setCartCounters();
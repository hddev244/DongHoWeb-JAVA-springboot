const $orderBtn = document.querySelector('#order-btn');
const $formOrder = document.querySelector('#form-order');

const order = () => {
      const $fullname = document.querySelector('#fullname').value;
      const $phoneNumber = document.querySelector('#phoneNumber').value;
      const $address = document.querySelector('#address').value;
      if ($fullname != "" && $phoneNumber != "" && $address) {
            $formOrder.submit();
      }
};
$orderBtn.addEventListener('click', order);


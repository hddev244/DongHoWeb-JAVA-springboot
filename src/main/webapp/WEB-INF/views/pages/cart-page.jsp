<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="w-[960px] m-auto flex flex-col border-x">
			<%-- products container --%>  
                  <div class="flex flex-col gap-2 p-4">
                  <h1 class="text-3xl text-blue-600 uppercase font-bold text-center p-8">Giỏ hàng của bạn</h1>
                  <div id="cart-container" class="flex flex-col gap-2">
                        <c:forEach var="cartItem" items="${carts}">	
				<div id="${cartItem.id}" class="h-40 p-2 flex  w-full rounded-md bg-gray-200">
                              <img src="${cartItem.product.images[0].url}" class="h-full aspect-[1] object-cover rounded-md " alt="product-detail" />
                              <div class="flex-1 gap-1 flex flex-col p-2 px-10">
                                    <span  class="text-xl uppercase font-[500] " >${cartItem.product.name} – ${cartItem.product.brand.name}  – ${cartItem.product.genderSpecific? "Nam": "Nữ"}</span>
                                    <span id="total${cartItem.id}" class="text-xl uppercase text-red-600 font-[600] "><fmt:formatNumber value="${cartItem.product.price *1000 * cartItem.quantity }" type="number" /> ₫</span>
                                    <div class="">
                                          <div class=" text-center [&>button]:border [&>button]:border-gray-500 flex [&>button]:block [&>button]:size-7">
                                          <%-- decreaseOne --%>
                                          <button data-cart-id="${cartItem.id}"   class="sub-qty text-blue-500 rounded-s-md"> - </button> 
                                          <span id="qty${cartItem.id}" class="border-y text-center px-2 border-gray-500">${cartItem.quantity}</span> 
                                          <%-- increaseOne --%>
                                          <button data-cart-id="${cartItem.id}"  class="add-qty" class=""> + </button>
                                          </div>
                                    </div>
                                    <div> <button onclick="deleteItem(${cartItem.id})" href="#">delete</button></div>
                              </div>
				</div>
			</c:forEach>
                  </div>
                  </div>
                  <!-- dat hang -->
                  <div class="px-6">
                  <h1 class="text-3xl text-red-500 uppercase font-bold text-center p-8">Đặt Hàng</h1>
                        <form 
                              id="form-order"
                              class="flex flex-col gap-2 "
                              action="/order"
                              method="post"               
                              >

                              <div class="flex  items-center [&>label]:w-32 [&>input]:flex-1 [&>input]:rounded-md [&>label]:text-end gap-4">
                                    <label for="fullname">ho ten</label>
                                    <input type="text" name="" id="fullname" value="${account != null ? account.fullname:""}" />
                              </div>                                                                                                               
                              <div class="flex  items-center [&>label]:w-32 [&>input]:flex-1 [&>input]:rounded-md [&>label]:text-end gap-4">
                                    <label for="phoneNumber" >So Dien Thoai</label>
                                    <input type="text" name="phoneNumber" id="phoneNumber" value="${account != null ? account.phoneNumber:""}" />
                              </div>
                              <div class="flex  items-center [&>label]:w-32 [&>textarea]:flex-1 [&>textarea]:rounded-md [&>label]:text-end gap-4">
                                    <label for="address" >Dia chi</label>
                                    <textarea type="text" name="address" id="address" value="${account != null ? account.address:""}"> </textarea>
                              </div>
                             <div class="flex  items-center [&>label]:w-32 [&>button]:flex-1 [&>button]:rounded-md [&>label]:text-end gap-4">
                                     <label></label>
                                    <button id="order-btn" type="button" data-id="${account.username}"  class="p-2 bg-red-600 text-white text-2xl uppercase font-bold drop-shadow-[0_1.2px_1.2px_rgba(0,0,0,0.8)]"> DAt hang</button>
                              </div>
                             
                        </form>
                  </div>
                  <div class="pt-8">
                  <h1 class="text-3xl uppercase font-bold text-center p-8">Lịch sử Đặt Hàng</h1>
                        
                        <table class=" [&>*>*>*]:border [&>*>*>*]:p-2 w-full">
                  <thead>
                        <tr class="font-bold">
                              <th>ID</th>
                              <%-- <th>Khách hàng</th> --%>
                              <%-- <th>Số điện thoại</th> --%>
                              <th>Địa chỉ</th>
                              <th>Trạng thái đơn hàng</th>
                              <th>Ngày đặt hàng</th>
                              <th>Tổng tiền</th>
                        </tr>
                  </thead>
                  <tbody>
                 <c:forEach var="item" items="${orders.content}">
                        <tr>
                              <td>${item.id}</td>
                              <%-- <td>${item.account.fullname}</td> --%>
                              <%-- <td>${item.account.phoneNumber}</td> --%>
                              <td>${item.address}</td>
                              <td>${item.deliverySatus ? "Giao hàng thành công":"Đã đặt hàng"}</td>
                              <td>${item.createDate}</td>
                              <td>
                              <c:set var="total" value="${0}"/>
                              
                              <c:forEach items="${item.orderDetails}" var="od">
                                  <c:set var="total" value="${total + od.price*od.quantity }"/>
                                 </c:forEach> 
                                <fmt:formatNumber value="${total*1000}" type="number" />
                             
                              
                              </td>
                              <%-- <td class="!border-0">
                              <a    class="px-4 py-2 bg-red-600 text-white rounded-lg"
                                    href="/admin/item-management/edit?id=${item.id}">Chi tiết</a>
                              </td> --%>
                        </tr>
                  </c:forEach>
                  </tbody>    
            </table>
                  </div>
<script src="/js/order.js"></script>
</div>
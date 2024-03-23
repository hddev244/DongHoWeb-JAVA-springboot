<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="w-[960px] min-h-96 m-auto flex flex-col border-x p-4">
      <h1 class = "text-center text-green-500 font-bold text-2xl" > ${message_order} </h1>
      <c:if test="${ordered != null}" >
            <div class="w-2/3 mx-auto flex flex-col">
                  <span>Mã đơn hàng: ${ordered.id}</span>
                   <span>Tên khách hàng: ${ordered.account.fullname}</span>
                    <span>Số điện thoại: ${ordered.phoneNumber}</span>
                  <span>Địa chỉ giao hàng: ${ordered.address}</span>
                  <span>Thời gian đặt: <fmt:formatDate value="${ordered.createDate}" type="both" /> </span>
            </div>
      <table class="text-center w-2/3 mx-auto">
      <thead>
            <tr>
                  <th >Tên sản phẩm</th>
                  <th>Giá</th>
                  <th>Số lượng</th>
                  <th>Thành tiền</th>
            </tr>

      </thead>
      <tbody>
      <c:set var="total" value="${0}"/>
      <c:set var="totalQty" value="${0}"/>
      <c:forEach  var="item" items="${ordered.orderDetails}">
            <tr>
                  <td class="text-left">${item.product.name}</td>
                  <td><fmt:formatNumber value="${item.price}" type="number" /></td>  
                  <td>${item.quantity}</td>     
                  <td><fmt:formatNumber value="${item.quantity * item.price  *1000}" type="number" /> vnd</td>          
            </tr>
<c:set var="total" value="${total+item.quantity * item.price}"/>
<c:set var="totalQty" value="${totalQty + item.quantity}"/>
      </c:forEach>
      </tbody>
      <tfoot class="border-t">
            <tr class=" [&>*]:py-2 text-xl font-[500]  ">
                  <td >Tổng cộng</td>
                  <td></td>       
                  <td><fmt:formatNumber value="${totalQty}" type="number" /></td>
                  <td class=" text-red-500 "><fmt:formatNumber value="${total *1000}" type="number" /> vnd</td>
            </tr>
      </tfoot>
      </table>
    
            </c:if>
</div>
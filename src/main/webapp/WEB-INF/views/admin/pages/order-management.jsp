<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="w-[1024px] my-8 m-auto text-20">
   <table class="[&>*>*>*]:border [&>*>*>*]:p-2 w-full">
                  <thead>
                        <tr class="font-bold">
                              <th>ID</th>
                              <th>Khách hàng</th>
                              <th>Số điện thoại</th>
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
                              <td>${item.account.fullname}</td>
                              <td>${item.account.phoneNumber}</td>
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
                              <td class="!border-0">
                              <a    class="px-4 py-2 bg-red-600 text-white rounded-lg"
                                    href="/admin/item-management/edit?id=${item.id}">Chi tiết</a>
                              </td>
                        </tr>
                  </c:forEach>
                  </tbody>    
            </table>
</div>
</session>
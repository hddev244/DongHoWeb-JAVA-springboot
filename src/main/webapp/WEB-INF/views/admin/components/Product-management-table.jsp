<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="w-[1024px] m-auto">

            <h1 class="uppercase text-2xl text-blue ">Search by price</h1>
            <%-- <form:form action="/product2/search"
                  class="flex gap-1 justify-center items-center  [&>.input]:p-2 [&>.input]:rounded-lg  [&>.input]:border"
                  method="GET">
                  <form:label for="keyword">keyword</label>
                  <form:input class="input" name="keyword" value = "${keyword}" type="text">
                  <button class="input px-4">Search</button>
            </form:form> --%>
            <table class="[&>*>*>*]:border [&>*>*>*]:p-2 w-full">
                  <thead>
                        <tr class="font-bold">
                              <th>ID</th>
                              <th>Name</th>
                              <th>Price</th>
                              <th>Created Date</th>
                              <th>Modifi Date</th>
                        </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="product" items="${productPages.content}">
                        <tr>
                              <td>${product.id}</td>
                              <td>${product.name}</td>
                              <td><fmt:formatNumber value="${product.price}" type="number" /></td>
                              <td>${product.createDate}</td>
                              <td>${product.modifiDate}</td>
                              <td class="!border-0">
                              <a    class="px-4 py-2 bg-red-600 text-white rounded-lg"
                                    href="/admin/product-management/edit?id=${product.id}">Edit</a>
                              </td>
                        </tr>
                  </c:forEach>
                  </tbody>    
            </table>
            <div
                  class="my-4 [&>*]:p-2 [&>*]:px-4 [&>*]:bg-gray-200 [&>*]:border [&>*]:rounded-md flex justify-center gap-2 ">
                  <a href="/admin/product-management/search?pageNumber=0&keyword=${keyword}">first</a>
                  <a href="/admin/product-management/search?pageNumber=${productPages.number-1 < 0 ? 0 : productPages.number-1}&keyword=${keyword}">prev</a>
                  <div>
                        <span > ${productPages.number+1}</span>
                        of
                        <span>${productPages.totalPages}</span>
                  </div>
                  <a href="/admin/product-management/search?pageNumber=${productPages.number+ 1 == productPages.totalPages ? productPages.totalPages - 1 : productPages.number+1 }&keyword=${keyword}">next</a>
                  <a href="/admin/product-management/search?pageNumber=${productPages.totalPages}&keyword=${keyword}">last</a>
            </div>
      </div>
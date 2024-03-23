<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <form:form class="m-auto w-1/4 flex flex-col  [&>.input]:p-2 [&>.input]:rounded-lg gap-2 [&>.input]:border " 
            action="/admin/brand-management/create"
            modelAttribute="brand">
            <h1>Category</h1>
            <form:input class="input border rounded-lg" type="text" path="id" placeholder="id"/>
            <form:input class="input border rounded-lg" type="text" path="name" placeholder="Name"/>
           <div class="flex justify-center gap-2">
            <a href="/admin/brand-management/delete" class="border rounded-lg p-2 text-center">Delete</a>
            <a href="/admin/brand-management/cancel" class="border rounded-lg p-2 text-center">Cancel</a>
            <button formaction="/admin/brand-management/create" class="border rounded-lg p-2 text-center">Save</button>
           </div>
      </form:form>
      <table class="w-1/2 m-auto mt-2 [&>*>*>*]:text-center [&>*>*>*]:border ">
            <thead>
                  <tr>
                        <th>id</th>
                        <th>Name</th>
                  </tr>
            </thead>
            <tbody>
                   <c:forEach var="brand" items="${brands}" > 
                  <tr>
                        <td >${brand.id}</td>
                        <td >${brand.name}</td>
                        <td class="flex justify-center"><a class=" m-auto bg-red-600 py-1 px-4 border  text-white rounded-lg  " href="/admin/brand-management/edit/${brand.id}">Edit</a></td>
                  </tr>
            </tbody>
                   </c:forEach>
      </table>
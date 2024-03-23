<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="px-10">
       <div class="flex gap-10">
            <form:form 
                  action="/admin/product-management/save"
                  method="POST"
                  modelAttribute="product"
                  enctype="multipart/form-data"
                  class="w-96 m-auto flex gap-2  flex-col justify-center items-center [&>div]:w-full [&>div]:items-center [&>div]:flex [&>div>label]:w-32  [&>*>.input]:p-2 [&>*>.input]:rounded-lg  [&>.input]:border">
                  <div>
                        <form:label path="id" cssErrorClass="title error">Id</form:label>
                        <form:input id="productId" readonly="true" class="input border flex-1" path="id" name="keyword" type="text"/>
                  </div>
                   <div>
                        <form:label path="name" cssErrorClass="title error">name</form:label>
                        <form:input class="input border flex-1" path="name" name="keyword" type="text"/>
                  </div>

                  <div>
                        <form:label path="price" cssErrorClass="title error">price</form:label>
                        <form:input class="input border flex-1" path="price" name="keyword" type="number"/>
                  </div>
                  <div class="">
                        <label>genderSpecific</label>
                        <div>   
                              <form:radiobutton id="man" path="genderSpecific" value="true" class="input  border checked:outline-sky-400" /> 
                              <label for="man"   class="me-2">Man</label>
                              <form:radiobutton id="woman" path="genderSpecific" value="false" class="input  border checked:outline-sky-400"/>
                              <label for="woman">woman</label>
                        </div>
                  </div>
                  <div>
                        <form:label path="brand" cssErrorClass="title error">brand</form:label>
                        <form:select class="input flex-1"  path="brand">
                              <form:option value="NONE"> --SELECT--</form:option>
                              <form:options items="${brands}" itemValue="id" itemLabel="name"></form:options>
                        </form:select>
                  </div>
                  <div class="">
                        <form:label path="available" cssErrorClass="title error">available</form:label>
                        <form:checkbox class="input  border checked:outline-sky-400" path="available" name="keyword" />
                  </div>
                  <div class="">
                        <label>Description</label>
                        <form:textarea path="description" class="input flex-1"></form:textarea>
                  </div>
                  <div class="m-auto my-4 flex justify-center gap-2">
                        <a href="/admin/product-management/delete?id=${product.id}" class="border p-2 bg-red-600 text-white px-4 rounded-lg">Delete</a>
                        <button class="border p-2 bg-blue-600 text-white px-4 rounded-lg">Save</button>
                        <a href="/admin/product-management" class="border p-2 bg-gray-200 px-4 rounded-lg">Reset</a>
                  </div>
            </form:form>
                  <input hidden type="file" id="imageUpload" name="imageUpload" size="500" multiple />
            <form 
                  action="#"
                  method="post"
                  enctype="multipart/form-data" 
                  id="product-images" class="border h-96 flex-1 grid grid-cols-3 gap-4 p-4 overflow-y-auto">
                  <label class="aspect-[1]" for="imageUpload">
                        <div class="aspect-[1] border flex items-center text-center justify-center">
                              Thêm ảnh
                        </div>
                  </label>
            </form>
      </div>
            <progress id="progressBar" value="0" max="100"></progress> 
<script src="/js/product-management.js"></script>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
<form action="${pageContext.request.contextPath}/admin/category/insert" method = "post" enctype="multipart/form-data">
  <label for="categoryname">Category Name:</label><br>
  <input type="text" id="categoryname" name="categoryname"><br>
  <label for="image">Link image:</label><br>
  <input type="text" id="image" name="image"><br><br>
  <label for="image1">Upload File:</label><br>
  <input type="file" id="image1" name="image1"><br><br>
  
  <input type="radio" id="action" name="status" value="1">
  <label for="action">Hoạt động</label><br>
  <input type="radio" id="lock" name="status" value="0">
  <label for="lock">Khóa</label><br>
  <input type="submit" value="Insert">
</form> 
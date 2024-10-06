<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
<form action="${pageContext.request.contextPath}/admin/category/update" method = "post" enctype="multipart/form-data">
  <input type = "text" name = "categoryid" hidden="hidden" value = "${cate.categoryId}">
  <label for="categoryname">Category Name:</label><br>
  <input type="text" id="categoryname" name="categoryname" value = "${cate.categoryName}"><br>
  
 <c:choose>
    <c:when test="${not empty cate and not empty cate.image and cate.image.substring(0,5) == 'https'}">
        <c:url value="${cate.image}" var="imgUrl"></c:url>
    </c:when>
    <c:when test="${not empty cate and not empty cate.image and cate.image.substring(0,5) != 'https'}">
        <c:url value="/image?fname=${cate.image}" var="imgUrl"></c:url>
    </c:when>
    <c:otherwise>
        <c:url value="/image?fname=default_image.jpg" var="imgUrl"></c:url> <!-- Hình ảnh mặc định nếu null -->
    </c:otherwise>
</c:choose>

<td><img height="150" width="200" src="${imgUrl}" /></td>

  <label for="image1">Upload File:</label><br>
  <input type="file" id="image1" name="image1"><br><br>
</br>
  
  <input type="radio" id="action" name="status" value="1">
  <label for="action">Hoạt động</label><br>
  <input type="radio" id="lock" name="status" value="0">
  <label for="lock">Khóa</label><br>
  <input type="submit" value="Insert">
</form> 
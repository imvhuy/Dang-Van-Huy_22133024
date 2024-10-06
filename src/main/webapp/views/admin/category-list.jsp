<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

<a href="<c:url value='/admin/category/add'/>"
				class="center">Add Category</a>
<table>
	<tr>
		<th>STT</th>
		<th>Image</th>
		<th>Category Name</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
<c:forEach items="${cateList}" var="cate" varStatus="STT">
    <tr>
        <td>${STT.index + 1}</td>

        <c:choose>
            <c:when test="${not empty cate and not empty cate.image and cate.image.substring(0,5) == 'https'}">
                <c:url value="${cate.image}" var="imgUrl"></c:url>
            </c:when>
            <c:when test="${not empty cate and not empty cate.image and cate.image.substring(0,5) != 'https'}">
                <c:url value="/image?fname=${cate.image}" var="imgUrl"></c:url>
            </c:when>
            <c:otherwise>
                <c:url value="/image?fname=default_image.jpg" var="imgUrl"></c:url> <!-- Default image if null -->
            </c:otherwise>
        </c:choose>

        <td><img height="150" width="200" src="${imgUrl}" /></td>

        <c:choose>
            <c:when test="${not empty cate and not empty cate.categoryName}">
                <td>${cate.categoryName}</td>
            </c:when>
            <c:otherwise>
                <td>No Category Name</td>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${not empty cate and not empty cate.status}">
                <td>${cate.status}</td>
            </c:when>
            <c:otherwise>
                <td>No Status</td>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${not empty cate}">
                <td>
                    <a href="<c:url value='/admin/category/edit?id=${cate.categoryId }'/>" class="center">Sửa</a> | 
                    <a href="<c:url value='/admin/category/delete?id=${cate.categoryId }'/>" class="center">Xóa</a>
                </td>
            </c:when>
            <c:otherwise>
                <td>Actions unavailable</td>
            </c:otherwise>
        </c:choose>
    </tr>
</c:forEach>

</table>

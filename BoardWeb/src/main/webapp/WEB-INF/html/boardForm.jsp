<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>



<h3>게시글 등록화면(boardForm.jsp)</h3>
<input type="hidden" name="logId" value="${logId }">
<form action="board.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="25" rows="3" name="content"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${logId }"></td>
		</tr>	
		<tr>
			<th>이미지</th>
			<td><input type="file" name="img" class="form-control" ></td>
		</tr>	
		<tr>
			<th colspan="2" align="center"></th>
			<td><input type="submit" value="게시글 등록"></td>
		</tr>
	</table>
</form>



<jsp:include page="../includes/footer.jsp"></jsp:include>
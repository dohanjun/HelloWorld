<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>수정화면입니다.</h3>
<%
BoardVO bdao = (BoardVO) request.getAttribute("board");
%>
<form action="modifyboard.do">
<input name="board_no" value="<%=bdao.getBoardNo()%>">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><%=bdao.getBoardNo()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="title" value="<%=bdao.getTitle()%>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type="text" name="content" value="<%=bdao.getContent()%>"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=bdao.getWriter()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=bdao.getContent()%></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td><%=bdao.getCreationDate()%></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="submit"
				class="btn btn-warning" value="저장"></td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>
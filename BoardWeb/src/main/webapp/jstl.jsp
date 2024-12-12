<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL연습</title>
</head>
<body>
	<!-- 1. JSTL 라이브러리생성 -->
	<!-- 2.	JSTL 태그 지시자 선언 -->

	<!-- 1. JSTL 라이브러리생성 -->
	<c:set var="myName" value="홍길동" />
	<c:out value="${myName }" /><!-- out태그 = 출력 -->
	
	
	
	
	<!-- myAge 변수에 20 값을 저장 -->
	<c:set var="myAge" value="20" />
	<!-- h3태그로 저장된 값을 출력. -->
	<h3><c:out value="${myAge }" /></h3>
	
	<!-- 조건문. 
	<c:if test="${myAge >= 20 }">
	<p>성인입니다.</p>
	</c:if>-->
	
	<c:choose>
		<c:when test="${myAge >= 20 }">
			<p>성인입니다.</p>
		</c:when>
		<c:otherwise>
			<P>미성년입니다.</P>
		</c:otherwise>
	</c:choose>
	
	<!-- score = 85 저장. -->
	<!-- score가 90이상이면 A, 80이상이면 B, 70이상이면 C, 그외 D -->
	
	
		<c:set var="myScore" value="75" />
	<!-- h3태그로 저장된 값을 출력. -->
	<h3><c:out value="${myScore }" /></h3>
	
	
	<c:choose>
		<c:when test="${myScore >= 90 }">
			<p>A</p>
		</c:when>
		<c:when test="${myScore >= 80 }">
			<p>B</p>
		</c:when>
		<c:when test="${myScore >= 70 }">
			<p>C</p>
		</c:when>
		<c:otherwise>
			<P>D</P>
		</c:otherwise>
	</c:choose>
	
	
	<!-- 반복문 for(int i = 1; i<10; i++){}-->
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:if test="${i%2 == 0 }">		
		<p><c:out value="8 * ${i } = ${8*i }" /></p>
		</c:if>
		
	</c:forEach>
	
	
</body>
</html>
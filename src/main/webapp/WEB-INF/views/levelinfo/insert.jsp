<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<c:if test="${!empty insertliList}">
		<c:if test="${insertliList eq 1 }">
			<script>
				alert("나는 똥멍청이")
				location.href = '/levelinfo'
			</script>
		</c:if>
	</c:if>
	<form action="/levelinfo" method="post">
		liName : <input type="text" name="liName"><br> liLevel :
		<input type="text" name="liLevel"><br> liDesc : <input
			type="text" name="liDesc"><br>
		<button>레벨등록</button>
	</form>
</body>
</html>
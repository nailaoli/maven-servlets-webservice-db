<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntrada"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkEntrada}" method="post">
		<label for = "login">Login:</label>
		<input type="text" name="login" /> <br/>
		<label for = "senha">Senha:</label> 
		<input type="password" name="senha" /> <br/>
		<input type="hidden" name="acao" value="Login" />
		<br/>
		<input type="submit" />
	</form>
</body>
</html>
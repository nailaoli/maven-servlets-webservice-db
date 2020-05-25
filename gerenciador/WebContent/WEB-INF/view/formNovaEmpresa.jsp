<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntrada"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action="${linkEntrada}" method="post">
		<label for = "nome">Nome:</label>
		<input type="text" name="nome" /> <br/>
		<label for = "data">Data:</label> 
		<input type="text" name="data" /> <br/>
		<input type="hidden" name="acao" value="NovaEmpresa" />
		<br/>
		<input type="submit" />
	</form>
</body>
</html>
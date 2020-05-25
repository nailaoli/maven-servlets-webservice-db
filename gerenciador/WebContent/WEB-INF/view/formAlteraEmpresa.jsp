<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntrada"/>
<!DOCTYPE html>
<html>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action="${linkEntrada}" method="post">
		<label for = "nome">Nome:</label>
		<input type="text" name="nome" value="${nome}"/> <br/>
		<label for = "data">Data:</label> 
		<input type="text" name="data" value='<fmt:formatDate value="${data}" pattern="dd/MM/yyyy"/>'/> <br/> 
		<input type="hidden" name="id" value="${id}" />
		<input type="hidden" name="acao" value="AlteraEmpresa" />
		<input type="submit" />
	</form>

</body>
</html>
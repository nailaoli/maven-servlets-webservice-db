<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntrada"/>
<fmt:parseDate value="${data}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />

<!DOCTYPE html>
<html>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action="${linkEntrada}" method="post">
		<label for = "nome">Nome:</label><br/>
		<input type="text" name="nome" value="${nome}"/><br/>
		<label for = "data">Data:</label><br/>
		<input type="text" name="data" value='<fmt:formatDate value="${parsedDate}" pattern="dd/MM/yyyy"/>'/><br/>
		<input type="hidden" name="id" value="${id}" />
		<input type="hidden" name="acao" value="AlteraEmpresa" />
		<label for = "categoria">Categoria:</label><br/>
		<select name="categoria">
			<c:forEach items="${categorias}" var="categoria">
				<c:choose>
					<c:when test="${categoria.id == categoriaId}">
						<option value="${categoria.id}" selected>${categoria.nome}</option>
					</c:when>
				<c:otherwise>
					<option value="${categoria.id}">${categoria.nome}</option>
				</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<br/>
		<br/>
		<input type="submit" />
	</form>
</body>
</html>
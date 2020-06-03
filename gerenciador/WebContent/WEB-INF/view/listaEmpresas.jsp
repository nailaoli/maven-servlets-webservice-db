<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, br.com.naila.gerenciador.modelo.Empresa, java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntrada"/>

<!DOCTYPE html>

<html>
<body>
	<c:import url="logout-parcial.jsp"/>
	Usuario logado: ${usuarioLogado.username}<br />
	<br>
	<c:if test="${not empty novaEmpresa}">
		Empresa ${novaEmpresa} cadastrada com sucesso! <br /> <br />
	</c:if>
	
	Lista de empresas <a href="${linkEntrada}?acao=ListaEmpresasOrdemAlfabetica">(ordenar)</a> :
	<br />
	<ul>
		<c:forEach items="${empresas}" var="empresa">

			<li>${empresa.nome} - 
			
			<fmt:parseDate  value="${empresa.data}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />
			<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy"/> -
					  
			<a href="${linkEntrada}?acao=MostraEmpresa&id=${empresa.id}"> altera </a> -
			<a href="${linkEntrada}?acao=RemoveEmpresa&id=${empresa.id}"> remove </a> 
			</li>
		</c:forEach>
	</ul>
	<a href="${linkEntrada}?acao=NovaEmpresaForm">Adicionar empresa</a>
</body>
</html>
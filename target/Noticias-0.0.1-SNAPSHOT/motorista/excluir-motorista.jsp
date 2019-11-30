<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Motorista ,br.com.atc.jdbc.dao.MotoristaDao" %>

<%
	String textId = request.getParameter("id");
	Integer id = Integer.parseInt(textId);
	
	Motorista motorista = new Motorista();
	motorista.setId(id);
	
	MotoristaDao dao = new MotoristaDao();
	boolean deletou = dao.remove(motorista);
	String mensagem = null;
	
	if(deletou){
		response.sendRedirect("lista-motorista.jsp");
	} else {
		mensagem = "Erro ao Deletar";
	}

%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Motorista</title>
</head>
<body>
	<h1><%=mensagem%></h1>
</body>
</html>
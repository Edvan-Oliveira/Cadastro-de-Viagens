<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Viagem ,br.com.atc.jdbc.dao.ViagemDao" %>

<%
	String textId = request.getParameter("id");
	Integer id = Integer.parseInt(textId);
	
	Viagem viagem = new Viagem();
	viagem.setId(id);
	
	ViagemDao dao = new ViagemDao();
	boolean deletou = dao.remove(viagem);
	String mensagem = null;
	
	if(deletou){
		response.sendRedirect("lista-viagem.jsp");
	} else {
		mensagem = "Erro ao Deletar";
	}

%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Viagem</title>
</head>
<body>
	<h1><%=mensagem%></h1>
</body>
</html>
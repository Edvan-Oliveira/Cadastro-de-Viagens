<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Passageiro ,br.com.atc.jdbc.dao.PassageiroDao" %>

<%
	String textId = request.getParameter("id");
	Integer id = Integer.parseInt(textId);
	
	Passageiro passageiro = new Passageiro();
	passageiro.setId(id);
	
	PassageiroDao dao = new PassageiroDao();
	boolean deletou = dao.remove(passageiro);
	String mensagem = null;
	
	if(deletou){
		response.sendRedirect("lista-passageiro.jsp");
	} else {
		mensagem = "Erro ao Deletar";
	}

%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Passageiro</title>
</head>
<body>
	<h1><%=mensagem%></h1>
</body>
</html>
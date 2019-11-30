<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Motorista ,br.com.atc.jdbc.dao.MotoristaDao" %>

<%
	String textId = request.getParameter("id");
	Integer id = Integer.parseInt(textId);
	
	Motorista motorista = new Motorista();

	motorista.setId(Integer.parseInt(request.getParameter("id")));
	motorista.setNome(request.getParameter("nome"));
	motorista.setSobreNome(request.getParameter("sobreNome"));
	motorista.setTelefone(request.getParameter("telefone"));
	motorista.setEmail(request.getParameter("email"));
	motorista.setCpf(request.getParameter("cpf"));
	motorista.setSenha(request.getParameter("senha"));
	
	MotoristaDao dao = new MotoristaDao();
	boolean alterou = dao.altera(motorista);
	String mensagem = null;
	
	if(alterou){
		response.sendRedirect("lista-motorista.jsp");
	} else {
		mensagem = "Erro ao Atualizar o Motorista";
	}
	
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Motorista</title>
</head>
<body>
	<h1><%=mensagem%></h1>
</body>
</html>
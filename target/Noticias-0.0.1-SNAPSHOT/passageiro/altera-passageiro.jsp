<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Passageiro ,br.com.atc.jdbc.dao.PassageiroDao" %>

<%
	String textId = request.getParameter("id");
	Integer id = Integer.parseInt(textId);
	
	Passageiro passageiro = new Passageiro();

	passageiro.setId(Integer.parseInt(request.getParameter("id")));
	passageiro.setNome(request.getParameter("nome"));
	passageiro.setSobreNome(request.getParameter("sobreNome"));
	passageiro.setTelefone(request.getParameter("telefone"));
	passageiro.setEmail(request.getParameter("email"));
	passageiro.setCpf(request.getParameter("cpf"));
	passageiro.setSenha(request.getParameter("senha"));
	
	PassageiroDao dao = new PassageiroDao();
	boolean alterou = dao.altera(passageiro);
	String mensagem = null;
	
	if(alterou){
		response.sendRedirect("lista-passageiro.jsp");
	} else {
		mensagem = "Erro ao Atualizar o Passageiro";
	}
	
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Passageiro</title>
</head>
<body>
	<h1><%=mensagem%></h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import="br.com.atc.jdbc.modelo.Passageiro, br.com.atc.jdbc.dao.PassageiroDao" %>
<!DOCTYPE html>

<%
	Passageiro passageiro = new Passageiro();

	passageiro.setNome(request.getParameter("nome"));
	passageiro.setSobreNome(request.getParameter("sobreNome"));
	passageiro.setTelefone(request.getParameter("telefone"));
	passageiro.setEmail(request.getParameter("email"));
	passageiro.setCpf(request.getParameter("cpf"));
	passageiro.setSenha(request.getParameter("senha"));
	
	PassageiroDao dao = new PassageiroDao();
	
	boolean salvou = dao.adiciona(passageiro);
	String mensagem = null;
	
	if(salvou){
		response.sendRedirect("lista-passageiro.jsp");
	} else {
		mensagem = "Erro ao cadastrar.";
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salvar Passageiro</title>
</head>
<body>
	<h1><%=mensagem%></h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import="br.com.atc.jdbc.modelo.Motorista, br.com.atc.jdbc.dao.MotoristaDao" %>
<!DOCTYPE html>

<%
	Motorista motorista = new Motorista();

	motorista.setNome(request.getParameter("nome"));
	motorista.setSobreNome(request.getParameter("sobreNome"));
	motorista.setTelefone(request.getParameter("telefone"));
	motorista.setEmail(request.getParameter("email"));
	motorista.setCpf(request.getParameter("cpf"));
	motorista.setSenha(request.getParameter("senha"));
	
	MotoristaDao dao = new MotoristaDao();
	
	boolean salvou = dao.adiciona(motorista);
	String mensagem = null;
	
	if(salvou){
		response.sendRedirect("lista-motorista.jsp");
	} else {
		mensagem = "Erro ao cadastrar.";
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salvar Motorista</title>
</head>
<body>
	<h1><%=mensagem%></h1>
</body>
</html>
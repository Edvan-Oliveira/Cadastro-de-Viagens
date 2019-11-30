<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Viagem ,br.com.atc.jdbc.dao.ViagemDao" %>

<%
	String textId = request.getParameter("id");
	Integer id = Integer.parseInt(textId);
	
	Viagem viagem = new Viagem();

	viagem.setId(Integer.parseInt(request.getParameter("id")));
	viagem.setMotoristaId(Integer.parseInt(request.getParameter("motoristaId")));
	viagem.setPassageiroId(Integer.parseInt(request.getParameter("passageiroId")));
	viagem.setInicioViagem(request.getParameter("inicioViagem"));
	viagem.setDestinoViagem(request.getParameter("destinoViagem"));

	ViagemDao dao = new ViagemDao();
	boolean alterou = dao.altera(viagem);
	String mensagem = null;
	
	if(alterou){
		response.sendRedirect("lista-viagem.jsp");
	} else {
		mensagem = "Erro ao Atualizar o Motorista";
	}
	
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Viagem</title>
</head>
<body>
	<h1><%=mensagem%></h1>
</body>
</html>
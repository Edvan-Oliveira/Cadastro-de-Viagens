<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import="br.com.atc.jdbc.modelo.Viagem, br.com.atc.jdbc.dao.ViagemDao" %>
<!DOCTYPE html>

<%
	Viagem viagem = new Viagem();

	viagem.setMotoristaId(Integer.parseInt(request.getParameter("motoristaId")));
	viagem.setPassageiroId(Integer.parseInt(request.getParameter("passageiroId")));
	viagem.setInicioViagem(request.getParameter("inicioViagem"));
	viagem.setDestinoViagem(request.getParameter("destinoViagem"));

	
	ViagemDao dao = new ViagemDao();
	
	boolean salvou = dao.adiciona(viagem);
	String mensagem = null;
	
	if(salvou){
		response.sendRedirect("lista-viagem.jsp");
	} else {
		mensagem = "Erro ao cadastrar.";
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salvar Viagem</title>
</head>
<body>
	<h1><%=mensagem%></h1>
</body>
</html>
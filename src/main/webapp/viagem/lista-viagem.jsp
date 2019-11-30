<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Viagem, br.com.atc.jdbc.dao.ViagemDao,
 	java.util.List" %>

<%
	List<Viagem> viagens = new ViagemDao().getLista();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Viagens</title>
<link href="../css/estilo.css" rel="stylesheet" type="text/css">
<style>
	th, td {padding: 5px;}
	th {background-color: #c2c2cf;}
	table {margin: 0 auto 0 auto; text-align: center;}
	footer {margin-top: 280px;}
	#novo {color: #037ea3; font-size: 40px; text-decoration: none;}
	
</style>
</head>
<body>
	<header>
		<div class="container">
			<div id="marca">
				<img src="../imagens/logoCarro.png" height="80px;">
			</div>
			
			<div id="menu">
				<a href="lista-viagem.jsp">Viagem</a>
				<a href="../motorista/lista-motorista.jsp">Motorista</a>
				<a href="../passageiro/lista-passageiro.jsp">Passageiro</a>
			</div>
		</div>
	</header>
	<h1>Lista de Viagens - <a id="novo" href="cadastro-viagem.html" >+ nova viagem</a></h1>
	
	<table border="1">
		<tr>
			<th>Cod. Viagem</th>
			<th>Inicio da Viagem</th>
			<th>Destino da Viagem</th>
			<th>Cod. Motorista</th>
			<th>Cod. Passageiro</th>
			<th colspan="2">Ação</th>
		</tr>
		
		<% for(Viagem viagem: viagens){	
		%>
			<tr>
				<td><%=viagem.getId()%></td>
				<td><%=viagem.getInicioViagem()%></td>
				<td><%=viagem.getDestinoViagem()%></td>
				<td><%=viagem.getMotoristaId()%></td>
				<td><%=viagem.getPassageiroId()%></td>
				<td><a href="editar-viagem.jsp?id=<%=viagem.getId()%>" Style="padding: 5px;">Editar</a></td>
				<td><a href="excluir-viagem.jsp?id=<%=viagem.getId()%>" Style="padding: 5px;">Excluir</a></td>
			</tr>
		<%
		}		
		%>
	</table>
	<footer>
		Desenvolvido Por Edvan Oliveira
	</footer>
</body>
</html>
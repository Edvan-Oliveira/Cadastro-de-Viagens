<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Motorista, br.com.atc.jdbc.dao.MotoristaDao,
 	java.util.List" %>

<%
	List<Motorista> motoristas = new MotoristaDao().getLista();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Motoristas</title>
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
				<a href="../viagem/lista-viagem.jsp">Viagem</a>
				<a href="lista-motorista.jsp">Motorista</a>
				<a href="../passageiro/lista-passageiro.jsp">Passageiro</a>
			</div>
		</div>
	</header>
	<h1>Lista de Motoristas - <a id="novo" href="cadastro-motorista.html" >+ novo motorista</a></h1>
	
	<table border="1">
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Sobre Nome</th>
			<th>Telefone</th>
			<th>E-mail</th>
			<th>CPF</th>
			<th>Senha</th>
			<th colspan="2">Ação</th>
		</tr>
		
		<% for(Motorista motorista: motoristas){	
		%>
			<tr>
				<td><%=motorista.getId()%></td>
				<td><%=motorista.getNome()%></td>
				<td><%=motorista.getSobreNome()%></td>
				<td><%=motorista.getTelefone()%></td>
				<td><%=motorista.getEmail()%></td>
				<td><%=motorista.getCpf()%></td>
				<td><%=motorista.getSenha()%></td>
				<td><a href="editar-motorista.jsp?id=<%=motorista.getId()%>" Style="padding: 5px;">Editar</a></td>
				<td><a href="excluir-motorista.jsp?id=<%=motorista.getId()%>" Style="padding: 5px;">Excluir</a></td>
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
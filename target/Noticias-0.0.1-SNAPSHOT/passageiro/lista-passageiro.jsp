<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Passageiro, br.com.atc.jdbc.dao.PassageiroDao,
 	java.util.List" %>

<%
	List<Passageiro> passageiros = new PassageiroDao().getLista();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Passageiros</title>
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
				<a href="../motorista/lista-motorista.jsp">Motorista</a>
				<a href="lista-passageiro.jsp">Passageiro</a>
			</div>
		</div>
	</header>
	<h1>Lista de Passageiros - <a id="novo" href="cadastro-passageiro.html" >+ novo passageiro</a></h1>
	
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
		
		<% for(Passageiro passageiro: passageiros){	
		%>
			<tr>
				<td><%=passageiro.getId()%></td>
				<td><%=passageiro.getNome()%></td>
				<td><%=passageiro.getSobreNome()%></td>
				<td><%=passageiro.getTelefone()%></td>
				<td><%=passageiro.getEmail()%></td>
				<td><%=passageiro.getCpf()%></td>
				<td><%=passageiro.getSenha()%></td>
				<td><a href="editar-passageiro.jsp?id=<%=passageiro.getId()%>" Style="padding: 5px;">Editar</a></td>
				<td><a href="excluir-passageiro.jsp?id=<%=passageiro.getId()%>" Style="padding: 5px;">Excluir</a></td>
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
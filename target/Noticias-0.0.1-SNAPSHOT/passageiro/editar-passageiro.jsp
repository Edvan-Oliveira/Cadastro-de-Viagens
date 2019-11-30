<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Passageiro ,br.com.atc.jdbc.dao.PassageiroDao" %>

<%
	String textId = request.getParameter("id");
	Integer id = Integer.parseInt(textId);
	
	PassageiroDao dao = new PassageiroDao();
	Passageiro passageiro = new PassageiroDao().pesquisa(id);
	
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Passageiro</title>
<link href="../css/estilo.css" rel="stylesheet" type="text/css">
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
	<div class="container">
		<h1>Editar os Dados do Passageiro</h1>
		<form action="altera-passageiro.jsp">
			
			<div id="esquerda">
				<label for="nome">Nome: </label><br>
				<input type="text" name="nome" id="nome" value="<%=passageiro.getNome()%>"><br><br>
				
				<label for="sobreNome">Sobre Nome: </label><br>
				<input type="text" name="sobreNome" id="sobreNome" value="<%=passageiro.getSobreNome()%>"><br><br>
				
				<label for="telefone">Telefone: </label><br>
				<input type="text" name="telefone" id="telefone" value="<%=passageiro.getTelefone()%>"><br><br>
			</div>
			
			<div id="direita">
				<label for="email">E-mail: </label><br>
				<input type="text" name="email" id="email" value="<%=passageiro.getEmail()%>"><br><br>
				
				<label for="cpf">CPF: </label><br>
				<input type="text" name="cpf" id="cpf" value="<%=passageiro.getCpf()%>"><br><br>
				
				<label for="senha">Criar Senha: </label><br>
				<input type="password" name="senha" id="senha" value="<%=passageiro.getSenha()%>"><br>
			</div>
			
			<input type="hidden" name="id" value="<%=passageiro.getId()%>">

			<div id="clear">
				<input type="submit" value="Atualizar">
			</div>
		</form>
	</div>
	<footer>
			Desenvolvido Por Edvan Oliveira
	</footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Motorista ,br.com.atc.jdbc.dao.MotoristaDao" %>

<%
	String textId = request.getParameter("id");
	Integer id = Integer.parseInt(textId);
	
	MotoristaDao dao = new MotoristaDao();
	Motorista motorista = new MotoristaDao().pesquisa(id);
	
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Motorista</title>
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
				<a href="lista-motorista.jsp">Motorista</a>
				<a href="../passageiro/lista-passageiro.jsp">Passageiro</a>
			</div>
		</div>
	</header>
	<div class="container">
		<h1>Editar os Dados do Motorista</h1>
		<form action="altera-motorista.jsp">
			
			<div id="esquerda">
				<label for="nome">Nome: </label><br>
				<input type="text" name="nome" id="nome" value="<%=motorista.getNome()%>"><br><br>
				
				<label for="sobreNome">Sobre Nome: </label><br>
				<input type="text" name="sobreNome" id="sobreNome" value="<%=motorista.getSobreNome()%>"><br><br>
				
				<label for="telefone">Telefone: </label><br>
				<input type="text" name="telefone" id="telefone" value="<%=motorista.getTelefone()%>"><br><br>
			</div>
			
			<div id="direita">
				<label for="email">E-mail: </label><br>
				<input type="text" name="email" id="email" value="<%=motorista.getEmail()%>"><br><br>
				
				<label for="cpf">CPF: </label><br>
				<input type="text" name="cpf" id="cpf" value="<%=motorista.getCpf()%>"><br><br>
				
				<label for="senha">Criar Senha: </label><br>
				<input type="password" name="senha" id="senha" value="<%=motorista.getSenha()%>"><br>
			</div>
			
			<input type="hidden" name="id" value="<%=motorista.getId()%>">

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
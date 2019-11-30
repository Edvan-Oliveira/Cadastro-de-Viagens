<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ page import="br.com.atc.jdbc.modelo.Viagem ,br.com.atc.jdbc.dao.ViagemDao" %>

<%
	String textId = request.getParameter("id");
	Integer id = Integer.parseInt(textId);
	
	ViagemDao dao = new ViagemDao();
	Viagem viagem = new ViagemDao().pesquisa(id);
	
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Viagem</title>
<link href="../css/estilo.css" rel="stylesheet" type="text/css">
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
	<div class="container">
		<h1>Editar os Dados da Viagem</h1>
		<form action="altera-viagem.jsp">
			
			<div id="esquerda">
				<label for="motoristaId">Código do Motorista: </label><br>
				<input type="number" name="motoristaId" id="motoristaId" value="<%=viagem.getMotoristaId()%>" min="1" required><br><br>
				
				<label for="passageiroId">Código do Passageiro: </label><br>
				<input type="number" name="passageiroId" id="passageiroId" value="<%=viagem.getPassageiroId()%>" min="1" required><br><br>
			</div>
			
			<div id="direita">
				<label for="inicoViagem">Inicio da Viagem: </label><br>
				<input type="text" name="inicioViagem" id="inicioViagem" value="<%=viagem.getInicioViagem()%>" required><br><br>
				
				<label for="destinoViagem">Destino da Viagem: </label><br>
				<input type="text" name="destinoViagem" id="destinoViagem" value="<%=viagem.getDestinoViagem()%>" required><br><br>
			</div>
			
			<input type="hidden" name="id" value="<%=viagem.getId()%>">

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
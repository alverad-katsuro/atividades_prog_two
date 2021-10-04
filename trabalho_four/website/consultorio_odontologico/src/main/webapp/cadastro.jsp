<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.html" %>
<script src="./script/val_cli.js"></script>
</head>
<body>
<%@include file="menu_bar.html" %>

<div class="container">
	<div class="field">
	  <label class="label">Nome</label>
	  <div class="control">
	    <input class="input" name="nome" type="text" placeholder="Nome">
	  </div>
	</div>

	<div class="field">
	  <label class="label">Idade</label>
	  <div class="control">
	    <input class="input" name="idade" type="text" placeholder="Idade">
	  </div>
	</div>
	
	<div class="field">
	  <label class="label">CPF</label>
	  <div class="control">
	    <input class="input" name="cpf" type="text" placeholder="xxx.xxx.xxx-xx">
	  </div>
	</div>
	
	<div class="field">
	  <label class="label">Email</label>
	  <div class="control">
	    <input class="input" name="email" type="text" placeholder="xxxx@xxx.xx">
	  </div>
	</div>
	
	<div class="field">
		  <label class="label">Telefone</label>
		  <div class="control">
		    <input class="input" name="telefone" type="text" placeholder="(xx) xxxxx-xxxx">
		  </div>
	</div>
	
	<div class="field">
	  <label class="label">Sexo</label>
	  <div class="control">
	    <input class="input" name="sexo" type="text" placeholder="Sexo">
	  </div>
</div>

	<div class="field">
	  <label class="label">Plano</label>
	  <div class="control">
	    <input class="input" name="plano" type="text" placeholder="Plano">
	  </div>
	</div>
	
	<div class="field is-grouped" style="padding: 0 50%">
	  <div class="control">
	    <button class="button is-link" onclick="validar()">Cadastrar</button>
	  </div>
	  <div class="control">
	    <button class="button is-link is-light">Cancelar</button>
	  </div>
	</div>
</div>

</body>
</html>
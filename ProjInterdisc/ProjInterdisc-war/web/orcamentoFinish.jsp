<%-- 
    Document   : orcamentoFinish
    Created on : 07/05/2017, 14:20:49
    Author     : lgd25
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo_orcamento.css" rel="stylesheet" type="text/css"/>
        <title>iFix</title>
    </head>
    <body>
        
    <c:import url="menu.jsp"></c:import>
    <div id="main">
        <div id="conteudo">
            <h1 class="title">Itens do orçamento</h1>
            <form class="formulario" action="Controller" method="POST">
                
                <p>Descrição<br> <input type="text" name="desc_item" required="" /></p><br>
                <p>Valor <br><input type="number" step="0.01" placeholder="R$ 0,00"/></p><br>
                <p>Quantidade <br><input type="number"></p><br>
                <input type="hidden" name="command" value="Orcamento.addItem"/>
                <p><input type="submit" value="Adicionar Item"/></p>
                
            </form>
        </div>
    </div>
    </body>
</html>
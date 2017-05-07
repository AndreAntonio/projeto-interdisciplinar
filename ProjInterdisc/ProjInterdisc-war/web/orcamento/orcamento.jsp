<%-- 
    Document   : orcamento
    Created on : 07/05/2017, 14:20:33
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
            <h1 class="title">Dados iniciais do orçamento</h1>
            
            <div>
                <p>Nome do fornecedor de serviços: ${user.nome}</p><br>
                <p>Nome do cliente que solicitou orçamento: ${clienteSelect.nome}</p><br>
                <p>Tipo de serviço solicitado: ${servicoSolicitado}</p><br>
            </div>
            
            <form class="formulario" action="Controller" method="POST">
                
                <input type="hidden" name="command" value="Orcamento.start"/>
                <p><input type="submit" value="PRÓXIMO"/></p>
                
            </form>
        </div>
    </div>
    </body>
</html>

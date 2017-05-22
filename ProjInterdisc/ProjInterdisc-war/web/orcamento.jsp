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
        <div id="conteudo" style="margin-top: 200px;">
            <h1 class="title">Dados iniciais do orçamento</h1>
            
            <div style="margin-top: 30px;">
                <p><b>Nome do fornecedor de serviços:</b> ${user.nome}</p><br>
                <p><b>Nome do cliente que solicitou orçamento:</b> ${clienteSelect.nome}</p><br>
                <p><b>Tipo de serviço solicitado:</b> ${servicoSolicitado}</p><br>
            </div>
            
            <form class="formulario" action="Controller" method="POST">
                
                <input type="hidden" name="command" value="Orcamento.startOrcamento"/>
                <p style="margin-top: 15px;"><input type="submit" value="PRÓXIMO" style="width: 110px;"/></p>
                
            </form>
        </div>
    </div>
    <c:import url="footer.jsp"></c:import>
    </body>
</html>

<%-- 
    Document   : orcamentoTempoExec
    Created on : 14/05/2017, 10:27:50
    Author     : lgd25
--%>

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
            <h1 class="title">Tempo de Execução</h1>
            
           
            <form class="formulario" action="Controller" method="POST">
                
                <input type="hidden" name="command" value="Orcamento.setTempoExec"/>
                <p>Digite o tempo de execução: <input type="text" name="tempoExec" placeholder="Tempo de Execução" required/></p>
                <br><br>    
                <p><input type="submit" value="CONFIRMAR"/></p>
                
            </form>
        </div>
    </div>
    </body>
</html>


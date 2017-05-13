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
            <h1 class="title">Resumo do orçamento</h1>
            
            <p>Nome do fornecedor de serviços: ${user.nome}</p><br>
            <p>Nome do cliente que solicitou orçamento: ${clienteSelect.nome}</p><br>
            <p>Tipo de serviço solicitado: ${servicoSolicitado}</p><br>
            
            <form action="Controller" method="POST">
                Tempo de execução: <input type="text" name="tempoExec" required/>
                <input type="hidden" name="command" value="Orcamento.setTempoExec"/>
                <input type="submit" value="OK"/>
            </form>
            
            
             <table>
            <c:if test="${orcamento.getItemList().isEmpty()== false}">
                <tr style="background-color: #607D8B">
                    <td>Descrição do item</td>
                    <td>Valor unitário</td>
                    <td>Quantidade</td>                    
                </tr>
              
                <c:forEach items="${orcamento.getItemList()}" var="item">
                    <tr>
                        <td>${item.getDescricao()}</td>
                        <td>${item.getValor()}</td>
                        <td>${item.getQuantidade()}</td>                       
                    </tr>
                
                </c:forEach>
                    <tr style="background-color: #607D8B">
                        <td></td>                        
                        <td>Valor Total:</td>
                        <td>${orcamento.getValortot()}</td>
                    </tr>
            </c:if>  
            </table>
            
        </div>
    </div>
    </body>
</html>
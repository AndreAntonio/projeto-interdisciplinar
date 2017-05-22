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

                    <div style="margin-top: 30px;">
                    <p><b>Nome do fornecedor de serviços:</b> ${user.nome}</p><br>
                    <p><b>Nome do cliente que solicitou orçamento:</b> ${clienteSelect.nome}</p><br>
                    <p><b>Tipo de serviço solicitado:</b> ${servicoSolicitado}</p><br>
                    <p><b>Tempo de execução:</b> ${orcamento.tempoexecucao}</p>
                </div>
                
                <table style="border-top: 3px solid #93ACB5;border-bottom: 3px solid #93ACB5;margin-top: 30px;">
                    <c:if test="${orcamento.getItemList().isEmpty()== false}">
                        <tr style="background-color: #607D8B">
                            <td>Descrição do item</td>
                            <td>Valor unitário</td>
                            <td>Quantidade</td>                    
                        </tr>

                        <c:forEach items="${orcamento.getItemList()}" var="item">
                            <tr>
                                <td>${item.getDescricao()}</td>
                                <td><p style="float: left">R$</p>${item.getValor()}</td>
                                <td>${item.getQuantidade()}</td>                       
                            </tr>

                        </c:forEach>
                        <tr style="background-color: #607D8B">
                            <td></td>                        
                            <td>Valor Total:</td>
                            <td><p style="float: left">R$</p>${orcamento.getValortot()}</td>
                        </tr>
                    </c:if>  
                </table><br><br>

                <form method="POST" action="Controller">
                    <input type="submit" value="Confirmar Orçamento" style="width: 200px"/>
                    <input type="hidden" name="command" value="Orcamento.confirmaOrcamento"/>
                </form>
            </div>
        </div>
        <c:import url="footer.jsp"></c:import>
    </body>
</html>
<%-- 
    Document   : orcamento
    Created on : 02/05/2017, 16:19:47
    Author     : lgd25
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo_orcamento.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>iFix</title>
    </head>
    <body>
        
    <c:import url="menu.jsp"></c:import>
    
    <div id="main">
        <div id="conteudo" style="margin-top: 50px;">        
            <h1 class="title">Itens do orçamento</h1>
            <form class="formulario" action="Controller" method="POST">
                
                <p>Descrição<br> <input type="text" name="desc_item" required="" style="border-bottom: 2px solid #C20114;"/></p><br>
                <p>Valor <br><input type="number" step="0.01" placeholder="R$ 0,00" name="valor" style="border-bottom: 2px solid #C20114;"/></p><br>
                <p>Quantidade <br><input type="number" name="quant" value="1" style="border-bottom: 2px solid #C20114;"></p><br>
                <input type="hidden" name="command" value="Orcamento.addItem"/>
                <p><input type="submit" value="Adicionar Item" style="width: 150px;margin-top: 10px;"/></p>
                
            </form><br><br>
            <table style="border-top: 3px solid #93ACB5;border-bottom: 3px solid #93ACB5;">
            <c:if test="${orcamento.getItemList().isEmpty()== false}">
                <tr style="background-color: #607D8B">
                    <td>Descrição do item</td>
                    <td>Valor unitário</td>
                    <td>Quantidade</td>
                    <td>Remover</td>
                </tr>
              
                <c:forEach items="${orcamento.getItemList()}" var="item">
                    <tr>
                        <td>${item.getDescricao()}</td>
                        <td><p style="float: left">R$</p>${item.getValor()}</td>
                        <td>${item.getQuantidade()}</td>
                        <td><a href="Controller?command=Orcamento.removeItem&itemToRemoveDesc=${item.getDescricao()}&itemToRemoveValor=${item.getValor()}&itemToRemoveQuant=${item.getQuantidade()}"><i class="material-icons">clear</i></a></td>
                    </tr>
                
                </c:forEach>
                    <tr style="background-color: #607D8B">
                        <td></td>
                        <td></td>
                        <td>Valor Total:</td>
                        <td><p style="float: left">R$</p>${orcamento.getValortot()}</td>
                    </tr>
            </c:if>  
            </table>
            
            <form method="POST" action="Controller">
                <input type="submit" value="PRÓXIMO" style="margin-top: 50px;width: 110px;"/>
                <input type="hidden" name="command" value="Orcamento.confirmaItem"/>
            </form>
        </div>
        
           
        
    </div>
    <c:import url="footer.jsp"></c:import>
    </body>
</html>

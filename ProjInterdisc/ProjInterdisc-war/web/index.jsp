

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo_orcamento.css" rel="stylesheet" type="text/css"/>
        <title>iFix</title>
    </head>
    <body>
        <c:import url="menu.jsp"></c:import>
        <h1>Nota Fiscal</h1>
        
      
       
        
        <form method="POST" action="Controller">
            <input type="hidden" name="command" value="NotaFiscal.test"/>
      
                    
                    
                    <table>
                        <tr>
                            
                        <th>Termo de Contrato</th>
                        <th>Cliente</th>
                        <th>Fornecedor</th>
                        <th>Pagamento</th>
                        <th>Itens</th>
                        <th>Valor Total</th>
                        
                        </tr>
                        <tr>
                    <td>${Nota_Fiscal.fkContrato.termodocontrato}</td>
                    <td> ${Nota_Fiscal.fkContrato.idContratoCliente.nome}</td>
                    <td>${Fornecedor.nome} ${Fornecedor.cpf}</td>
                    <td> Cartao de Credito (${Pagamento.tipo})</td>
                    
                    <td>${Item.descricao}: R$${Item.valor}</td>
                    <td>R$${Item.valor+Item2.valor}</td>
                            <td> <input type="submit" value="Gerar Nota"/> </td>
                    
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>${Item2.descricao}: R$${Item2.valor}</td>
                            
                            
                            
                        </tr>
                    </table>
                    
            
        </form>
        
    </body>
</html>

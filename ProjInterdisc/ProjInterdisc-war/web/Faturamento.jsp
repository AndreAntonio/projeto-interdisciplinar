

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
     
        <div id="main">
            
            <h1> Dados Gerais</h1>
            
        </div>
            <table>
                        <tr>
                            
                        <th>Trabalhos Realizados</th>
                        
                        
                        <th>Valor Total Arrecadado</th>
                        
                        </tr>
                        <tr>
                    <td>${Trabalhos}</td>
                    <td> R$${Item.valor+Item2.valor}</td>
                    
                    
                        </tr>
                      
                    </table>
            
            
        
    </body>
</html>

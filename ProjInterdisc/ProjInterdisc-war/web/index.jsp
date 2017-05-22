<%-- 
    Document   : index
    Created on : 30/04/2017, 16:04:41
    Author     : lgd25
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iFix</title>
    </head>
    <body>
        <h1>Navegação entre modulos do sistema</h1>
        
        <a href="Controller?command=Orcamento.start">Orçamento</a>
        
        <form method="POST" action="Controller">
            <input type="hidden" name="command" value="Contrato.gerar"/>
      
                    <input type="submit" value="GERAR"/>
            
        </form>
        
    </body>
</html>

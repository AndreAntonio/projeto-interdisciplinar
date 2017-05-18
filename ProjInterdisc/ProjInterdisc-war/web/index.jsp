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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nota Fiscal</h1>
        
      <%-- <a href="Controller?command=NotaFiscal.start">Nota Fiscal</a> --%>
      
        <p>Nota Fiscal</p>
        
        <form method="POST" action="Controller">
            <input type="hidden" name="command" value="NotaFiscal.test"/>
      
                    <input type="submit" value="Gerar Nota"/>
            
        </form>
        
    </body>
</html>

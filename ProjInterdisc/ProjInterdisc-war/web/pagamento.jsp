<%-- 
    Document   : pagamento
    Created on : 03/05/2017, 21:36:37
    Author     : Paloma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagamento</title>
    </head>
    <body>
        <section>
            <h1>Comprador:</h1>
            <p>{u1.getNome()}</p>
            <p>{u1.getEmail()}</p>
        </section
        
        <section>
            <h2>Resumo do serviço contratado</h2>
            <p>Descrição do serviço:</p>
            <p>Total:</p>
        </section>
        
        <section>
            <p>Escolha a forma de pagamento:</p>
            <input type="radio" name="credito" value="credito"/>Cartão de crédito<br/>
            <input type="radio" name="debito" value="debito"/> Cartão de débito<br/>
            <input type="submit" name="boleto" value="Boleto Bancário"/><br/>

            <form action="" method="POST">
                <p>
                    <input type="text" name="num_cartao" placeholder="Número do cartão" required/><br>
                </p>
                <p>
                    <input type="text" name="nome" placeholder="Nome como está no cartão" required/><br>
                </p>
                <p>
                    <tr>Validade:
                        <td><input type="text" name="mes" placeholder="Mês" size="2" required/></td>
                        <td><input type="text" name="ano" placeholder="Ano" size="4" required/></td>
                    </tr>
                </p>
                <p>
                    <input type="text" name="codigo" placeholder="Código de segurança" required/><br>
                </p>
                <p>
                    <input type="submit" value="PAGAR"/>
                </p>
            </form>
        </section>
    </body>
</html>
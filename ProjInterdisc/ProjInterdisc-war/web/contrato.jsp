<%-- 
    Document   : contrato
    Created on : May 1, 2017, 3:17:04 PM
    Author     : Mariana
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contrato</title>
    </head>
    <body>
       <section class="VisualizarContrato">
                <h3>Cabeçalho</h3>
                <hr>
                <div class="contrato">
                    <section>
                        <h2>CONTRATADO</h2>
                        <table class="pessoaCabecalho" border="1">
                            <tbody>
                                <tr>
                                    <td colspan="5"><span>Nome:</span><span>&nbsp;${u1.getNome()}</span></td>
                                    <td><span>Estado Civil:</span><span>&nbsp;${u1.getSexo()}</span></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><span>Nacionalidade:</span><span>&nbsp;${u1.getNacionalidade()}</span></td>
                                    <td colspan="2"><span>Profissão:</span><span>&nbsp;${u1.getProfissao()}</span></td>
                                    
                                    <td colspan="2"><span>CPF:</span><span>&nbsp;451.166.538-97</span></td>
                                </tr>
                                <tr>
                                    <td><span>Residente e Domiciliado em:</span><span>&nbsp;sdfsdf</span></td>
                                    <td><span>UF:</span><span>&nbsp;sdfsdf</span></td>
                                    <td><span>Logradouro:</span><span>&nbsp;cerqueira ce</span></td>
                                    <td><span>Número:</span><span>&nbsp;333</span></td>
                                    <td><span>Bairro:</span><span>&nbsp;fsdfsdfr</span></td>
                                    <td><span>CEP:</span><span>&nbsp;05413-001</span></td>
                                </tr>
                            </tbody>
                        </table><br></section>
                    <section>
                        <h2>CONTRATANTE</h2>
                        <table class="pessoaCabecalho" border="1">
                            <tbody>
                                <tr>
                                    <td colspan="5"><span>Nome:</span><span>&nbsp;mariana</span></td>
                                    <td><span>Estado Civil:</span><span>&nbsp;Solteiro</span></td>
                                </tr>
                                <tr>
                                    <td><span>Nacionalidade:</span><span>&nbsp;brasileira</span></td>
                                    <td><span>Profissão:</span><span>&nbsp;estagiaria</span></td>
                                    <td colspan="2"><span>Cédula de Identidade:</span><span>&nbsp;378657161</span></td>
                                    <td colspan="2"><span>CPF:</span><span>&nbsp;424.269.226-99</span></td>
                                </tr>
                                <tr>
                                    <td><span>Residente e Domiciliado em:</span><span>&nbsp;são paulo</span></td>
                                    <td><span>UF:</span><span>&nbsp;sp</span></td>
                                    <td><span>Logradouro:</span><span>&nbsp;rua lisboa</span></td>
                                    <td><span>Número:</span><span>&nbsp;1194</span></td>
                                    <td><span>Bairro:</span><span>&nbsp;cerqueira cesar</span></td>
                                    <td><span>CEP:</span><span>&nbsp;05413-001</span></td>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                    </section>
                </div>
                
        <h3>Objeto</h3>
        <hr>
        <div class="contrato">
            <section>
                <p><b>Cláusula 1º</b> - O objeto do presente contrato é a prestação profissional de serviços de pedreiro pelo(a) Contratado(a) ao Contratante, 
                para execução de trabalho com as seguintes especificações: arrumar a casa.</p>
                <p><b>Cláusula 2º</b> - O serviço deverá ser prestado no endereço do 
                Contratante.</p>
            </section>
        </div>
                
        
        <h3>Prazo, Valor e Despesas de materiais</h3>
        <hr>
        <div class="contrato">
            <section>
                <p><b>Cláusula 3º</b> - O prazo para realização e entrega dos serviços contratados será de 2 (dois)    dias  , com início em 09/05/2017 e término em 11/05/2017.</p><p><b>Cláusula 4º</b> - O valor do presente contrato é <b>R$ 18.222,00</b> (<b>dezoito mil duzentos e vinte e dois reais</b>) que deverão ser pagos de acordo com a forma de pagamento pactuado neste contrato.</p>
                <p><b>Cláusula 5º</b> - O valor ajustado no presente contrato representa a soma do valor dos serviços mais aquisição do materiais necessários para sua execução, ficando a cargo da Contratada a aquisição, segundo as especificações descritas neste contrato, e transporte até o local da prestação dos serviços.</p>
            </section>
        </div>
    
 <h3>Pagamento, Local e Mora</h3>
 <hr>
    <div class="contrato">
       <section>
           <p><b>Cláusula 6º</b> - O valor total  será pago pelo Contratante à Contratada, em moeda corrente, em sua totalidade até o dia 16/05/2017.</p>
           <p><b>Cláusula 7º</b> - Os pagamentos serão efetuado no endereço do Contratante, com contra entrega do recibo de quitação.</p>
           <p><b>Cláusula 8º</b> - Se qualquer pagamento  for efetuado em data posterior ao vencimento estabelecido neste contrato, ficará o Contratante sujeito ao pagamento dos acréscimos de juros legais a razão de 1,00% (um por cento) ao mês, mais correção monetária com base no INPC, calculados sempre sobre o valor do débito em aberto, sem prejuizo da aplicação da cláusula penal.</p>
        </section>
         </div>
                
<h3>Penalidades</h3>
 <hr>
    <div class="contrato">
       <section>
           <p><b>Cláusula 9º</b> - Qualquer uma das partes contratantes que vier a descumprir alguma das obrigações ou prazos ora assumidos, ficará obrigada a pagar, em favor da parte contrária, multa de 1,00% (um por cento), calculada sobre o valor total do contrato,  e arcará com as custas judiciais, extrajudiciais e honorários advocatícios a que der causa, mais perdas e danos que superar o resultado da aplicação da penalidade convencionada, independentemente do cumprimento da obrigação principal, se ainda for prestável, ou da rescisão contratual.</p>
        </section>
         </div>

                <h3>Disposições finais</h3>
 <hr>
    <section class="contrato">
     
           <p><b>Cláusula 10º</b> - As partes contratantes elegem o Foro da Comarca da cidade de sp (SP), com renúncia a qualquer outro, por mais privilegiado que seja, para dirimir qualquer dúvida ou controversa relativa a este Contrato, correndo por conta do vencido, além do principal, honorários advocatícios, bem como todas as despesas judiciais ou extrajudiciais.</p>
           <p>Havendo assim ajustado, as partes assinam o presente contrato em 3 (três) vias  e as duas testemunhas abaixo identificadas que a tudo presenciaram, para que o mesmo produza seus efeitos.</p>
           
        </section>
         
        </section>
    </body>
</html>

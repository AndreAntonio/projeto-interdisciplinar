/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pi.controller.command;

import Afiliacao.Usuario;
import Afiliacao.UsuarioDAO;
import Avaliacao.AvaliacaoDAO;
import Contrato.Contrato;
import Contrato.ContratoDAO;
import Pagamento.PagamentoDAO;
import Servico.Servico;
import Servico.ServicoDAO;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import orcamento.Orcamento;
import orcamento.OrcamentoDAO;

/**
 *
 * @author Pedro
 */
public class ContratoCommand implements Command{
    UsuarioDAO usuarioDAO = lookupUsuarioDAOBean();
    ServicoDAO servicoDAO = lookupServicoDAOBean();
    PagamentoDAO pagamentoDAO = lookupPagamentoDAOBean();
    OrcamentoDAO orcamentoDAO = lookupOrcamentoDAOBean();
    ContratoDAO contratoDAO = lookupContratoDAOBean();
    AvaliacaoDAO avaliacaoDAO = lookupAvaliacaoDAOBean();
    
    
   
    
    
    private String responsePage = "Contrato.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String username;
    private String password;
    private long id  = 1; // trocar o id quando for fazer um novo contrato
                 Contrato c = new Contrato ();

    
    
    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    
    }

    @Override
    public void execute() {
         String action = request.getParameter("command").split("\\.")[1];
         switch(action){
             case "gerar":
                 // Criando dados fictícios

                 Servico s = new Servico();
                 Usuario u2 = new Usuario();
                
                 //Cliente        
                 /*
                        u2.setNome("dybala");
                        u2.setSenha("senha");
                        u2.setTipo("1");
                        u2.setTelefone("410293421");
                        u2.setEmail("juvevsreal");
                        if (u2.getTipo() == "1") {
                        u2.setCpf("123.456.789-12");
                        usuarioDAO.create(u2);
                        } else{
                            u2.setCnpj("123.456.789-12");
                        
                        usuarioDAO.create(u2);
                        }
                   */     
                           /*
                 //Servico
                 long id_user = 2;
                 long id_orca = 1;
                 Usuario u1 = new Usuario();
                 u1.setIdUsuario(id_user);
                 u1 = usuarioDAO.readById(u1.getIdUsuario());
                 Orcamento oaux = new Orcamento();
                 oaux = orcamentoDAO.readById(id_orca);
                 
                 
 */
                        s.setDatainicial(null);
                        s.setDatafinal(null);
                        
                        s.setDescricao("Este trabalho opa");
                        s.setStatus(Boolean.TRUE);
                        s.setValor(1200.00);
                        
                           servicoDAO.create(s);
                 
 /*
                        Orcamento o = new Orcamento();
                        o.setStatus("em andamento");
                        o.setValortot(100.00);
                        o.setTempotot("10 minutos");
                        orcamentoDAO.create(o);
   */
         // o1.setServico(s);
                // s.setOrcamento(o1);
                 
                                     
                 
              
    responsePage = "index.jsp";
                 break;
                 
                 
             case "login":
                 
                username = request.getParameter("nome");
                password = request.getParameter("senha");
               //Se for fazer um novo contrato verificar a variavel id
                Usuario tempUsuario = usuarioDAO.readById(id);
                List<Servico> servicos = servicoDAO.read();
                 for (Servico servico : servicos) {
                    if( tempUsuario.equals(servico.getFkUsuario())){
                tempUsuario.setServicoList(servicos);                        
                    }
                 }
                        
                List<Contrato> contratos = contratoDAO.read();
                 for (Contrato contrato : contratos) {
                    if( tempUsuario.equals(contrato.getIdContratoUsuario())){
                tempUsuario.setContratoList(contratos);
                
                    }
                 }
                
                 request.getSession().setAttribute("user", tempUsuario);
                request.getSession().setAttribute("servicos", servicos);
                request.getSession().setAttribute("contratos", contratos);
                
            responsePage = "home.jsp";
                 
                 break;
             case "contrato":
                long aux = Long.parseLong(request.getParameter("id_usuario")); 
                 tempUsuario = usuarioDAO.readById(aux);
                 long aux1 = Long.parseLong(request.getParameter("id_servico"));
                  Servico tempServico = servicoDAO.readById(aux);
                  c.setTermodocontrato("balblalbalbalbalblalba");
                  c.setIdContratoUsuario(tempUsuario);
                  contratoDAO.create(c);
                Orcamento orcamentoAux = orcamentoDAO.readById(id);  
                 request.getSession().setAttribute("orcamento", orcamentoAux);
                
            responsePage = "orcamento.jsp";
                      
                 break;
                 
             case "orcamento":
                 long aux2 = Long.parseLong(request.getParameter("orc"));
                 Orcamento orcamentoAux1 = orcamentoDAO.readById(aux2);
                c =  contratoDAO.readById(4);
                c.setIdContratoOrcamento(orcamentoAux1);
                contratoDAO.update(c);
                
                 responsePage = "home.jsp";
                 break;
             case "visualizar":
                 aux = Long.parseLong(request.getParameter("id_usuario")); 
                 Usuario opa;
                opa = usuarioDAO.readById(aux);
                List<Contrato> contratos1 = contratoDAO.read();
                 for (Contrato contrato : contratos1) {
                    if( opa.equals(contrato.getIdContratoUsuario())){
                        Contrato contra = contrato;
                        request.getSession().setAttribute("contrato", contra);
                        
                        
                   
                    }
                 }
                 responsePage = "Vizualizacao.jsp";
                 
                 break;
             case "voltar":
                 responsePage = "home.jsp";
                         break;
             case "excluir":
                 aux = Long.parseLong(request.getParameter("id_usuario"));
                opa = usuarioDAO.readById(aux);
                List<Contrato> contratos2 = contratoDAO.read();
                 for (Contrato contrato : contratos2) {
                    if( opa.equals(contrato.getIdContratoUsuario())){
                        contratoDAO.delete(contrato);
                        
                   
                    }
                 }
                 responsePage = "index.jsp";
                 break;
         }
         
    }

    @Override
    public String getResponsePage() {
       return responsePage;
     }

    private AvaliacaoDAO lookupAvaliacaoDAOBean() {
        try {
            Context c = new InitialContext();
            return (AvaliacaoDAO) c.lookup("java:global/Interdisciplinar/Interdisciplinar-ejb/AvaliacaoDAO!com.br.pi.model.DAO.AvaliacaoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ContratoDAO lookupContratoDAOBean() {
        try {
            Context c = new InitialContext();
            return (ContratoDAO) c.lookup("java:global/Interdisciplinar/Interdisciplinar-ejb/ContratoDAO!com.br.pi.model.DAO.ContratoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private OrcamentoDAO lookupOrcamentoDAOBean() {
        try {
            Context c = new InitialContext();
            return (OrcamentoDAO) c.lookup("java:global/Interdisciplinar/Interdisciplinar-ejb/OrcamentoDAO!com.br.pi.model.DAO.OrcamentoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private PagamentoDAO lookupPagamentoDAOBean() {
        try {
            Context c = new InitialContext();
            return (PagamentoDAO) c.lookup("java:global/Interdisciplinar/Interdisciplinar-ejb/PagamentoDAO!com.br.pi.model.DAO.PagamentoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ServicoDAO lookupServicoDAOBean() {
        try {
            Context c = new InitialContext();
            return (ServicoDAO) c.lookup("java:global/Interdisciplinar/Interdisciplinar-ejb/ServicoDAO!com.br.pi.model.DAO.ServicoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UsuarioDAO lookupUsuarioDAOBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioDAO) c.lookup("java:global/Interdisciplinar/Interdisciplinar-ejb/UsuarioDAO!com.br.pi.model.DAO.UsuarioDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

   

}

package com.br.pi.controller.command;
import Avaliacao.AvaliacaoDAO;
import Afiliacao.Usuario;
import Servico.Servico;
import Contrato.Contrato;
import Contrato.ContratoDAO;
import orcamento.OrcamentoDAO;
import Pagamento.PagamentoDAO;
import Servico.ServicoDAO;
import Afiliacao.UsuarioDAO;
import Avaliacao.Avaliacao;

import orcamento.Orcamento;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private Long id;

    
    
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
                 Orcamento o = new Orcamento();
                 Servico s = new Servico();
                 Contrato c = new Contrato ();
                 Usuario u2 = new Usuario();
                
                 //Cliente        
                        u2.setNome("nome");
                        u2.setSenha("sexo");
                        u2.setTipo("1");
                        u2.setTelefone("412410421");
                        
                        if (u2.getTipo() == "1") {
                        u2.setCpf("123.456.789-12");
                        usuarioDAO.create(u2);
                        } else{
                            u2.setCnpj("123.456.789-12");
                        
                        usuarioDAO.create(u2);
                        }
/*                        
                 //Servico
                 long id_user = 1;
                 Usuario u1 = new Usuario();
                 u1.setIdUsuario(id_user);
                 u1 = usuarioDAO.readById(u1.getIdUsuario());
                        s.setDatainicial(null);
                        s.setDatafinal(null);
                        s.setFkUsuario(u1);
                        s.setDescricao("blablabla");
                        s.setStatus(Boolean.TRUE);
                        s.setValor(1000.00);
                 long id_avaliacao = 1;
                 Avaliacao av = new Avaliacao();
                 av.setIdAvaliacao(id_avaliacao);
                 av = avaliacaoDAO.readById(av.getIdAvaliacao());
                            
                        
                        long id_orcamento = 1;
                 Orcamento o1 = new Orcamento();
                 o1.setIdOrcamento(id_orcamento);
                 o1 = orcamentoDAO.readById(id_orcamento);
                 o1.setServico(s);
                 s.setOrcamento(o1);
                 
                       
                        
                 //Orcamento      
                 o.setValortot(1000.12);
                 o.setStatus("em andamento");
                           servicoDAO.create(s);
               orcamentoDAO.create(o);
                 
                 
              
*/  
    responsePage = "index.jsp";
break;
                 
                 
             case "login":
                 
                username = request.getParameter("nome");
                password = request.getParameter("senha");
                id = Long.parseLong(request.getParameter("id_usuario"));                
                Usuario tempUsuario = usuarioDAO.readById(id);
                 request.getSession().setAttribute("user", tempUsuario);
                 
                 break;
             case "contrato":
                id = Long.parseLong(request.getParameter("id_usuario"));                
                 tempUsuario = usuarioDAO.readById(id);
                  // Contrato
                 
                 
                
                 
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
            return (AvaliacaoDAO) c.lookup("java:global/ProjInterdisc/ProjInterdisc-ejb/AvaliacaoDAO!Avaliacao.AvaliacaoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ContratoDAO lookupContratoDAOBean() {
        try {
            Context c = new InitialContext();
            return (ContratoDAO) c.lookup("java:global/ProjInterdisc/ProjInterdisc-ejb/ContratoDAO!Contrato.ContratoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private OrcamentoDAO lookupOrcamentoDAOBean() {
        try {
            Context c = new InitialContext();
            return (OrcamentoDAO) c.lookup("java:global/ProjInterdisc/ProjInterdisc-ejb/OrcamentoDAO!orcamento.OrcamentoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private PagamentoDAO lookupPagamentoDAOBean() {
        try {
            Context c = new InitialContext();
            return (PagamentoDAO) c.lookup("java:global/ProjInterdisc/ProjInterdisc-ejb/PagamentoDAO!Pagamento.PagamentoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ServicoDAO lookupServicoDAOBean() {
        try {
            Context c = new InitialContext();
            return (ServicoDAO) c.lookup("java:global/ProjInterdisc/ProjInterdisc-ejb/ServicoDAO!Servico.ServicoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UsuarioDAO lookupUsuarioDAOBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioDAO) c.lookup("java:global/ProjInterdisc/ProjInterdisc-ejb/UsuarioDAO!Afiliacao.UsuarioDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }




}

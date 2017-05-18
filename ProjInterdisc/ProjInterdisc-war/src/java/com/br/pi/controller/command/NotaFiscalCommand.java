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
import Nota_Fiscal.NotaFiscalDAO;
import Nota_Fiscal.Notafiscal;
import Pagamento.Pagamento;
import Pagamento.PagamentoDAO;
import Servico.ServicoDAO;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import orcamento.Item;
import orcamento.ItemDAO;
import orcamento.Orcamento;
import orcamento.OrcamentoDAO;

/**
 *
 * @author 157
 */
public class NotaFiscalCommand implements Command{

    ItemDAO itemDAO = lookupItemDAOBean();

    UsuarioDAO usuarioDAO = lookupUsuarioDAOBean();

   

    ServicoDAO servicoDAO = lookupServicoDAOBean();

    PagamentoDAO pagamentoDAO = lookupPagamentoDAOBean();

    OrcamentoDAO orcamentoDAO = lookupOrcamentoDAOBean();

    ContratoDAO contratoDAO = lookupContratoDAOBean();

    AvaliacaoDAO avaliacaoDAO = lookupAvaliacaoDAOBean();

    NotaFiscalDAO notaFiscalDAO = lookupNotaFiscalDAOBean();
    
    
    private String responsePage = "index.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    private long id  = 1; 
                 

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    
    }
    @Override
    public void execute() {
        Contrato contrato = new Contrato();
        Orcamento orcamento = new Orcamento();
        Item item = new Item();
        Pagamento pagamento = new Pagamento();
        Usuario fornecedor = new Usuario();
        
                fornecedor.setCpf("1");
                fornecedor.setIdUsuario((long)1);
                fornecedor.setNome("FonecedorX");
                fornecedor.setTipo("Fornecedor");
                fornecedor.setSenha("123");
                
                
                
                Usuario cliente = new Usuario();
                cliente.setCpf("1234");
                cliente.setIdUsuario((long)2);
                cliente.setNome("ClienteX");
                cliente.setTipo("Cliente");
                cliente.setSenha("123");
        
                usuarioDAO.create(cliente);
                usuarioDAO.create(fornecedor);
                
        item.setDescricao("Mao de Obra");
        item.setQuantidade(1);
        item.setValor(320.50);
        
        itemDAO.create(item);
        
               
        orcamento.setStatus("Terminado");
        orcamento.setValortot(320.50);
        orcamento.setTempoexecucao("15 dias");
        orcamento.addItem(item);
        
        orcamentoDAO.create(orcamento);
        
        pagamento.setIdPagamento((long)1);
        pagamento.setPreco(320.50);
        pagamento.setTipo(1);
        pagamento.setFkCliente(cliente);
        
        pagamentoDAO.create(pagamento);
        
        
        contrato.setIdContratoCliente(cliente);
        contrato.setOrcamento(orcamento);
        contrato.setTermodocontrato("Termo de Contrato");
        contrato.addPagamento(pagamento);
        
        
        contratoDAO.create(contrato);
        
        Notafiscal notafiscal = new Notafiscal();
        
        notafiscal.setCustoTotal(320.50);
        notafiscal.setDataEmissao(new Date());
        notafiscal.setFkContrato(contrato);
        
        notaFiscalDAO.create(notafiscal);
        request.getSession().setAttribute("Nota_Fiscal", notafiscal);
        responsePage = "index.jsp";
    }

    @Override
    public String getResponsePage() {
        return responsePage;
    }

    private NotaFiscalDAO lookupNotaFiscalDAOBean() {
        try {
            Context c = new InitialContext();
            return (NotaFiscalDAO) c.lookup("java:global/ProjInterdisc/ProjInterdisc-ejb/NotaFiscalDAO!Nota_Fiscal.NotaFiscalDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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

    private ItemDAO lookupItemDAOBean() {
        try {
            Context c = new InitialContext();
            return (ItemDAO) c.lookup("java:global/ProjInterdisc/ProjInterdisc-ejb/ItemDAO!orcamento.ItemDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


   
    
}

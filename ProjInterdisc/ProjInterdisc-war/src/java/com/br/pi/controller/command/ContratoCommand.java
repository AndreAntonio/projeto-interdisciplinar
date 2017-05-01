/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pi.controller.command;

import Contrato.Contrato;
import Contrato.ContratoDAO;
import Entidades.Cliente;
import Entidades.Fornecedor;
import Entidades.MaoDeObra;
import Entidades.PessoaFisica;
import Entidades.PessoaJuridica;
import Entidades.Servico;
import Entidades.Usuario;
import java.util.Date;
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
 * @author Mariana
 */
public class ContratoCommand implements Command{

    OrcamentoDAO orcamentoDAO = lookupOrcamentoDAOBean();

    ContratoDAO contratoDAO = lookupContratoDAOBean();
    
    
    private String responsePage = "Contrato.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String nome;
    private String sexo;
    private String estado_civil;
    private String nacionalidade;
    private String profissao;
    private String endereco;
    private String cpf;
    private String cnpj;
    private Date dataIni;
    private Date dataFin;
    private String descricao;
    private String tempoExecucao;
    private Double valor;
    
    
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
                 Contrato c = new Contrato ();
                 
                 //Cliente        
                 Usuario u1 = (Usuario) request.getSession().getAttribute("user");
                        Cliente cli = u1.getCliente();
                        nome = u1.getNome();
                        sexo = "";
                        estado_civil = "";
                        nacionalidade = "";
                        profissao = "";
                        endereco = "";                       
                        PessoaFisica pf = cli.getPessoaFisica();
                        cpf=pf.getCpf();
                 
                 //Fornecedor
                 Usuario u2 = (Usuario) request.getSession().getAttribute("fornecedor");       
                        Fornecedor f = u2.getFornecedor();
                         nome = u2.getNome();
                         sexo = "";
                         estado_civil = "";
                         nacionalidade = "";
                         profissao = "";
                         endereco = "";  
                       
                       PessoaJuridica pj = cli.getPessoaJuridica();
                       cnpj=pj.getCnpj();
                 
                 //Servico
                   Servico s = (Servico) request.getSession().getAttribute("servico");
                           dataIni = s.getDatainicial();
                           dataFin = s.getDatafinal();
                  
                 //Mao De Obra
                   MaoDeObra mdo = (MaoDeObra) request.getSession().getAttribute("servico"); 
                            descricao = mdo.getDescricao();
                            tempoExecucao = mdo.getTempoexecucao();
                            
                 //Orcamento      
                    Orcamento o = (Orcamento)request.getSession().getAttribute("orcamento"); 
                            valor = o.getValortot();
                            
                            
                 //Settar Contrato
                           c.setOrcamento(o);
                 break;
         }
    }

    @Override
    public String getResponsePage() {
        return responsePage;
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
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pi.controller.command;

import Afiliacao.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import orcamento.Item;
import orcamento.Orcamento;
import orcamento.OrcamentoDAO;

/**
 *
 * @author lgd25
 */
public class OrcamentoCommand implements Command {

    OrcamentoDAO orcamentoDAO = lookupOrcamentoDAOBean();

   

    private String responsePage = "orcamento.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;
    

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("command").split("\\.")[1];
        switch(action){
            case "start":
                
                Usuario fornecedor = new Usuario();
                fornecedor.setCpf("1");
                fornecedor.setIdUsuario((long)1);
                fornecedor.setNome("FonecedorX");
                fornecedor.setTipo("Fornecedor");
                fornecedor.setSenha("123");
                
                Usuario cliente = new Usuario();
                cliente.setCpf("1234");
                cliente.setIdUsuario((long)1);
                cliente.setNome("ClienteX");
                cliente.setTipo("Cliente");
                cliente.setSenha("123");
                
                
                
                request.getSession().setAttribute("user", fornecedor);
                request.getSession().setAttribute("clienteSelect", cliente);
                request.getSession().setAttribute("servicoSolicitado", "Reparo de pia");
                
                
                
                        
                    
                
                break;
                
                
            case "addTempo": 
                
               
                
                String tempoExec = request.getParameter("tempoExec");
                
                break;
            
            case "addItem":
                    String desc_item = request.getParameter("desc_item");
                    double valor = Double.parseDouble(request.getParameter("valor"));
                    int quant = Integer.parseInt(request.getParameter("quant"));
                    Item i = new Item();
                    i.setDescricao(desc_item);
                    i.setQuantidade(quant);
                    i.setValor(valor);
                    Orcamento o1 = (Orcamento)request.getSession().getAttribute("orcamento");
                    o1.addItem(i);
                    o1.calculaValorTot();
                    request.getSession().setAttribute("orcamento", o1);
                    responsePage = "orcamentoItens.jsp";
                    
                
                break;
                
                
            case "startOrcamento":
                
                Orcamento o = new Orcamento();
                request.getSession().setAttribute("orcamento", o);
                responsePage ="orcamentoItens.jsp";
                
                
                break;
                
            case "removeItem":
                int quantidadeToRemove = Integer.parseInt(request.getParameter("itemToRemoveQuant"));
                String descToRemove = request.getParameter("itemToRemoveDesc");
                double valorToRemove = Double.parseDouble(request.getParameter("itemToRemoveValor"));
                Item i1 = new Item();
                i1.setDescricao(descToRemove);
                i1.setQuantidade(quantidadeToRemove);
                i1.setValor(valorToRemove);                
                Orcamento o2 = (Orcamento)request.getSession().getAttribute("orcamento");
                o2.removeItem(i1);
                o2.calculaValorTot();
                request.getSession().setAttribute("orcamento", o2);
                responsePage ="orcamentoItens.jsp";
                
                
                break;
                
                
            case "confirmaItem":
                responsePage = "orcamentoFinish.jsp";
                
                break;
                
           
            
            case "setTempoExec":
                
                break;
                
                
        }
    }

    @Override
    public String getResponsePage() {
        return this.responsePage;
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

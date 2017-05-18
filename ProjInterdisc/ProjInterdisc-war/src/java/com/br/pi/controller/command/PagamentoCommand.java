/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pi.controller.command;

import Afiliacao.Usuario;
import Afiliacao.UsuarioDAO;
import Contrato.Contrato;
import Contrato.ContratoDAO;
import Pagamento.Pagamento;
import Pagamento.PagamentoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mariana
 */
public class PagamentoCommand implements Command{
    ContratoDAO contratoDAO = lookupContratoDAOBean();
    UsuarioDAO usuarioDAO = lookupUsuarioDAOBean();
    PagamentoDAO pagamentoDAO = lookupPagamentoDAOBean();

    
    private String responsePage = "pagamento.jsp";
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
             case "pagar":
                         int tipo = Integer.parseInt(request.getParameter("tipo"));
                        int id = Integer.parseInt(request.getParameter("id_usuario"));
                        Usuario tempUsuario = usuarioDAO.readById(id);
                                       Pagamento aux = new Pagamento();
                                    List<Contrato> contratos = contratoDAO.read();
                                    for (Contrato contrato : contratos) {
                                     if( tempUsuario.getIdUsuario().equals(contrato.getIdContratoCliente().getIdUsuario())){
                                      double precoaux = contrato.getOrcamento().getValortot();
                                      aux.setPreco(precoaux);
                                      aux.setFkContrato(contrato);
                                       aux.setTipo(1);
                                       aux.setFkCliente(tempUsuario);
                    }
    
                                        
                 }
                                       
                                       pagamentoDAO.create(aux);
                                       request.getSession().setAttribute("pagamento", aux);
                                    responsePage = "pagamento.jsp";
             break;
             case "pago":
               long id_user =  Long.parseLong(request.getParameter("id_usuario"));
               long id_pag =  Long.parseLong(request.getParameter("id_pagamento"));
               Pagamento pgto = new Pagamento();
             pgto =  pagamentoDAO.readById(id_pag);
               
                    request.getSession().setAttribute("valor_pago", pgto);
                Contrato caux = new Contrato();
                caux = contratoDAO.readById(pgto.getFkContrato().getIdContrato());
                 pagamentoDAO.delete(pgto);
                contratoDAO.delete(caux);
                                    responsePage = "pgto.jsp";
                 break;
         }
         
    }

     @Override
     public String getResponsePage() {
         return this.responsePage;
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

    private UsuarioDAO lookupUsuarioDAOBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioDAO) c.lookup("java:global/ProjInterdisc/ProjInterdisc-ejb/UsuarioDAO!Afiliacao.UsuarioDAO");
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
    
}


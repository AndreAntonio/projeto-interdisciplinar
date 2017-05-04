/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pi.controller.command;

import Contrato.ContratoDAO;
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
             
         }
         
    }

     @Override
     public String getResponsePage() {
         return this.responsePage;
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


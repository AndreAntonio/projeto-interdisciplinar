/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pi.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lgd25
 */
public class OrcamentoCommand implements Command {

    private String responsePage = "index.jsp";
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
                
                break;
            
            case "addItem":
                
                
                break;
            
        }
    }

    @Override
    public String getResponsePage() {
        return this.responsePage;
    }

}

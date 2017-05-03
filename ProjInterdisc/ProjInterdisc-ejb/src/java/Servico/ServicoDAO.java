/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import orcamento.GenericDAO;

/**
 *
 * @author Pedro
 */
@Stateful
@LocalBean
public class ServicoDAO implements GenericDAO<Servico>{
    
    @PersistenceContext(unitName = "ProjInterdisc-ejbPU", type = PersistenceContextType.EXTENDED)
    EntityManager em;

    @Override
    public void create(Servico e) {
        em.persist(e);
    }

    @Override
    public List<Servico> read() {
        Query query = em.createNamedQuery("Servico.findAll",Servico.class);
        return (List<Servico>) query.getResultList();
    }

    @Override
    public Servico readById(long id) {
        return em.find(Servico.class, id);
    }

    @Override
    public void update(Servico e) {
        em.merge(e);
    }

    @Override
    public void delete(Servico e) {
        em.merge(e);
        em.remove(e);
    }
    
}


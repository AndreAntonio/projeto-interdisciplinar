/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Avaliacao;

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
public class AvaliacaoDAO implements GenericDAO<Avaliacao>{
    
    @PersistenceContext(unitName = "ProjInterdisc-ejbPU", type = PersistenceContextType.EXTENDED)
    EntityManager em;

    @Override
    public void create(Avaliacao e) {
        em.persist(e);
    }

    @Override
    public List<Avaliacao> read() {
        Query query = em.createNamedQuery("Avaliacao.findAll",Avaliacao.class);
        return (List<Avaliacao>) query.getResultList();
    }

    @Override
    public Avaliacao readById(long id) {
        return em.find(Avaliacao.class, id);
    }

    @Override
    public void update(Avaliacao e) {
        em.merge(e);
    }

    @Override
    public void delete(Avaliacao e) {
        em.merge(e);
        em.remove(e);
    }
    
}


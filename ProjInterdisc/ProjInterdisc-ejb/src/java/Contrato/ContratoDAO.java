/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato;

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
 * @author 31546463
 */
@Stateful
@LocalBean
public class ContratoDAO implements GenericDAO<Contrato>{
    
    @PersistenceContext(unitName = "ProjInterdisc-ejbPU", type = PersistenceContextType.EXTENDED)
    EntityManager em;

    @Override
    public void create(Contrato e) {
        em.persist(e);
    }

    @Override
    public List<Contrato> read() {
        Query query = em.createNamedQuery("Contrato.findAll",Contrato.class);
        return (List<Contrato>) query.getResultList();
    }

    @Override
    public Contrato readById(long id) {
        return em.find(Contrato.class, id);
    }

    @Override
    public void update(Contrato e) {
        em.merge(e);
    }

    @Override
    public void delete(Contrato e) {
        em.merge(e);
        em.remove(e);
    }
    
}

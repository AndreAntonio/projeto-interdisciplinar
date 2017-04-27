/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcamento;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author 31548751
 */

@Stateful
@LocalBean
public class OrcamentoDAO implements GenericDAO<Orcamento> {

    @PersistenceContext(unitName="ModuloOrcamento-ejbPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    
    @Override
    public void create(Orcamento e) {
        em.persist(e);
    }

    @Override
    public List<Orcamento> read() {
        Query query = em.createNamedQuery("Orcamento.findAll",Orcamento.class);
        return (List<Orcamento>)query.getResultList();
    }

    @Override
    public Orcamento readById(long id) {
        return em.find(Orcamento.class, id);
    }

    @Override
    public void update(Orcamento e) {
        em.merge(e);
    }

    @Override
    public void delete(Orcamento e) {
        em.merge(e);
        em.remove(e);
    }
    
}


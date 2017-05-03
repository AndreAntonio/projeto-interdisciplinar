/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pagamento;


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
public class PagamentoDAO implements GenericDAO<Pagamento>{
    
    @PersistenceContext(unitName = "ProjInterdisc-ejbPU", type = PersistenceContextType.EXTENDED)
    EntityManager em;

    @Override
    public void create(Pagamento e) {
        em.persist(e);
    }

    @Override
    public List<Pagamento> read() {
        Query query = em.createNamedQuery("Pagamento.findAll",Pagamento.class);
        return (List<Pagamento>) query.getResultList();
    }

    @Override
    public Pagamento readById(long id) {
        return em.find(Pagamento.class, id);
    }

    @Override
    public void update(Pagamento e) {
        em.merge(e);
    }

    @Override
    public void delete(Pagamento e) {
        em.merge(e);
        em.remove(e);
    }
    
}


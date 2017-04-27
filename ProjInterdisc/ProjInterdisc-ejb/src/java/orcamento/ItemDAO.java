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
 * @author lgd25
 */
@Stateful
@LocalBean

public class ItemDAO implements GenericDAO<Item> {

    @PersistenceContext(unitName = "ModuloOrcamento-ejbPU", type = PersistenceContextType.EXTENDED)
    EntityManager em;
    
    @Override
    public void create(Item e) {
        em.persist(e);
    }

    @Override
    public List<Item> read() {
        Query query = em.createNamedQuery("Item.findAll",Item.class);
        return (List<Item>) query.getResultList();
    }

    @Override
    public Item readById(long id) {
        return em.find(Item.class, id);
    }

    @Override
    public void update(Item e) {
        em.merge(e);
    }

    @Override
    public void delete(Item e) {
        em.merge(e);
        em.remove(e);
    }
    
}


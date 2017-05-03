/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Afiliacao;

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
 * 
 * @author Pedro
 */
@Stateful
@LocalBean
public class UsuarioDAO implements GenericDAO<Usuario>{
    
    @PersistenceContext(unitName = "ProjInterdisc-ejbPU", type = PersistenceContextType.EXTENDED)
    EntityManager em;

    @Override
    public void create(Usuario e) {
        em.persist(e);
    }

    @Override
    public List<Usuario> read() {
        Query query = em.createNamedQuery("Usuario.findAll",Usuario.class);
        return (List<Usuario>) query.getResultList();
    }

    @Override
    public Usuario readById(long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public void update(Usuario e) {
        em.merge(e);
    }

    @Override
    public void delete(Usuario e) {
        em.merge(e);
        em.remove(e);
    }
    
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nota_Fiscal;

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
 * @author 157
 */
@Stateful
@LocalBean
public class NotaFiscalDAO implements GenericDAO<Notafiscal>{

    @PersistenceContext(unitName = "ProjInterdisc-ejbPU", type = PersistenceContextType.EXTENDED)
    EntityManager em;

    
    
    @Override
    public void create(Notafiscal e) {
            em.persist(e);
        }

    @Override
    public List<Notafiscal> read() {
         Query query = em.createNamedQuery("Notafiscal.findAll",Notafiscal.class);
        return (List<Notafiscal>) query.getResultList();
    }

    @Override
    public Notafiscal readById(long id) {
        return em.find(Notafiscal.class, id);
    }
    @Override
    public void update(Notafiscal e) {
        em.merge(e);
    }

    @Override
    public void delete(Notafiscal e) {
         
        em.remove(em.merge(e));
    }
    
}

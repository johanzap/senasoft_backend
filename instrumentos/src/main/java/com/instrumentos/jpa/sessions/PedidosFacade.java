/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instrumentos.jpa.sessions;

import com.instrumentos.jpa.entities.Pedidos;
import com.instrumentos.jpa.entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author SennovaAgroPC03
 */
@Stateless
public class PedidosFacade extends AbstractFacade<Pedidos> {

    @PersistenceContext(unitName = "com.mycompany_instrumentos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidosFacade() {
        super(Pedidos.class);
    }
    
    public List<Pedidos> consultarPedidos(Integer idUsuario) {
        Query query = em.createQuery("SELECT p FROM Pedidos p WHERE p.idUsuario = :usuario", Pedidos.class);
        query.setParameter("usuario", new Usuarios(idUsuario));
        return (List<Pedidos>) query.getResultList();
    }
    
}

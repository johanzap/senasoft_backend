/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instrumentos.jpa.sessions;

import com.instrumentos.jpa.entities.ProductosHasPedidos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SennovaAgroPC03
 */
@Stateless
public class ProductosHasPedidosFacade extends AbstractFacade<ProductosHasPedidos> {

    @PersistenceContext(unitName = "com.mycompany_instrumentos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosHasPedidosFacade() {
        super(ProductosHasPedidos.class);
    }
    
}

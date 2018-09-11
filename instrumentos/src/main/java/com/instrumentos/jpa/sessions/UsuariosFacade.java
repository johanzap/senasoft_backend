/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instrumentos.jpa.sessions;

import com.instrumentos.jpa.entities.Marcas;
import com.instrumentos.jpa.entities.Roles;
import com.instrumentos.jpa.entities.TipoProducto;
import com.instrumentos.jpa.entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

/**
 *
 * @author SennovaAgroPC03
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "com.mycompany_instrumentos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public String cifrarPassword(String password) {
        Query query = em.createNativeQuery("SELECT sha2(?1, 256)");
        query.setParameter(1, password);
        return (String) query.getSingleResult();
    }
    
    public void setRolesAndPreferences(Usuarios usuario) {
        for (int i = 0; i < usuario.getRolesList().size(); i++) {
            Query query = em.createNativeQuery("INSERT INTO usuarios_has_roles SET id_usuario = ?1, id_roles = ?2");
            query.setParameter(1, usuario.getId());
            query.setParameter(2, usuario.getRolesList().get(i).getId());
            query.executeUpdate();
        }
        for (int i = 0; i < usuario.getMarcasList().size(); i++) {
            Query query = em.createNativeQuery("INSERT INTO preferencia_marca SET Usuarios_id = ?1, marcas_id = ?2");
            query.setParameter(1, usuario.getId());
            query.setParameter(2, usuario.getMarcasList().get(i).getId());
            query.executeUpdate();
        }
        for (int i = 0; i < usuario.getTipoProductoList().size(); i++) {
            Query query = em.createNativeQuery("INSERT INTO preferencia_tipo SET Usuarios_id = ?1, tipo_producto_id = ?2");
            query.setParameter(1, usuario.getId());
            query.setParameter(2, usuario.getTipoProductoList().get(i).getId());
            query.executeUpdate();
        }
    }
    
    public Usuarios findByEmail(String email) {
        Query query = em.createNamedQuery("Usuarios.findByEmail");
        query.setParameter("email", email);
        try {
            return (Usuarios) query.getSingleResult();
        } catch(NonUniqueResultException ex) {
            throw ex;
        } catch(NoResultException e) {
            return null;
        }
    }
     
}

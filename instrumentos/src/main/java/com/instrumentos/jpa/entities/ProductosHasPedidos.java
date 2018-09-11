/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instrumentos.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SennovaAgroPC03
 */
@Entity
@Table(name = "productos_has_pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosHasPedidos.findAll", query = "SELECT p FROM ProductosHasPedidos p")
    , @NamedQuery(name = "ProductosHasPedidos.findByIdProductos", query = "SELECT p FROM ProductosHasPedidos p WHERE p.productosHasPedidosPK.idProductos = :idProductos")
    , @NamedQuery(name = "ProductosHasPedidos.findByIdPedidos", query = "SELECT p FROM ProductosHasPedidos p WHERE p.productosHasPedidosPK.idPedidos = :idPedidos")
    , @NamedQuery(name = "ProductosHasPedidos.findByCantidad", query = "SELECT p FROM ProductosHasPedidos p WHERE p.cantidad = :cantidad")})
public class ProductosHasPedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosHasPedidosPK productosHasPedidosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "id_pedidos", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedidos pedidos;
    @JoinColumn(name = "id_productos", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public ProductosHasPedidos() {
    }

    public ProductosHasPedidos(ProductosHasPedidosPK productosHasPedidosPK) {
        this.productosHasPedidosPK = productosHasPedidosPK;
    }

    public ProductosHasPedidos(ProductosHasPedidosPK productosHasPedidosPK, int cantidad) {
        this.productosHasPedidosPK = productosHasPedidosPK;
        this.cantidad = cantidad;
    }

    public ProductosHasPedidos(int idProductos, int idPedidos) {
        this.productosHasPedidosPK = new ProductosHasPedidosPK(idProductos, idPedidos);
    }

    public ProductosHasPedidosPK getProductosHasPedidosPK() {
        return productosHasPedidosPK;
    }

    public void setProductosHasPedidosPK(ProductosHasPedidosPK productosHasPedidosPK) {
        this.productosHasPedidosPK = productosHasPedidosPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosHasPedidosPK != null ? productosHasPedidosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosHasPedidos)) {
            return false;
        }
        ProductosHasPedidos other = (ProductosHasPedidos) object;
        if ((this.productosHasPedidosPK == null && other.productosHasPedidosPK != null) || (this.productosHasPedidosPK != null && !this.productosHasPedidosPK.equals(other.productosHasPedidosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instrumentos.jpa.entities.ProductosHasPedidos[ productosHasPedidosPK=" + productosHasPedidosPK + " ]";
    }
    
}

package com.platzi.market.persistencia.entity;

import javax.persistence.*;

@Entity
//como es diferente el nombre de la tabla Producto en la bd se pone @Table y se pone como realmente está,
//en este caso, productos
@Table(name="productos")
public class Producto {

    //como es diferente el nombre del atributo idProducto del que esta en la bd, entonces hay que poner
    //lo de @Column para definir que realmente es id_producto.
    //Como es la clave primaria, entonces se pone @Id
    //Como se debe generar automaticamente, entonces se pone lo de GeneratedValue
    //Se cambia el id_producto a IdProducto, porque es una mala práctica usar _
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer idProducto;

    //como no tiene _, entonces se deja tal cual
    private String nombre;

    @Column(name="id_categoria")
    private Integer idCategoria;

    @Column(name="codigo_barras")
    private String codigoBarras;

    @Column(name="precio_venta")
    private double precioVenta;

    @Column(name="cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name="id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

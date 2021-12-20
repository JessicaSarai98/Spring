package com.platzi.market.persistencia.entity;

import javax.persistence.*;
import java.io.Serializable;

//Como la entidad Compras-productos tiene dos llaves primarias (llaves compuestas) entonces se crea
//esta clase con el mismo nombre pero al final con PK y solo se pondrán las dos claves primarias

@Embeddable
public class ComprasProductoPK implements Serializable{

    @Column(name="id_compra")
    private Integer idCompra;

    @Column(name="id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}

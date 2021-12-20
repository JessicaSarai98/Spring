package com.platzi.market.persistencia.entity;

import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {

    private String id;
    private String nombre;
    private String apellidos;
    private Double celular;
    private String direccion;

    @Column(name="correo_electronico")
    private String correoElectronico;
}

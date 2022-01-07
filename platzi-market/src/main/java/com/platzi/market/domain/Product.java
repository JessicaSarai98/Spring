package com.platzi.market.domain;

public class Product {
    /*
    * Se iran agregando los atributos que tenga la entidad Producto*/
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;

    //Agregando la relacion - en término de domain
    private Category category;

    //No se agregó el codigo de barras
}

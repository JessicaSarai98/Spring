package com.platzi.market.persistencia;

import com.platzi.market.persistencia.crud.ProductoCrudRepository;
import com.platzi.market.persistencia.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Devuelve una lista de todos los productos
    public List<Producto> getAll(){  //hay que castear
        return (List<Producto>) productoCrudRepository.findAll();
    }
}

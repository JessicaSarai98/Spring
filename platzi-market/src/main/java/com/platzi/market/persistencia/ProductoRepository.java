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

    public List<Producto> getByCategoria(int idCategoria){
        /*Se nombra como está en el CrudRepository - devuelve una lista de productos con la categoria especifica
        ordenador en orden alfabetic*/
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria); 
        
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true); 
    }
}

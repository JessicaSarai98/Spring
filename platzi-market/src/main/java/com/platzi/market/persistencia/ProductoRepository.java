package com.platzi.market.persistencia;

import com.platzi.market.persistencia.crud.ProductoCrudRepository;
import com.platzi.market.persistencia.entity.Producto;

import java.util.List;

/**Como es una clase que interactua con la BD entonces se le asigna @Repository 
@Component es una generalización pero queda mejor Repository*/
@Repository
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
    //obtener producto dado su Id
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto); 
    }

    //guardar producto
   public Producto save(Producto producto){
       return productoCrudRepository.save(producto); 
   } 
    //Eliminando con llave primaria al producto 
   public void delete(int idProducto){
       //si se pusiera solo .delete(Entidad) eliminaría la entidad completa. 
       productoCrudRepository.deleteById(idProducto); 
   }
}

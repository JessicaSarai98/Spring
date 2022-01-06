package com.platzi.market.persistencia.crud;

import com.platzi.market.persistencia.entity.Producto;
import org.springframework.data.repository.CrudRepository;

//Aqui se crean los query methods
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    /*escribiendo un nuevo metodo - recuperar toda la lista de prod que pertenezcan a una categoria en especifico
    nomenclatura: findBy_AtributoABuscar, y se manda el atributo como esté en la clase.*/
    List <Producto> findByIdCategoriaOrderByNombreAsc(int  idCategoria); 

    /*De otra manera ingresando con Query sería de la sig manera
    @Query("SELECT * FROM productos where id_categoria = ?", nativeQuery = true) //ya no es necesario llamar el método como findById
    List<Producto> getByCategoria(int idCategoria); */

    //recueprar productos escasos
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado); 
}

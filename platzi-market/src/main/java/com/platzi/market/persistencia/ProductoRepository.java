package com.platzi.market.persistencia;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistencia.crud.ProductoCrudRepository;
import com.platzi.market.persistencia.entity.Producto;
import com.platzi.market.persistencia.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**Como es una clase que interactua con la BD entonces se le asigna @Repository 
@Component es una generalización pero queda mejor Repository
 Para orientar ProductRepository al dominio es hacer que implemente al ProducRepository (interface)*/
@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired //Da a entender que Spring crea esas instancias y debe de ser un componente de spring (las anotaciones)
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    //Devuelve una lista de todos los productos
    @Override
    public List<Product> getAll(){  //hay que castear
        List<Producto> productos = (List<Producto>)productoCrudRepository.findAll();
        return mapper.toProducts(productos);/*(List<Producto>) productoCrudRepository.findAll();*/
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        //recibe productos que está adentro y los convierte a products
        return productos.map(prods -> mapper.toProducts(prods));
    }
    @Override
    public Optional<Product> getProduct(int productId){
        return productoCrudRepository.findById(productId).map(producto->mapper.toProduct(producto));
    }

    /*
        Asi estaba antes de orientarlo al dominio
        public List<Producto> getByCategoria(int idCategoria){

        /*Se nombra como está en el CrudRepository - devuelve una lista de productos con la categoria especifica
        ordenador en orden alfabetic
        return
                productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        
    }
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true); 
    }

    //obtener producto dado su Id
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto); 
    }*/

    //guardar producto
    @Override
   public Product save(Product product){
        Producto producto = mapper.toProducto(product);
       return mapper.toProduct(productoCrudRepository.save(producto));
   } 
    //Eliminando con llave primaria al producto
    @Override
   public void delete(int productId){
       //si se pusiera solo .delete(Entidad) eliminaría la entidad completa. 
       productoCrudRepository.deleteById(productId);
   }
}

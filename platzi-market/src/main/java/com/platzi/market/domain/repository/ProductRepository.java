package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    /*Nombre de los metodos que queremos que cualquier repositorio que va a trabajar con productos
    * tenga que implementar
    * Reglas que va a tener el dominio al momento que cualquier repositorio quiera acceder a producto
    * No es especifica*/
    List<Product> getAll();
    Optional <List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}

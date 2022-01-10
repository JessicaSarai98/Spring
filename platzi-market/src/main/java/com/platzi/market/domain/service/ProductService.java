package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Servicio de nuestra logica de negocios. Actua como un intermediario entre el controller y el repositorio
@Service
public class ProductService {

    @Autowired //Se pudo poner lo de implements al ser una interface, pero Spring lo detecta
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
    //Productos por categoria. Se añanden los metodos de la interface
    public Optional <List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }
    //ver is el producto existe
    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    /*
    Otra manera de realizar lo anterior pero sin map
     if(getProduct(productId).isPresent()){
        productRepository.delete(productId);
        return true
    }else{
        return false;
    }*/
    }
}

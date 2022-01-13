package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //controlador de un API REST
@RequestMapping("/products") //Lleva como parametro en que pathing va a aceptar las peticiones que se hagan
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        //el primer parametro es el cuerpo de la respuesta y el segundo que la petición respondió de manera adecuada
        return new ResponseEntity(productService.getAll(), HttpStatus.OK);
    }
    /*
    Antes de hacer el ResponseEntity
    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }*/

    @GetMapping("/{productId}") //se debe poner {} y el id, porque es un producto especifico y abajo poner @PathVarible
    public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
            return productService.getProduct(productId)
                    .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); //si no se ejecuta el map, es cuando dentro de getProduct(id) no hay ningun producto
    }

   /* @GetMapping("/{productId}") //se debe poner {} y el id, porque es un producto especifico y abajo poner @PathVarible
    public Optional<Product> getProduct(@PathVariable("productId") int productId) {
        return productService.getProduct(productId);
    }*/

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /*Es lo mismo que el anterior pero devolviendo un category, en este caso para que no haya confusión
    en el path se agrega "/category/id
    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId);
    }*/

    @PostMapping("/save") //va a ser como el cuerpo de la peticion entonces se agrega @RequestBody
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
    /*@PostMapping("/save") //va a ser como el cuerpo de la peticion entonces se agrega @RequestBody
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }*/

    @DeleteMapping("/delete/{productId}") //como va a devolver un booleano, solo se deja como ResponseEntity
    public ResponseEntity delete(@PathVariable int productId){
        if(productService.delete(productId)){ //si se elimino el producto devuelvo un estado OK
            return new ResponseEntity(HttpStatus.OK);
        } else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    /*@DeleteMapping("/delete/{productId}")
    public boolean delete(@PathVariable int productId){
        return productService.delete(productId);
    }*/
}

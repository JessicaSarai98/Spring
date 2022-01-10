package com.platzi.market.persistencia.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistencia.entity.Producto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

//Como Category ya está mapeado, entonces se agrega uses
@Mapper(componentModel ="spring", uses={CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
        @Mapping(source = "",target="productId"),
            @Mapping(source = "idProducto",target="productId"),
            @Mapping(source = "nombre",target="name"),
            @Mapping(source = "idCategoria",target="categoryId"),
            @Mapping(source = "precioVenta",target="price"),
            @Mapping(source = "cantidadStock",target="stock"),
            @Mapping(source = "estado",target="active"),
            @Mapping(source = "categoria",target="category"), //como category esta mapeado hay que incluirlo al componentModel


    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target="codigoBarras",ignore=true)
    Producto toProducto(Product product);
}

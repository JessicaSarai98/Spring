package com.platzi.market.persistencia.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistencia.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.InheritInverseConfiguration;

/*Anotacion para indicar que es un mapper*/
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    /*Category es lo que se va a obtener de este mapper y el metodo es toCategory
     Convertir una categoria en category
     source = atributos que etán en entidad categoria
     target = atributos que estan en el domain categoria*/
    @Mappings({
            @Mapping(source="idCategoria", target="categoryId"), //fuente y target es a donde quiero llevarlo
            @Mapping(source="descripcion", target="category"),
            @Mapping(source="estado", target="active"),
    })
    Category toCategory(Categoria categoria);
    /*Lo siguiente signfica que la conversion es la inversa de mapping,
    * entonces no se deberia de realizar lo siguiente
    @InheritInverseConfiguration
    @Mapping(target="productos",ignore = true) //como en categoria está el atributo productos y en domain no, entonces se ignora
    Categoria toCategoria(Category category);
*/
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}

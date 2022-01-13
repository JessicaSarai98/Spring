package com.platzi.market.domain.repository;

import com.platzi.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    //implementar 3 metodos
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId); //optional porque puede que haya clientes que no tengan compras
    Purchase save(Purchase purchase);
}

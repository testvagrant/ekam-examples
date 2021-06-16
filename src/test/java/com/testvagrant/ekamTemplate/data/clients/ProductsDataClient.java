package com.testvagrant.ekamTemplate.data.clients;

import com.google.inject.Inject;
import com.testvagrant.ekam.commons.cache.DataSetsCache;
import com.testvagrant.ekam.commons.data.DataSetsClient;
import com.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import com.testvagrant.ekamTemplate.data.models.Product;

public class ProductsDataClient extends DataSetsClient {

    @Inject
    public ProductsDataClient(DataSetsCache dataSetsCache) {
        super(dataSetsCache);
    }

    public Product backPack() {
        return getProduct("backPack");
    }

    public Product getProduct(String key) {
        try {
            return getValue(key, Product.class);
        } catch (NoSuchKeyException e) {
            return Product.builder().build();
        }
    }
}

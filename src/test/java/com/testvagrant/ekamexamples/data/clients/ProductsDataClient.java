package com.testvagrant.ekamexamples.data.clients;

import com.testvagrant.ekam.commons.data.DataSetsClient;
import com.testvagrant.ekamexamples.data.models.Product;

public class ProductsDataClient extends DataSetsClient {

  public Product backPack() {
    return getProduct("backPack");
  }

  public Product getProduct(String key) {
    return getValue(key, Product.class);
  }
}

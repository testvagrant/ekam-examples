package com.testvagrant.ekamTemplate.data.clients;

import com.google.inject.Inject;
import com.testvagrant.ekam.commons.DataSetsClient;
import com.testvagrant.ekam.commons.cache.DataSetsCache;
import com.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import com.testvagrant.ekamTemplate.data.models.Address;

public class AddressDataClient extends DataSetsClient {

  @Inject
  public AddressDataClient(DataSetsCache dataSetsCache) {
    super(dataSetsCache);
  }

  public Address getDeliveryAddress() {
    return getAddress("deliveryAddress");
  }

  public Address getAddress(String addressKey) {
    try {
      return getValue(addressKey, Address.class);
    } catch (NoSuchKeyException e) {
      return Address.builder().build();
    }
  }
}

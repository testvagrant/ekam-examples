package com.testvagrant.ekamexamples.data.clients;

import com.testvagrant.ekam.commons.data.DataSetsClient;
import com.testvagrant.ekamexamples.data.models.Address;

public class AddressDataClient extends DataSetsClient {

  public Address getDeliveryAddress() {
    return getAddress("deliveryAddress");
  }

  public Address getAddress(String addressKey) {
    return getValue(addressKey, Address.class);
  }
}

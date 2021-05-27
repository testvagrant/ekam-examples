package com.testvagrant.ekamTemplate.data.clients;

import com.google.inject.Inject;
import com.testvagrant.ekam.commons.DataSetsClient;
import com.testvagrant.ekam.commons.cache.DataSetsCache;
import com.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import com.testvagrant.ekamTemplate.data.models.Credentials;

import static com.testvagrant.ekamTemplate.data.clients.LockUserExampleDataClient.DataKeys.STANDARD_USER;

public class LockUserExampleDataClient extends DataSetsClient {

  @Inject
  public LockUserExampleDataClient(DataSetsCache dataSetsCache) {
    super(dataSetsCache);
  }

  public Credentials getStandardUser(boolean lockUser) {
    return getUser(STANDARD_USER, lockUser);
  }

  public Credentials getUser(String key, boolean lockUser) {
    try {
      return getValue(key, Credentials.class, lockUser);
    } catch (NoSuchKeyException e) {
      return Credentials.builder().build();
    }
  }

  public static final class DataKeys {
    public static final String STANDARD_USER = "standardUser";
  }
}

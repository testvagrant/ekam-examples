package com.testvagrant.ekamTemplate.data.clients;

import com.google.gson.internal.LinkedTreeMap;
import com.google.inject.Inject;
import com.testvagrant.ekam.commons.cache.DataSetsCache;
import com.testvagrant.ekam.commons.data.DataSetsClient;
import com.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import com.testvagrant.ekamTemplate.data.models.Credentials;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import static com.testvagrant.ekamTemplate.data.clients.LockUserExampleDataClient.DataKeys.*;

public class LockUserExampleDataClient extends DataSetsClient {

  @Inject
  public LockUserExampleDataClient(DataSetsCache dataSetsCache) {
    super(dataSetsCache);
  }

  public Credentials getAuthorizedUser(boolean lockUser) {
    Credentials credentials = getUser(AUTHORIZED_USER, lockUser);
    if (Objects.isNull(credentials.getUsername())) {
      throw new RuntimeException("No credentials available/Credentials locked at the moment");
    }

    return credentials;
  }

  public Credentials getUser(String key, boolean lockUser) {
    try {
      return getValue(key, Credentials.class, lockUser);
    } catch (NoSuchKeyException e) {
      return Credentials.builder().build();
    }
  }

  public void release(Credentials credentials) {
    if (Objects.nonNull(credentials) && Objects.nonNull(credentials.getUsername())) {
      super.release(credentialsPredicate(credentials));
    }
  }

  private <T> Predicate<Map.Entry<String, LinkedTreeMap>> credentialsPredicate(
      Credentials credentials) {
    return entry -> entry.getValue().get("username").equals(credentials.getUsername());
  }

  public static final class DataKeys {
    public static final String AUTHORIZED_USER = "authorizedUser";
  }
}

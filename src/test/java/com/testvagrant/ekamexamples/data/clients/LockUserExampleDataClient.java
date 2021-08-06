package com.testvagrant.ekamexamples.data.clients;

import com.google.gson.internal.LinkedTreeMap;
import com.testvagrant.ekam.commons.data.DataSetsClient;
import com.testvagrant.ekamexamples.data.models.Credentials;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import static com.testvagrant.ekamexamples.data.clients.LockUserExampleDataClient.DataKeys.AUTHORIZED_USER;

public class LockUserExampleDataClient extends DataSetsClient {

  public Credentials getAuthorizedUser(boolean lockUser) {
    Credentials credentials = getUser(AUTHORIZED_USER, lockUser);
    if (Objects.isNull(credentials.getUsername())) {
      throw new RuntimeException("No credentials available/Credentials locked at the moment");
    }

    return credentials;
  }

  public Credentials getUser(String key, boolean lockUser) {
    return getValue(key, Credentials.class, lockUser);
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

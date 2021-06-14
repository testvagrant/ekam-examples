package com.testvagrant.ekamTemplate.data.clients;

import com.google.inject.Inject;
import com.testvagrant.ekam.commons.cache.DataSetsCache;
import com.testvagrant.ekam.commons.data.DataSetsClient;
import com.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import com.testvagrant.ekamTemplate.data.models.Credentials;

public class CredentialsDataClient extends DataSetsClient {

  @Inject
  public CredentialsDataClient(DataSetsCache dataSetsCache) {
    super(dataSetsCache);
  }

  public Credentials getStandardUser() {
    return getUser(DataKeys.STANDARD_USER);
  }

  public Credentials getLockedOutUser() {
    return getUser(DataKeys.LOCKED_OUT_USER);
  }

  public Credentials getProblemUser() {
    return getUser(DataKeys.PROBLEM_USER);
  }

  public Credentials getEmptyUser() {
    return getUser("empty");
  }

  public Credentials getInvalidPasswordUser() {
    return getUser("empty").toBuilder().username("invalid").password("invalid").build();
  }

  public Credentials getUser(String key) {
    try {
      return getValue(key, Credentials.class);
    } catch (NoSuchKeyException e) {
      return Credentials.builder().build();
    }
  }

  public static final class DataKeys {
    public static final String STANDARD_USER = "standardUser";
    public static final String LOCKED_OUT_USER = "lockedOutUser";
    public static final String PROBLEM_USER = "problemUser";
  }
}

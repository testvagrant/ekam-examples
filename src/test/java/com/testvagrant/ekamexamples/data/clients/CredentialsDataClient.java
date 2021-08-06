package com.testvagrant.ekamexamples.data.clients;

import com.testvagrant.ekam.commons.data.DataSetsClient;
import com.testvagrant.ekamexamples.data.models.Credentials;

public class CredentialsDataClient extends DataSetsClient {

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
    return getValue(key, Credentials.class);
  }

  public static final class DataKeys {
    public static final String STANDARD_USER = "standardUser";
    public static final String LOCKED_OUT_USER = "lockedOutUser";
    public static final String PROBLEM_USER = "problemUser";
  }
}

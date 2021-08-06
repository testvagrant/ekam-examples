package com.testvagrant.ekamTemplate.db.clients;

import com.testvagrant.ekam.db.clients.PostgresDBClient;

public class AccountsClient extends PostgresDBClient {
  private final Accounts accounts;

  protected AccountsClient() {
    super("krcrvjif");
    accounts = load(Accounts.class);
  }

  public String getUserName(Integer userId) {
    return accounts.getAccountName(userId);
  }
}

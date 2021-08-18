package com.testvagrant.ekamexamples.db;

import com.google.inject.Inject;
import com.testvagrant.ekam.testBases.testng.DbTest;
import com.testvagrant.ekamexamples.db.clients.AccountsClient;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "db")
/* Set "${env:DBUsername}" and "${env:DBPassword}" environment properties */
public class AccountsDbTest extends DbTest {

  @Inject private AccountsClient accountsDBClient;

  public void accountsTest() {
    String userName = accountsDBClient.getUserName(1001);
    Assert.assertEquals(userName, "ekam_user");
  }
}

package com.testvagrant.ekamTemplate.dataset;

import com.google.inject.Inject;
import com.testvagrant.ekam.commons.modules.CacheModule;
import com.testvagrant.ekamTemplate.data.clients.LockUserExampleDataClient;
import com.testvagrant.ekamTemplate.data.models.Credentials;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(modules = CacheModule.class)
public class LockExampleTests {

  @Inject private LockUserExampleDataClient dataClient;

  @Test
  public void shouldLockDataOnceFetched() {
    Credentials standardUser = dataClient.getAuthorizedUser(true);
    Credentials anotherStandardUser = dataClient.getAuthorizedUser(true);

    dataClient.release(standardUser);
    dataClient.release(anotherStandardUser);

    Assert.assertNotEquals(standardUser.getUsername(), anotherStandardUser.getUsername());
  }

  @Test
  public void shouldNotLockDataUnlessSpecified() {
    Credentials standardUser = dataClient.getAuthorizedUser(false);
    Credentials anotherStandardUser = dataClient.getAuthorizedUser(false);

    dataClient.release(standardUser);
    dataClient.release(anotherStandardUser);

    Assert.assertEquals(standardUser.getUsername(), anotherStandardUser.getUsername());
  }

  @Test(expectedExceptions = RuntimeException.class)
  public void shouldThrowExceptionWhenAllCredentialsAreLocked() {
    Credentials standardUser = null;
    Credentials anotherStandardUser = null;
    try {
      standardUser = dataClient.getAuthorizedUser(true);
      anotherStandardUser = dataClient.getAuthorizedUser(true);
      dataClient.getAuthorizedUser(true);
    } catch (Exception ex) {
      dataClient.release(standardUser);
      dataClient.release(anotherStandardUser);
      throw new RuntimeException(ex);
    }
  }
}

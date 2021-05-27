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
    Credentials standardUser = dataClient.getStandardUser(true);
    Credentials anotherStandardUser = dataClient.getStandardUser(true);

    Assert.assertNotEquals(standardUser.getUsername(), anotherStandardUser.getUsername());
  }

  @Test
  public void shouldNotLockDataUnlessSpecified() {
    Credentials standardUser = dataClient.getStandardUser(false);
    Credentials anotherStandardUser = dataClient.getStandardUser(false);

    Assert.assertEquals(standardUser.getUsername(), anotherStandardUser.getUsername());
  }
}

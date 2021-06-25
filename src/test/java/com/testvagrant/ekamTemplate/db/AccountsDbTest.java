package com.testvagrant.ekamTemplate.db;

import com.google.inject.Inject;
import com.testvagrant.ekam.api.modules.GrpcModule;
import com.testvagrant.ekam.config.EkamConfigModule;
import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.db.clients.AccountsClient;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Test(groups = "db")
@Guice(modules = {EkamConfigModule.class, GrpcModule.class})
public class AccountsDbTest extends EkamTest {

    @Inject
    AccountsClient accountsDBClient;

    public void accountsTest() {
        String userName = accountsDBClient.getUserName(1001);
        Assert.assertEquals(userName, "ekam_user");
    }
}

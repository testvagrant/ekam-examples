package com.testvagrant.ekamTemplate;

import com.google.inject.Inject;
import com.testvagrant.ekam.commons.cache.LocaleCache;
import com.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import com.testvagrant.ekam.commons.modules.LocaleModule;
import com.testvagrant.ekam.config.EkamConfigModule;
import com.testvagrant.ekam.config.models.Ekam;
import com.testvagrant.ekamTemplate.data.models.ConfirmationDetails;
import org.assertj.core.api.AbstractBooleanAssert;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

/**
 * A single testbase to cover web/mobile/api tests for an application
 */
@Guice(modules = {EkamConfigModule.class, LocaleModule.class})
public class EkamTest {

    @Inject
    Ekam ekam;

    @Inject
    LocaleCache localeCache;

    @Test
    public void localeTest() throws NoSuchKeyException {
        ConfirmationDetails confirmationDetails1 = localeCache.get("confirmation_messages", ConfirmationDetails.class);
        ConfirmationDetails confirmationDetails = new ConfirmationDetails();
        confirmationDetails.setMessage("THANK YOU FOR YOU ORDER");
        confirmationDetails.setDescription("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        confirmationDetails.orderConfirmed(confirmationDetails1);
    }
}

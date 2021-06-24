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

import javax.inject.Named;

/**
 * A single testbase to cover web/mobile/api tests for an application
 */
public class EkamTest {
}

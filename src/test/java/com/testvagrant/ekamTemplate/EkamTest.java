package com.testvagrant.ekamTemplate;

import com.testvagrant.ekam.commons.modules.LocaleModule;
import org.testng.annotations.Guice;

/**
 * A single testbase to cover web/mobile/api tests for an application
 */
@Guice(modules = {LocaleModule.class})
public class EkamTest {
}

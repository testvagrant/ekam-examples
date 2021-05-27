package com.testvagrant.ekamTemplate;

import com.testvagrant.ekam.api.modules.GrpcModule;
import com.testvagrant.ekam.api.modules.PropertyModule;
import com.testvagrant.ekam.commons.modules.CacheModule;
import com.testvagrant.ekam.commons.modules.LocaleModule;
import com.testvagrant.ekam.commons.modules.SwitchViewModule;
import org.testng.annotations.Guice;

/** A single testbase to cover web/mobile/api tests for an application */
@Guice(modules = {CacheModule.class, LocaleModule.class})
public class EkamTest {}

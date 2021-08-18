package com.testvagrant.ekamexamples.mobile.steps;

import com.testvagrant.ekam.testBases.cucumber.MobileScenarioDefinition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MobileBaseStep extends MobileScenarioDefinition {

  @Before
  public void setup(Scenario scenario) {
    super.setup(scenario);
  }

  @After
  public void tearDown() {
    super.tearDown();
  }
}

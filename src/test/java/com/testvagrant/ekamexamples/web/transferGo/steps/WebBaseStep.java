package com.testvagrant.ekamexamples.web.transferGo.steps;

import com.testvagrant.ekam.testBases.cucumber.web.WebScenarioDefinition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class WebBaseStep extends WebScenarioDefinition {

  @Before
  public void setup(Scenario scenario) {
    super.setup(scenario);
  }

  @After
  public void tearDown() {
    super.tearDown();
  }
}

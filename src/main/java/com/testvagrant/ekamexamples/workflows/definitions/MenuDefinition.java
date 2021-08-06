package com.testvagrant.ekamexamples.workflows.definitions;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.MenuScreen;
import com.testvagrant.ekamexamples.workflows.WorkflowDefinition;

public class MenuDefinition extends WorkflowDefinition {

  public MenuDefinition(UseCase useCase) {
    super(useCase);
  }

  @Override
  public MenuDefinition next() {
    return this;
  }

  @Override
  public MenuScreen create() {
    return LayoutInitiator.Screen(MenuScreen.class);
  }
}

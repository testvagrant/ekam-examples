package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.MenuScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.ProductsScreen;

public class MenuWorkflow extends WorkflowDefinition {

  public MenuWorkflow(UseCase useCase) {
    super(useCase);
  }

  @Override
  public MenuWorkflow next() {
    return this;
  }

  @Override
  public MenuScreen create() {
    return LayoutInitiator.Screen(MenuScreen.class);
  }
}

package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.MenuScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.ProductsScreen;

public class MenuWorkflow extends SwagWorkflow {

  public MenuWorkflow(UseCase useCase) {
    super(useCase);
  }

  @Override
  protected SwagWorkflow next() {
    return this;
  }

  @Override
  protected FulfillCondition<SwagWorkflow> fulfillCondition() {
    return () -> {
      LayoutInitiator.Screen(ProductsScreen.class).navToMenu();
      return this;
    };
  }

  @Override
  public MenuScreen menu() {
    return LayoutInitiator.Screen(MenuScreen.class);
  }
}

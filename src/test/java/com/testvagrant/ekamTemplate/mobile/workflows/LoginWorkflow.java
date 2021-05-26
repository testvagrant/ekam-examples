package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.Credentials;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.ConfirmationScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.LoginScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.ProductsScreen;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

public class LoginWorkflow extends SwagWorkflow {

  public LoginWorkflow(UseCase useCase) {
    super(useCase);
  }

  @Override
  protected SwagWorkflow next() {
    return new ProductsWorkFlow(useCase);
  }

  @Override
  protected FulfillCondition<SwagWorkflow> fulfillCondition() {
    return () -> {
      login().login(useCase.getData(Credentials.class));
      return this;
    };
  }

  @Override
  public LoginScreen login() {
    return Screen(LoginScreen.class);
  }
}

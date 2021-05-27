package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekamTemplate.data.models.Credentials;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.LoginScreen;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

public class LoginWorkflow extends WorkflowDefinition {

  public LoginWorkflow(UseCase useCase) {
    super(useCase);
  }

  protected FulfillCondition<LoginWorkflow> loginCondition = () -> {
      create().login(useCase.getData(Credentials.class));
      return this;
  };


  @Override
  public ProductsWorkFlow next() {
    return proceedToNext(loginCondition, new ProductsWorkFlow(useCase));
  }

  @Override
  public LoginScreen create() {
    return Screen(LoginScreen.class);
  }
}

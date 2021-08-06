package com.testvagrant.ekamexamples.workflows.definitions;

import com.testvagrant.ekamTemplate.data.models.Credentials;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.LoginScreen;
import com.testvagrant.ekamexamples.workflows.FulfillCondition;
import com.testvagrant.ekamexamples.workflows.WorkflowDefinition;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

public class LoginDefinition extends WorkflowDefinition {

  protected FulfillCondition<LoginDefinition> loginCondition =
      () -> {
        create().login(useCase.getData(Credentials.class));
        return this;
      };

  public LoginDefinition(UseCase useCase) {
    super(useCase);
  }

  @Override
  public ProductsDefinition next() {
    return proceedToNext(loginCondition, new ProductsDefinition(useCase));
  }

  @Override
  public LoginScreen create() {
    return Screen(LoginScreen.class);
  }
}

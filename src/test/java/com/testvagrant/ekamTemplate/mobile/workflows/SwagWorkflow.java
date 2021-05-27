package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekamTemplate.data.models.UseCase;

public class SwagWorkflow {

  private UseCase useCase;

  public SwagWorkflow(UseCase useCase) {
    this.useCase = useCase;
  }

  public LoginWorkflow login() {
    return new SplashWorkflow(useCase).next();
  }

  public ProductsWorkFlow products() {
    return login().next();
  }

  public CartWorkflow cart() {
    return products().cart();
  }

  public MenuWorkflow menu() {
    return products().menu();
  }

  public CheckoutWorkflow checkout() {
    return cart().next();
  }

  public ConfirmationWorkflow confirmation() {
    return checkout().next();
  }
}

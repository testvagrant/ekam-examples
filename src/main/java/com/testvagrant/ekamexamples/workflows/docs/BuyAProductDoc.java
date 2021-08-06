package com.testvagrant.ekamexamples.workflows.docs;

import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.workflows.definitions.*;
import com.testvagrant.ekamexamples.workflows.WorkflowDoc;

public class BuyAProductDoc extends WorkflowDoc {

  public BuyAProductDoc(UseCase useCase) {
    super(useCase);
  }

  // Entry workflow
  public LoginDefinition login() {
    return new LoginDefinition(useCase);
  }

  // Keep building on top of that
  public ProductsDefinition products() {
    return login().next();
  }

  public CartDefinition cart() {
    return products().cart();
  }

  public MenuDefinition menu() {
    return products().menu();
  }

  public CheckoutDefinition checkout() {
    return cart().next();
  }

  public ConfirmationDefinition confirmation() {
    return checkout().next();
  }
}

package com.testvagrant.ekamexamples.workflows.docs;

import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamexamples.workflows.WorkflowDoc;
import com.testvagrant.ekamexamples.workflows.definitions.LoginDefinition;
import com.testvagrant.ekamexamples.workflows.definitions.MenuDefinition;
import com.testvagrant.ekamexamples.workflows.definitions.ProductsDefinition;

public class MenuDoc extends WorkflowDoc {

  public MenuDoc(UseCase useCase) {
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

  public MenuDefinition menu() {
    return products().menu();
  }
}

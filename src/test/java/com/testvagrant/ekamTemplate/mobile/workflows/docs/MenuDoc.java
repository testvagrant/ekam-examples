package com.testvagrant.ekamTemplate.mobile.workflows.docs;

import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.workflows.definitions.LoginDefinition;
import com.testvagrant.ekamTemplate.mobile.workflows.definitions.MenuDefinition;
import com.testvagrant.ekamTemplate.mobile.workflows.definitions.ProductsDefinition;
import com.testvagrant.ekamTemplate.mobile.workflows.WorkflowDoc;

public class MenuDoc extends WorkflowDoc {

    public MenuDoc(UseCase useCase) {
        super(useCase);
    }

    // Entry workflow
    public LoginDefinition login() {
        return new LoginDefinition(useCase);
    }
    //Keep building on top of that
    public ProductsDefinition products() {
        return login().next();
    }

    public MenuDefinition menu() {
        return products().menu();
    }
}

package com.testvagrant.ekamTemplate.mobile.workflows;


import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.*;

public abstract class SwagWorkflow extends WorkflowDefinition<SwagWorkflow> {

    protected UseCase useCase;

    public SwagWorkflow() { this.useCase = UseCase.builder().build(); }

    public SwagWorkflow(UseCase useCase) {
        this.useCase = useCase;
    }

    public LoginScreen login() { return proceedTo().login(); }

    public ProductsScreen products() {return proceedTo().products(); }

    public CartScreen cart(){ return proceedTo().cart(); }

    public CheckoutScreen checkout(){ return proceedTo().checkout(); }

    public ConfirmationScreen confirmation(){ return proceedTo().confirmation(); }

}

package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.LoginScreen;

import java.awt.*;

public class SplashWorkflow extends SwagWorkflow {

    private UseCase useCase;

    public SplashWorkflow(UseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    protected FulfillCondition<SwagWorkflow> fulfillCondition() {
        return () -> this;
    }

    @Override
    protected SwagWorkflow next() {
        return new LoginWorkflow(useCase);
    }
}

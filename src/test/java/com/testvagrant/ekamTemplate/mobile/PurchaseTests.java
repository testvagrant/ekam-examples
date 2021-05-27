package com.testvagrant.ekamTemplate.mobile;

import com.google.inject.Inject;
import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.data.clients.UseCaseGenerator;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.MenuScreen;
import com.testvagrant.ekamTemplate.mobile.workflows.MenuWorkflow;
import com.testvagrant.ekamTemplate.mobile.workflows.WorkflowNavigator;
import org.testng.annotations.Test;

@Test(groups = "mobile")
public class PurchaseTests extends EkamTest {

  @Inject private UseCaseGenerator useCaseGenerator;

  @Inject private WorkflowNavigator workflowNavigator;

  public void purchaseProductAndValidate() {
    UseCase happyPathCase = useCaseGenerator.happyPathCase();
    workflowNavigator
        .forUseCase(happyPathCase)
        .proceedTo()
        .confirmation()
        .create()
        .getConfirmationDetails()
        .orderConfirmed()
        .isTrue();
  }

  public void productDetailsTest() {
    UseCase happyPathCase = useCaseGenerator.happyPathCase();
    MenuWorkflow productFromProduct = workflowNavigator.forUseCase(happyPathCase).proceedTo().menu();
  }
}

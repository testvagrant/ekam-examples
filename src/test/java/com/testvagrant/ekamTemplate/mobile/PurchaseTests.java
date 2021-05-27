package com.testvagrant.ekamTemplate.mobile;

import com.google.inject.Inject;
import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.data.clients.UseCaseGenerator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
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
        .getConfirmationDetails()
        .orderConfirmed()
        .isTrue();
  }
}

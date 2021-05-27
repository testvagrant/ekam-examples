package com.testvagrant.ekamTemplate.mobile;

import com.google.inject.Inject;
import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.data.clients.UseCaseGenerator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.workflows.definitions.MenuDefinition;
import com.testvagrant.ekamTemplate.mobile.workflows.docs.BuyAProductDoc;
import com.testvagrant.ekamTemplate.mobile.workflows.docs.MenuDoc;
import org.testng.annotations.Test;

@Test(groups = "mobile")
public class PurchaseTests extends EkamTest {

  @Inject private UseCaseGenerator useCaseGenerator;

  public void purchaseProductAndValidate() {
    UseCase happyPathCase = useCaseGenerator.happyPathCase();
    new BuyAProductDoc(happyPathCase)
        .confirmation()
        .create()
        .getConfirmationDetails()
        .orderConfirmed()
        .isTrue();
  }

  public void productDetailsTest() {
    UseCase happyPathCase = useCaseGenerator.happyPathCase();
    MenuDefinition productFromProduct = new MenuDoc(happyPathCase).menu();
  }
}

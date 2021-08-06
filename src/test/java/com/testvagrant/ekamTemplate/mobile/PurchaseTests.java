package com.testvagrant.ekamTemplate.mobile;

import com.google.inject.Inject;
import com.testvagrant.ekam.commons.locale.LocaleClient;
import com.testvagrant.ekam.testBases.testng.MobileTest;
import com.testvagrant.ekamTemplate.data.clients.UseCaseGenerator;
import com.testvagrant.ekamTemplate.data.models.ConfirmationDetails;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.workflows.docs.BuyAProductDoc;
import com.testvagrant.ekamexamples.workflows.models.UseCase;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(groups = "mobile")
public class PurchaseTests extends MobileTest {

  @Inject LocaleClient localeClient;
  @Inject private UseCaseGenerator useCaseGenerator;

  public void purchaseProductAndValidate() {
    UseCase happyPathCase = useCaseGenerator.happyPathCase();
    new BuyAProductDoc(happyPathCase)
        .confirmation()
        .create()
        .getConfirmationDetails()
        .orderConfirmed(localeClient.getLocale("confirmation_messages", ConfirmationDetails.class));
  }

  public void navigateToCart() {
    UseCase happyPathCase = useCaseGenerator.happyPathCase();
    BuyAProductDoc buyAProductDoc = new BuyAProductDoc(happyPathCase);
    Product cartDetails = buyAProductDoc.cart().create().getCartDetails();
    assertThat(cartDetails.getName()).isEqualTo("Sauce Labs Backpack");
  }
}

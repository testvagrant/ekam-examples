package com.testvagrant.ekamTemplate.data.models;

import com.testvagrant.ekam.commons.locale.LocaleClient;
import lombok.*;
import org.assertj.core.api.AbstractBooleanAssert;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmationDetails {
    private String message;
    private String description;

    public void orderConfirmed(ConfirmationDetails confirmationMessages) {
        assertThat(this).usingRecursiveComparison().isEqualTo(confirmationMessages);
    }
}

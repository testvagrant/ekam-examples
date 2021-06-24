package com.testvagrant.ekamTemplate.data.models;

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

    public void orderConfirmed(ConfirmationDetails confirmationDetails) {
        assertThat(this).usingRecursiveComparison().isEqualTo(confirmationDetails);
    }
}

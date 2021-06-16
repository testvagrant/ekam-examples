package com.testvagrant.ekamTemplate.data.models;

import com.testvagrant.ekam.commons.locale.LocaleFinder;
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

    public AbstractBooleanAssert<?> orderConfirmed() {
        ConfirmationDetails confirmation_messages =
                LocaleFinder.findLocale("confirmation_messages", ConfirmationDetails.class);
        boolean equals =
                confirmation_messages.message.equals(this.message)
                        && confirmation_messages.description.equals(this.description);
        return assertThat(equals);
    }
}

package com.testvagrant.ekamTemplate.data.models;

import com.testvagrant.ekam.commons.locale.LocaleFinder;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmationDetails {
    private String message;
    private String description;

    public void assertThatOrderIsConfirmed() {
        ConfirmationDetails confirmation_messages = LocaleFinder.findLocale("confirmation_messages", ConfirmationDetails.class);
        confirmation_messages.description.equals(this.message);
        confirmation_messages.message.equals(this.description);
    }
}

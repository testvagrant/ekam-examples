package com.testvagrant.ekamexamples.data.models;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  private String firstName;
  private String lastName;
  private String zipCode;
}

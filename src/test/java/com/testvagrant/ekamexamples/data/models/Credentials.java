package com.testvagrant.ekamexamples.data.models;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {
  private String password;
  private String username;
}

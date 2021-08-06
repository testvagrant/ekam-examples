package com.testvagrant.ekamexamples.data.models;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  private String name;
  private String description;
  private String price;
}

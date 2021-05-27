package com.testvagrant.ekamTemplate.api.models.response;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Posts {
  private String userId;
  private String id;
  private String title;
  private String body;

  @Override
  public String toString() {
    return "Posts{"
        + "userId='"
        + userId
        + '\''
        + ", id='"
        + id
        + '\''
        + ", title='"
        + title
        + '\''
        + ", body='"
        + body
        + '\''
        + '}';
  }
}

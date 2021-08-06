package com.testvagrant.ekamexamples.workflows.models;

import com.testvagrant.ekamexamples.workflows.WorkflowDefinition;
import lombok.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class UseCase {
  @Builder.Default private Map<Class<?>, Object> useCases = new ConcurrentHashMap<>();
  private WorkflowDefinition currentState;

  public UseCase addToUseCase(Object data) {
    useCases.put(data.getClass(), data);
    return this;
  }

  public <Q> Q getData(Class<Q> tClass) {
    return (Q) useCases.get(tClass);
  }

  public WorkflowDefinition persist(WorkflowDefinition currentState) {
    this.currentState = currentState;
    return currentState;
  }
}

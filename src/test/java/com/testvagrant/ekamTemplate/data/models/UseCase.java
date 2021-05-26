package com.testvagrant.ekamTemplate.data.models;

import lombok.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UseCase {
    @Builder.Default
    private Map<Class<?>,Object> useCases = new ConcurrentHashMap<>();

    public UseCase addToUseCase(Object data) {
        useCases.put(data.getClass(), data);
        return this;
    }

    public <Q> Q getData(Class<Q> tClass) {
        return (Q) useCases.get(tClass);
    }
}

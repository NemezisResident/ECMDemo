package com.nemezis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Обертка для ответов из RestTemplate
 * @param <T>
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wrapper<T> {

    private String message;
    private T data;

    public static <T> Wrapper<T> create(final T data) {
        return new Wrapper<>(null, data);
    }
}
package com.goralski.server.utils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by kgoralski on 19/07/16.
 */
@FunctionalInterface
public interface BaseConverter<F, T> {

    public T convert(F from);

    default public Collection<T> convertAll(Collection<F> fElements) {
        Collection<T> convertedElement =
                fElements.stream()
                        .map(element -> convert(element))
                        .collect(Collectors.toList());
        return convertedElement;
    }
}

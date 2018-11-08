package com.xyz.sample.Util;

import com.google.common.collect.ImmutableMap;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import java.util.Map;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;


@Immutable
@ParametersAreNonnullByDefault
public class ClassValueLookupMap<C, V> {

   private final Map<Class<? extends C>, V> backingMap;

   public ClassValueLookupMap(Map<Class<? extends C>, V> backingMap) {

      checkNotNull(backingMap);

      this.backingMap = ImmutableMap.copyOf(backingMap);
   }

   public Optional<V> get(Class<? extends C> key) {

      checkNotNull(key);

      Class<?> currentClass = key;
      while (!currentClass.equals(Object.class)) {

         V value = backingMap.get(currentClass);
         if (value != null) {

            return Optional.of(value);
         }

         currentClass = currentClass.getSuperclass();
      }

      return Optional.empty();
   }

   public V getOrDefault(Class<? extends C> key, V defaultValue) {

      return this.get(key).orElse(defaultValue);
   }
}

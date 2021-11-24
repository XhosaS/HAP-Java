package io.github.hapjava.characteristics.impl.television;

import io.github.hapjava.characteristics.ExceptionalConsumer;
import io.github.hapjava.characteristics.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.impl.base.IntegerCharacteristic;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ActiveIdentifierCharacteristic extends IntegerCharacteristic {

  /**
   * Default constructor
   *
   * @param getter       getter for value
   * @param setter       setter for value
   * @param subscriber   subscribers to changes
   * @param unsubscriber unsubscribers to changes
   */
  public ActiveIdentifierCharacteristic(
      Supplier<CompletableFuture<Integer>> getter,
      ExceptionalConsumer<Integer> setter,
      Consumer<HomekitCharacteristicChangeCallback> subscriber,
      Runnable unsubscriber) {
    super(
        "000000E7-0000-1000-8000-0026BB765291",
        "Active Identifier",
        Integer.MIN_VALUE,
        Integer.MAX_VALUE,
        "",
        Optional.of(getter),
        Optional.of(setter),
        Optional.of(subscriber),
        Optional.of(unsubscriber));
  }
}

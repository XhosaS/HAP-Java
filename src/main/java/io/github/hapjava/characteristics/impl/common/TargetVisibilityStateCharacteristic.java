package io.github.hapjava.characteristics.impl.common;

import io.github.hapjava.characteristics.ExceptionalConsumer;
import io.github.hapjava.characteristics.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.impl.base.EnumCharacteristic;
import io.github.hapjava.characteristics.impl.inputsource.CurrentVisibilityStateEnum;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TargetVisibilityStateCharacteristic
    extends EnumCharacteristic<CurrentVisibilityStateEnum> {

  public TargetVisibilityStateCharacteristic(
      Supplier<CompletableFuture<CurrentVisibilityStateEnum>> getter,
      ExceptionalConsumer<CurrentVisibilityStateEnum> setter,
      Consumer<HomekitCharacteristicChangeCallback> subscriber,
      Runnable unsubscriber) {
    super(
        "00000134-0000-1000-8000-0026BB765291",
        "Target Visibility State",
        CurrentVisibilityStateEnum.values(),
        Optional.of(getter),
        Optional.of(setter),
        Optional.of(subscriber),
        Optional.of(unsubscriber));
  }
}

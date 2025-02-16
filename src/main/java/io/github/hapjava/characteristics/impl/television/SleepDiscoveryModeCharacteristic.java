package io.github.hapjava.characteristics.impl.television;

import io.github.hapjava.characteristics.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.impl.base.EnumCharacteristic;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SleepDiscoveryModeCharacteristic extends EnumCharacteristic<SleepDiscoveryModeEnum> {

  public SleepDiscoveryModeCharacteristic(
      Supplier<CompletableFuture<SleepDiscoveryModeEnum>> getter,
      Consumer<HomekitCharacteristicChangeCallback> subscriber,
      Runnable unsubscriber) {
    super(
        "000000E8-0000-1000-8000-0026BB765291",
        "Sleep Discovery Mode",
        SleepDiscoveryModeEnum.values(),
        Optional.of(getter),
        Optional.empty(),
        Optional.of(subscriber),
        Optional.of(unsubscriber));
  }
}

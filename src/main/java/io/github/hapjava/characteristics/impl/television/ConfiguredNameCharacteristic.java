package io.github.hapjava.characteristics.impl.television;

import io.github.hapjava.characteristics.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.impl.base.StaticStringCharacteristic;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConfiguredNameCharacteristic extends StaticStringCharacteristic {

  public ConfiguredNameCharacteristic(
      Supplier<CompletableFuture<String>> getter,
      Consumer<HomekitCharacteristicChangeCallback> subscriber,
      Runnable unsubscriber) {
    super(
        "000000E3-0000-1000-8000-0026BB765291",
        "Configured Name",
        Optional.of(getter),
        Optional.of(subscriber),
        Optional.of(unsubscriber));
  }
}

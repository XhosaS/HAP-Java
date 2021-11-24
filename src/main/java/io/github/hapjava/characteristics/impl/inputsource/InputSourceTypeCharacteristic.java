package io.github.hapjava.characteristics.impl.inputsource;

import io.github.hapjava.characteristics.impl.base.EnumCharacteristic;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class InputSourceTypeCharacteristic extends EnumCharacteristic<InputSourceTypeEnum> {

  public InputSourceTypeCharacteristic(Supplier<CompletableFuture<InputSourceTypeEnum>> getter) {
    super(
        "000000DB-0000-1000-8000-0026BB765291",
        "Input Source Type",
        InputSourceTypeEnum.values(),
        Optional.of(getter),
        Optional.empty(),
        Optional.empty(),
        Optional.empty());
  }
}

package io.github.hapjava.characteristics.impl.television;

import io.github.hapjava.characteristics.ExceptionalConsumer;
import io.github.hapjava.characteristics.impl.base.EnumCharacteristic;

import java.util.Optional;

public class RemoteKeyCharacteristic extends EnumCharacteristic<RemoteKeyEnum> {

  public RemoteKeyCharacteristic(ExceptionalConsumer<RemoteKeyEnum> setter) {
    super(
        "000000E1-0000-1000-8000-0026BB765291",
        "Remote Key",
        RemoteKeyEnum.values(),
        Optional.empty(),
        Optional.of(setter),
        Optional.empty(),
        Optional.empty());
  }
}

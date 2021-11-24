package io.github.hapjava.accessories.optionalcharacteristic;

import io.github.hapjava.characteristics.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.impl.common.ActiveEnum;

import java.util.concurrent.CompletableFuture;

public interface AccessoryWithActive {
  CompletableFuture<ActiveEnum> getActive();

  CompletableFuture<Void> setActive(ActiveEnum active) throws Exception;

  void subscribeActiveState(HomekitCharacteristicChangeCallback callback);

  void unsubscribeActiveState();
}

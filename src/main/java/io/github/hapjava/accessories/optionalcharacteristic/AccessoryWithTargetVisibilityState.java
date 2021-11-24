package io.github.hapjava.accessories.optionalcharacteristic;

import io.github.hapjava.characteristics.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.impl.inputsource.CurrentVisibilityStateEnum;

import java.util.concurrent.CompletableFuture;

public interface AccessoryWithTargetVisibilityState {

  CompletableFuture<CurrentVisibilityStateEnum> getTargetVisibilityState();

  CompletableFuture<Void> setTargetVisibilityState(CurrentVisibilityStateEnum state)
      throws Exception;

  void subscribeTargetVisibilityState(HomekitCharacteristicChangeCallback callback);

  void unsubscribeTargetVisibilityState();
}

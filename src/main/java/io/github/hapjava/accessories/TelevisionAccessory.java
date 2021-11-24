package io.github.hapjava.accessories;

import io.github.hapjava.characteristics.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.impl.common.ActiveEnum;
import io.github.hapjava.characteristics.impl.television.RemoteKeyEnum;
import io.github.hapjava.characteristics.impl.television.SleepDiscoveryModeEnum;
import io.github.hapjava.services.Service;
import io.github.hapjava.services.impl.TelevisionService;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public interface TelevisionAccessory extends HomekitAccessory {

  CompletableFuture<ActiveEnum> getActive();

  CompletableFuture<Void> setActive(ActiveEnum active) throws Exception;

  void subscribeActiveState(HomekitCharacteristicChangeCallback callback);

  void unsubscribeActiveState();

  CompletableFuture<Integer> getActiveIdentifier();

  CompletableFuture<Void> setActiveIdentifier(Integer activeIdentifier) throws Exception;

  void subscribeActiveIdentifierState(HomekitCharacteristicChangeCallback callback);

  void unsubscribeActiveIdentifierState();

  CompletableFuture<String> getConfiguredName();

  void subscribeConfiguredNameState(HomekitCharacteristicChangeCallback callback);

  void unsubscribeConfiguredNameState();

  CompletableFuture<Void> setRemoteKey(RemoteKeyEnum remoteKey);

  CompletableFuture<SleepDiscoveryModeEnum> getSleepDiscoveryMode();

  void subscribeSleepDiscoveryModeState(HomekitCharacteristicChangeCallback callback);

  void unsubscribeSleepDiscoveryModeState();

  @Override
  default Collection<Service> getServices() {
    return Collections.singleton(new TelevisionService(this));
  }
}

package io.github.hapjava.accessories;

import io.github.hapjava.characteristics.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.impl.common.IsConfiguredEnum;
import io.github.hapjava.characteristics.impl.inputsource.CurrentVisibilityStateEnum;
import io.github.hapjava.characteristics.impl.inputsource.InputSourceTypeEnum;
import io.github.hapjava.services.Service;
import io.github.hapjava.services.impl.InputSourceService;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public interface InputSourceAccessory extends HomekitAccessory {
  CompletableFuture<String> getConfiguredName();

  void subscribeConfiguredNameState(HomekitCharacteristicChangeCallback callback);

  void unsubscribeConfiguredNameState();

  CompletableFuture<InputSourceTypeEnum> getInputSourceType();

  /**
   * isConfigured state
   *
   * @return a future that will contain the isConfigured state
   */
  CompletableFuture<IsConfiguredEnum> getIsConfigured();

  /**
   * Set the isConfigured (NOT_CONFIGURED, CONFIGURED).
   *
   * @param isConfigured isConfigured state
   * @return a future that completes when the change is made
   */
  CompletableFuture<Void> setIsConfigured(IsConfiguredEnum isConfigured);

  /**
   * Subscribes to changes in isConfigured state
   *
   * @param callback the function to call when the isConfigured state changes.
   */
  void subscribeIsConfigured(HomekitCharacteristicChangeCallback callback);

  /**
   * Unsubscribes from changes in the isConfigured state.
   */
  void unsubscribeIsConfigured();

  /**
   * Retrieves the name of service.
   *
   * @return a future with the name
   */
  CompletableFuture<String> getName();

  CompletableFuture<CurrentVisibilityStateEnum> getCurrentVisibilityState();

  void subscribeCurrentVisibilityStateState(HomekitCharacteristicChangeCallback callback);

  void unsubscribeCurrentVisibilityStateState();

  @Override
  default Collection<Service> getServices() {
    return Collections.singleton(new InputSourceService(this));
  }
}

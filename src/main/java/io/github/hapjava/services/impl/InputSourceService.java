package io.github.hapjava.services.impl;

import io.github.hapjava.accessories.InputSourceAccessory;
import io.github.hapjava.accessories.optionalcharacteristic.AccessoryWithTargetVisibilityState;
import io.github.hapjava.characteristics.impl.common.IsConfiguredCharacteristic;
import io.github.hapjava.characteristics.impl.common.NameCharacteristic;
import io.github.hapjava.characteristics.impl.common.TargetVisibilityStateCharacteristic;
import io.github.hapjava.characteristics.impl.inputsource.CurrentVisibilityStateCharacteristic;
import io.github.hapjava.characteristics.impl.inputsource.InputSourceTypeCharacteristic;
import io.github.hapjava.characteristics.impl.television.ConfiguredNameCharacteristic;

public class InputSourceService extends AbstractServiceImpl {

  public InputSourceService(
      ConfiguredNameCharacteristic configuredNameCharacteristic,
      InputSourceTypeCharacteristic inputSourceTypeCharacteristic,
      IsConfiguredCharacteristic isConfiguredCharacteristic,
      NameCharacteristic nameCharacteristic,
      CurrentVisibilityStateCharacteristic currentVisibilityStateCharacteristic) {
    super("000000D9-0000-1000-8000-0026BB765291");
    addCharacteristic(configuredNameCharacteristic);
    addCharacteristic(inputSourceTypeCharacteristic);
    addCharacteristic(isConfiguredCharacteristic);
    addCharacteristic(nameCharacteristic);
    addCharacteristic(currentVisibilityStateCharacteristic);
  }

  public InputSourceService(InputSourceAccessory accessory) {
    this(
        new ConfiguredNameCharacteristic(
            accessory::getConfiguredName,
            accessory::subscribeConfiguredNameState,
            accessory::unsubscribeConfiguredNameState),
        new InputSourceTypeCharacteristic(accessory::getInputSourceType),
        new IsConfiguredCharacteristic(
            accessory::getIsConfigured,
            accessory::setIsConfigured,
            accessory::subscribeIsConfigured,
            accessory::unsubscribeIsConfigured),
        new NameCharacteristic(accessory::getName),
        new CurrentVisibilityStateCharacteristic(
            accessory::getCurrentVisibilityState,
            accessory::subscribeCurrentVisibilityStateState,
            accessory::unsubscribeCurrentVisibilityStateState));
    if (accessory instanceof AccessoryWithTargetVisibilityState) {
      addOptionalCharacteristic(
          new TargetVisibilityStateCharacteristic(
              ((AccessoryWithTargetVisibilityState) accessory)::getTargetVisibilityState,
              ((AccessoryWithTargetVisibilityState) accessory)::setTargetVisibilityState,
              ((AccessoryWithTargetVisibilityState) accessory)::subscribeTargetVisibilityState,
              ((AccessoryWithTargetVisibilityState) accessory)::unsubscribeTargetVisibilityState));
    }
  }

  public void addOptionalCharacteristic(TargetVisibilityStateCharacteristic characteristic) {
    addCharacteristic(characteristic);
  }
}

package io.github.hapjava.services.impl;

import io.github.hapjava.accessories.TelevisionAccessory;
import io.github.hapjava.accessories.optionalcharacteristic.AccessoryWithBrightness;
import io.github.hapjava.characteristics.Characteristic;
import io.github.hapjava.characteristics.impl.common.ActiveCharacteristic;
import io.github.hapjava.characteristics.impl.lightbulb.BrightnessCharacteristic;
import io.github.hapjava.characteristics.impl.television.ActiveIdentifierCharacteristic;
import io.github.hapjava.characteristics.impl.television.ConfiguredNameCharacteristic;
import io.github.hapjava.characteristics.impl.television.RemoteKeyCharacteristic;
import io.github.hapjava.characteristics.impl.television.SleepDiscoveryModeCharacteristic;

public class TelevisionService extends AbstractServiceImpl {

  public TelevisionService(
      ActiveCharacteristic activeCharacteristic,
      ActiveIdentifierCharacteristic activeIdentifierCharacteristic,
      ConfiguredNameCharacteristic configuredNameCharacteristic,
      RemoteKeyCharacteristic remoteKeyCharacteristic,
      SleepDiscoveryModeCharacteristic sleepDiscoveryModeCharacteristic) {
    super("000000D8-0000-1000-8000-0026BB765291");
    addCharacteristic(activeCharacteristic);
    addCharacteristic(activeIdentifierCharacteristic);
    addCharacteristic(configuredNameCharacteristic);
    addCharacteristic(remoteKeyCharacteristic);
    addCharacteristic(sleepDiscoveryModeCharacteristic);
  }

  public TelevisionService(TelevisionAccessory accessory) {
    this(
        new ActiveCharacteristic(
            accessory::getActive,
            accessory::setActive,
            accessory::subscribeActiveState,
            accessory::unsubscribeActiveState),
        new ActiveIdentifierCharacteristic(
            accessory::getActiveIdentifier,
            accessory::setActiveIdentifier,
            accessory::subscribeActiveIdentifierState,
            accessory::unsubscribeActiveIdentifierState),
        new ConfiguredNameCharacteristic(
            accessory::getConfiguredName,
            accessory::subscribeConfiguredNameState,
            accessory::unsubscribeConfiguredNameState),
        new RemoteKeyCharacteristic(accessory::setRemoteKey),
        new SleepDiscoveryModeCharacteristic(
            accessory::getSleepDiscoveryMode,
            accessory::subscribeSleepDiscoveryModeState,
            accessory::unsubscribeSleepDiscoveryModeState));
    if (accessory instanceof AccessoryWithBrightness) {
      addOptionalCharacteristic(
          new BrightnessCharacteristic(
              ((AccessoryWithBrightness) accessory)::getBrightness,
              ((AccessoryWithBrightness) accessory)::setBrightness,
              ((AccessoryWithBrightness) accessory)::subscribeBrightness,
              ((AccessoryWithBrightness) accessory)::unsubscribeBrightness));
    }
  }

  public void addOptionalCharacteristic(Characteristic name) {
    addCharacteristic(name);
  }
}

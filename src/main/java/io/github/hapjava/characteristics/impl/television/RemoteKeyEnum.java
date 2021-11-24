package io.github.hapjava.characteristics.impl.television;

import io.github.hapjava.characteristics.CharacteristicEnum;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum RemoteKeyEnum implements CharacteristicEnum {
  REWIND(0),
  FASTFORWARD(1),
  NEXTTRACK(2),
  PREVTRACK(3),
  ARROWUP(4),
  ARROWDOWN(5),
  ARROWLEFT(6),
  ARROWRIGHT(7),
  SELECT(8),
  BACK(9),
  EXIT(10),
  PLAYPAUSE(11),
  INFO(15);

  private static final Map<Integer, RemoteKeyEnum> reverse;

  static {
    reverse =
        Arrays.stream(RemoteKeyEnum.values())
            .collect(Collectors.toMap(RemoteKeyEnum::getCode, t -> t));
  }

  public static RemoteKeyEnum fromCode(Integer code) {
    return reverse.get(code);
  }

  private final int code;

  RemoteKeyEnum(int code) {
    this.code = code;
  }

  @Override
  public int getCode() {
    return code;
  }
}

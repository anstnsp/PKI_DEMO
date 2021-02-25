package com.aton.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * 국적 정보
 * </pre>
 */
@Getter
@RequiredArgsConstructor
public enum NationalInfo implements UCPIDEnumType {
  UNKNOWN(-1),
  /**
   * 내국인: 0
   */
  RESIDENT(0),
  /**
   * 외국인: 1
   */
  FOREIGNER(1);


  private final int code;


  public static NationalInfo fromInt(int code) {
    switch (code) {
      case 0: return RESIDENT;
      case 1: return FOREIGNER;
      default: return UNKNOWN;
    }
  }
}

package com.aton.message.common.code;

import java.math.BigInteger;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UCPIDCommonErrorCode implements UCPIDErrorCode {
    UNKNOWN("-1", "Unknown Exception");
  
    private final String code;
    private final String msg;


    @Override
    public int getCodeAsInt() {
      return BigInteger.valueOf(Long.parseLong(getCode())).intValue();
    }



}
  
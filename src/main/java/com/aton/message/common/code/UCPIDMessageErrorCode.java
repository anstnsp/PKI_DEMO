package com.aton.message.common.code;

import java.math.BigInteger;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UCPIDMessageErrorCode implements UCPIDErrorCode {
  UNKNOWN_STATUS_CODE("3333", "invalid status code"),

  MESSAGE_ENCODE_ERROR("1234", ""),
  MESSAGE_DECODE_ERROR("1234", ""),

  INVALID_MESSAGE_DATA("100000", "데이터가 올바르지 않습니다"),
  UNKNOWN_MESSAGE_TYPE("100100", "알 수 없는 메시지 형식"),

  MESSAGE_ISSUERKEYHASH_CERT_NULL("100210", "issuer 키해시용 인증서가 null 입니다"),
  MESSAGE_CAKEYHASH_CERT_NULL("100211", "ca 키해시용 인증서가 null 입니다"),

  USER_AGREEMENT_EMPTY("100200", "본인확인 사용자 약관 내용이 없습니다"),
  USER_AGREE_NOTHING("100201", "본인확인 사용자 동의 항목이 없습니다"),
  USER_SIGN_TEXT_EMPTY("100203", "본인확인 사용자 서명 메시지 내용이 없습니다"),

  INVALID_USER_SIGN_TEXT("100301", "본인확인 사용자 서명 메시지 인코딩이 올바르지 않습니다"),
  INVALID_USER_PUBLIC_CERT("100300", "본인확인 사용자 인증서가 올바르지 않습니다");


  private final String code;
  private final String msg;


  @Override
  public int getCodeAsInt() {
    return BigInteger.valueOf(Long.parseLong(getCode())).intValue();


  }

}
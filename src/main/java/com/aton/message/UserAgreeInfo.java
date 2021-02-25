package com.aton.message;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.DERBitString;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 동의 항목
 */
@Getter
@RequiredArgsConstructor
public enum UserAgreeInfo implements UCPIDEnumType {

  /**
   * 실명: 0
   */
  realName(0),

  /**
   * 성별: 1
   */
  gender(1),

  /**
   * 국적: 2
   */
  nationalInfo(2),

  /**
   * 생년월일: 3
   */
  birthDate(3);


  private final int code;

  public static ASN1BitString toBitString(final int[] userAgreeInfos) {
    
    byte userAgreeInfo = (byte) (
        (byte) userAgreeInfos[UserAgreeInfo.realName.getCode()] << 0 |
        ((byte) userAgreeInfos[UserAgreeInfo.gender.getCode()]) << 1 |
        ((byte) userAgreeInfos[UserAgreeInfo.nationalInfo.getCode()]) << 2 |
        ((byte) userAgreeInfos[UserAgreeInfo.birthDate.getCode()]) << 3);


    byte[] fromUserAgreeInfo = new byte[]{userAgreeInfo};

    ASN1BitString bitString  = new DERBitString(fromUserAgreeInfo);
    return bitString;
  }
}

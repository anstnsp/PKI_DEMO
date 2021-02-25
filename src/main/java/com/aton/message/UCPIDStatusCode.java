package com.aton.message;


import com.aton.message.common.code.UCPIDMessageErrorCode;
import com.aton.message.common.exception.UCPIDMessageException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.DERBitString;

/**
 * <pre>
 * UPCID 응답 상태코드
 *
 * 성공: okay(0)
 * 실패: okay(0)이 아닌 경우
 *
 * max: 42 bit string
 * </pre>
 */
@Getter
@RequiredArgsConstructor
public enum UCPIDStatusCode implements UCPIDEnumType {
  /**
   * 0
   */
  okay(0),
  /**
   * 1
   */
  badRequest(1),
  /**
   * 2
   */
  tooBusy(2),
  /**
   * 3
   */
  undefined(3),
  /**
   * 20
   */
  badStructure(20),
  /**
   * 21
   */
  unsupportedVersion(21),
  /**
   * 22
   */
  unableToDecode(22),
  /**
   * 30
   */
  badSignature(30),
  /**
   * 31
   */
  notAuthorized(31),
  /**
   * 32
   */
  unsupportedSignature(32),
  /**
   * 33
   */
  invalidSignature(33),
  /**
   * 40
   */
  systemFailure(40),
  /**
   * 41
   */
  invalidCertificate(41);

  private final int code;

  public static ASN1BitString toBitString(final UCPIDStatusCode ucpidStatusCode) {
    return new DERBitString(ucpidStatusCode.getCode()); 
  }

  public static UCPIDStatusCode getStatusCodeFromBitString(ASN1BitString bitString) {
    for (UCPIDStatusCode ucpidStatusCode : UCPIDStatusCode.values()) {
      if (bitString.intValue() == ucpidStatusCode.getCode()) {
        return ucpidStatusCode;
      }
    }
    throw new UCPIDMessageException(UCPIDMessageErrorCode.UNKNOWN_STATUS_CODE);
  }

}

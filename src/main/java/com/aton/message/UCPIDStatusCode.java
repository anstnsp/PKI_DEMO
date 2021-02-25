package com.aton.message;///*
// * =============================================================================
// *
// * Copyright (c) 2017 INITECH Company co,.LTD
// *
// * AG CA UCPID Service
// *
// * =============================================================================
// */
//
//package com.aton.message.common;
//
//
//import com.aton.message.common.code.UCPIDMessageErrorCode;
//import com.aton.message.common.exception.UCPIDMessageException;
//import lombok.Getter;
//import org.bouncycastle.asn1.ASN1BitString;
//
///**
// * <pre>
// * UPCID 응답 상태코드
// *
// * 성공: okay(0)
// * 실패: okay(0)이 아닌 경우
// *
// * max: 42 bit string
// * </pre>
// */
//public enum UCPIDStatusCode implements UCPIDEnumType {
//  /**
//   * 0
//   */
//  okay(0),
//  /**
//   * 1
//   */
//  badRequest(1),
//  /**
//   * 2
//   */
//  tooBusy(2),
//  /**
//   * 3
//   */
//  undefined(3),
//  /**
//   * 20
//   */
//  badStructure(20),
//  /**
//   * 21
//   */
//  unsupportedVersion(21),
//  /**
//   * 22
//   */
//  unableToDecode(22),
//  /**
//   * 30
//   */
//  badSignature(30),
//  /**
//   * 31
//   */
//  notAuthorized(31),
//  /**
//   * 32
//   */
//  unsupportedSignature(32),
//  /**
//   * 33
//   */
//  invalidSignature(33),
//  /**
//   * 40
//   */
//  systemFailure(40),
//  /**
//   * 41
//   */
//  invalidCertificate(41);
//
//  @Getter
//  private final int code;
//
//  UCPIDStatusCode(final int code) {
//    this.code = code;
//  }
//
//  public static ASN1BitString toBitString(final UCPIDStatusCode ucpidStatusCode) {
//    boolean[] bools = new boolean[ucpidStatusCode.getCode() + 1];
//
//    bools[ucpidStatusCode.getCode()] = true;
//
//    return new ASN1BitString(bools);
//  }
//
//  public static UCPIDStatusCode getStatusCodeFromBools(final boolean[] data) {
//    for (int idx = 0; idx < data.length; idx++) {
//      if (data[idx]) {
//        for (UCPIDStatusCode ucpidStatusCode : UCPIDStatusCode.values()) {
//          if (idx == ucpidStatusCode.getCode()) {
//            return ucpidStatusCode;
//          }
//        }
//        break;
//      }
//    }
//
//    throw new UCPIDMessageException(UCPIDMessageErrorCode.UNKNOWN_STATUS_CODE);
//  }
//}

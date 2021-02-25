package com.aton.message.request;

import java.io.IOException;

import com.aton.message.UserAgreeInfo;
import com.aton.message.utils.Util;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonInfoReq implements ASN1Encodable {
    
    /**
     * 개인정보제공 및 활용동의 약관
     */
    private DERUTF8String userAgreement; 
    /**
     * ISP에서 필요로 하는 개인정보 항목 중 사용자 동의 항목
     */
    private ASN1BitString userAgreeInfo; 

    public PersonInfoReq(String userAgreement, boolean isAgreeRealName, 
    boolean isAgreeGender, boolean isAgreeNtionalInfo, boolean isAgreeBirthDate) {
      int[] agreeArr = new int[4]; 
      agreeArr[0] = Util.convertBooleanToZeroOne(isAgreeRealName); 
      agreeArr[1] = Util.convertBooleanToZeroOne(isAgreeGender); 
      agreeArr[2] = Util.convertBooleanToZeroOne(isAgreeNtionalInfo); 
      agreeArr[3] = Util.convertBooleanToZeroOne(isAgreeBirthDate);

      this.userAgreeInfo = UserAgreeInfo.toBitString(agreeArr);
      this.userAgreement = new DERUTF8String(userAgreement); 

    }

    public String toHexSting() throws IOException {
      ASN1EncodableVector storage = new ASN1EncodableVector();
      storage.add(this.userAgreement);
      storage.add(userAgreeInfo);

      ASN1Sequence sequence = new DERSequence(storage);
      
      byte[] personInfoReqBinary = sequence.getEncoded();
      String PersonInfoHexStr = Util.byteArrayToHexString(personInfoReqBinary);

      return PersonInfoHexStr;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {

        return null;
    }

}

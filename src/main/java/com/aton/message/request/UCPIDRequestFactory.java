package com.aton.message.request;

import java.io.IOException;

import com.aton.message.UserAgreeInfo;
import com.aton.message.request.PersonInfoReq;
import com.aton.message.utils.Util;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class UCPIDRequestFactory {

    /**
     * 
     * @param userAgreement       개인정보제공 및 활용동의 약관
     * @param isAgreeRealName     실제이름동의여부
     * @param isAgreeGender       성별동의여부
     * @param isAgreeNtionalInfo  국적동의여부
     * @param isAgreeBirthDate    생일동의여부
     * @return 개인정보동의활용 요청 메세지
     * @throws IOException
     */
    public static synchronized String createPersonInfoReq(String userAgreement, boolean isAgreeRealName, 
                        boolean isAgreeGender, boolean isAgreeNtionalInfo, boolean isAgreeBirthDate) throws IOException {
        PersonInfoReq personInfoReq = new PersonInfoReq(userAgreement, isAgreeRealName, 
                                                isAgreeGender, isAgreeNtionalInfo, isAgreeBirthDate);
        String PersonInfoHexStr = personInfoReq.toHexSting();
        return PersonInfoHexStr;


        // int[] agreeArr = new int[4]; 
        // agreeArr[0] = Util.convertBooleanToZeroOne(isAgreeRealName); 
        // agreeArr[1] = Util.convertBooleanToZeroOne(isAgreeGender); 
        // agreeArr[2] = Util.convertBooleanToZeroOne(isAgreeNtionalInfo); 
        // agreeArr[3] = Util.convertBooleanToZeroOne(isAgreeBirthDate);

        // ASN1Primitive derUtf8String = new DERUTF8String(userAgreement);
        // ASN1BitString bitString = UserAgreeInfo.toBitString(agreeArr);
        // ASN1EncodableVector storage = new ASN1EncodableVector();
        // storage.add(derUtf8String);
        // storage.add(bitString);

        // ASN1Sequence sequence = new DERSequence(storage);
        
        // byte[] personInfoReqBinary = sequence.getEncoded();
        // String PersonInfoHexStr = Util.byteArrayToHexString(personInfoReqBinary);

        // return PersonInfoHexStr;

    }


}

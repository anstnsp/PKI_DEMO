package com.aton.message.request;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;

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
    private String userAgreement; 
    /**
     * ISP에서 필요로 하는 개인정보 항목 중 사용자 동의 항목
     */
    private ASN1BitString userAgreeInfo; 
    /**
     * 실명 제공 동의 여부
     */
    private int agreeRealName; 
    /**
     * 성별 제공 동의 여부
     */
    private int agreeGender; 
    /**
     * 국적 제공 동의 여부
     */    
    private int agreeNationalInfo; 
    /**
     * 생일 제공 동의 여부
     */   
    private int agreeBirthDate; 


    @Override
    public ASN1Primitive toASN1Primitive() {

        return null;
    }
    
}

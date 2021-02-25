import java.io.IOException;

import com.aton.message.UCPIDStatusCode;
import com.aton.message.request.PersonInfoReq;
import com.aton.message.request.UCPIDRequestFactory;

import org.bouncycastle.asn1.DERBitString;

public class Main {

    public static void main(String[] args) throws IOException {
        String message = "이용약관";
        // int[] arr = { 1, 1, 1, 1 };
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = true;
        String str = UCPIDRequestFactory.createPersonInfoReq(message, a,b,c,d);
        
        System.out.println(str);
        
        UCPIDStatusCode code = UCPIDStatusCode.getStatusCodeFromBitString(new DERBitString(41));
        System.out.println("code : " + code);
    }


    /**
     * new DERBitString(15) -> #0302000F
     * new DERBitString(15).intValue() -> 15 
     */

		
}



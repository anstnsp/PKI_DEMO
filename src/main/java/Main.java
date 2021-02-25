import java.io.IOException;
import com.aton.message.service.UCPID;

public class Main {

    public static void main(String[] args) throws IOException {
        String message = "이용약관";
        // int[] arr = { 1, 1, 1, 1 };
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = true;
        String str = UCPID.makePersonInfoReq(message, a,b,c,d);

        System.out.println(str);

    }



		
}



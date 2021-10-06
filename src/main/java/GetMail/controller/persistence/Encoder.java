package GetMail.controller.persistence;

import java.util.Base64;

public class Encoder {

    private static final Base64.Encoder enc = Base64.getEncoder();
    private static final Base64.Decoder dec = Base64.getDecoder();

    public String encode(String text){
        try{
            return enc.encodeToString(text.getBytes());
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String decode(String text){
        try{
            return new String(dec.decode(text.getBytes()));
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
package org.bharath.utils;

import java.util.Arrays;
import java.util.Base64;

public final class DecodeUtils {

    private DecodeUtils(){}

    public static String getDecodedString(String encodedString){
        return Arrays.toString(Base64.getDecoder().decode(encodedString));
    }


}

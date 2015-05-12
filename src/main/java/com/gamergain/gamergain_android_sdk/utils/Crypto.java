package com.gamergain.gamergain_android_sdk.utils;

import android.util.Log;

import java.math.BigInteger;
import java.security.MessageDigest;


public abstract class Crypto {

    public static String sha1(String input) {
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            messagedigest.update(input.getBytes());
            BigInteger hash = new BigInteger(1, messagedigest.digest());
            String HashPassString = hash.toString(16);
            if ((HashPassString.length() % 2) != 0) {
                HashPassString = "0" + HashPassString;
            }

            return HashPassString;
        } catch (Exception e) {
            Log.v("GENERATE_HASH_FAIL", "GenerateHashFail");
            return "";
        }
    }

}

package com.wonbeomjang.bookselling.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class SHA256 {
    public static String encryption(String msg) {
        MessageDigest sh = null;
        try {
            sh = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Objects.requireNonNull(sh).update(msg.getBytes());

        byte[] byteData = sh.digest();
        StringBuilder sb = new StringBuilder();

        for (byte byteDatum : byteData) {
            sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();


    }
}

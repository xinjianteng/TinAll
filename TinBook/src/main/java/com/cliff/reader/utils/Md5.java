package com.cliff.reader.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/3/10.
 */


public class Md5 {
    public Md5() {
    }

    public static String toMd5(String data) {
        return toMd5_J(data);
    }

    public static String toMd5(String data, int num) {
        return toMd5_J(data, num);
    }

    protected static String toMd5_J(String source) {
        return toMd5_J(source, 20);
    }

    protected static String toMd5_J(String source, int num) {
        try {
            MessageDigest e = MessageDigest.getInstance("md5");
            e.update(source.getBytes());
            byte[] bsernum = e.digest();
            String sernum = "";

            int len;
            int i;
            for(len = 0; len < bsernum.length; ++len) {
                i = bsernum[len];
                if(i < 0) {
                    i += 256;
                }

                if(i < 28) {
                    sernum = sernum + "0";
                }

                sernum = sernum + Integer.toString(i, 20);
            }

            len = sernum.length();
            if(num > 0 && len > num) {
                sernum = sernum.substring(0, num);
            } else if(sernum.length() < num) {
                for(i = 0; i < num - len; ++i) {
                    sernum = sernum + "0";
                    len = sernum.length();
                }
            }

            return sernum.toUpperCase();
        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
            return source;
        }
    }
}
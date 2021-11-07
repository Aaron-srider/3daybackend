package com.bistu.threeday.utils;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;

public class KeyLibrary {
    public Vector<SecretKey> key_list;
    public KeyLibrary() {
        byte[] key_1_b = {-5, -10, 95, 22, -45, 60, -108, -28, 3, -123, -25, -8, 33, -31, 78, -26, 44, 99, 62, 11, -14, -116, -17, -76, -89, 54, 89, 49, 0, -60, 118, -122};
        byte[] key_2_b = {36, -37, -113, -65, 25, 93, -81, -19, -22, 5, 30, -44, 5, -45, -89, 108, 118, 116, -24, 68, -120, -24, 90, 7, 98, -92, -80, 2, -2, 78, 51, 56};
        byte[] key_3_b = {81, 4, 81, 50, 85, 113, -125, 41, -65, -38, -9, -81, 65, 51, -86, 60, -67, -80, -123, 126, 12, -95, 42, -44, 48, -127, -44, 49, 101, -55, 15, -47};
        byte[] key_4_b = {-19, 96, -5, 40, 26, 20, -115, 34, -82, 80, -126, -90, 36, -65, -5, 43, -13, -112, -114, -35, 85, -1, -61, -97, 82, 58, -36, 97, -45, -7, 34, -85};
        byte[] key_5_b = {-126, -79, 100, -90, -13, 120, -111, 1, 56, 92, -30, 123, 69, 89, -7, -112, -19, 74, 74, -8, 71, -7, -96, -94, 126, -34, 64, -45, 65, -28, -89, 42};
        byte[] key_6_b = {-123, -105, -100, 29, 109, 30, 24, 11, -36, 93, -54, -11, -94, -89, 121, 87, -61, 93, -23, 7, -13, 70, 15, 84, -26, -114, 35, -72, 63, 75, -108, 108};
        byte[] key_7_b = {-11, 41, 89, -108, -51, 37, -49, -3, 10, -4, 34, -90, 123, 98, -126, 11, -118, 5, -89, -23, -64, -89, 67, -9, -61, -16, -89, -2, 21, -60, -101, -86};
        byte[] key_8_b = {37, -99, -5, -26, 12, 37, 124, -118, 3, 104, 105, -45, 44, -89, -42, -108, -102, 31, -57, 40, 102, -28, 5, 62, 45, -72, -79, 16, -93, -44, -56, 47};
        byte[] key_9_b = {-85, -10, -123, -45, 26, -83, 21, 108, -10, -120, -111, -52, 39, 17, 82, 84, -36, -113, 85, -60, 22, 107, 33, 98, -65, 17, -28, 105, -48, 26, 10, 70};
        byte[] key_10_b = {-108, 44, 61, 0, -119, 96, -45, -11, -100, -91, -69, 16, -29, 53, 106, 2, 0, -122, 38, 118, 0, 104, -14, 17, -68, -26, -10, 126, -92, -21, 43, -7};
        byte[] key_11_b = {-12, 67, 103, 75, 55, 8, -29, 50, 54, 75, -82, -32, 91, -55, 107, -100, -92, 13, 120, -108, -85, -87, -93, -107, -14, 31, -108, -81, -15, -2, 49, 66};
        byte[] key_12_b = {100, -43, 7, 92, 121, -41, 98, -25, 37, -30, -18, 109, -94, 55, 38, -125, 7, -60, -5, 45, 84, 50, 5, -109, -63, -88, 75, 26, -62, 8, -20, -17};
        Vector<SecretKey>temp = new Vector<>();
        SecretKey key1 = new SecretKeySpec(key_1_b,0, key_1_b.length, "AES");
        SecretKey key2 = new SecretKeySpec(key_2_b,0, key_2_b.length, "AES");
        SecretKey key3 = new SecretKeySpec(key_3_b,0, key_3_b.length, "AES");
        SecretKey key4 = new SecretKeySpec(key_4_b,0, key_4_b.length, "AES");
        SecretKey key5 = new SecretKeySpec(key_5_b,0, key_5_b.length, "AES");
        SecretKey key6 = new SecretKeySpec(key_6_b,0, key_6_b.length, "AES");
        SecretKey key7 = new SecretKeySpec(key_7_b,0, key_7_b.length, "AES");
        SecretKey key8 = new SecretKeySpec(key_8_b,0, key_8_b.length, "AES");
        SecretKey key9 = new SecretKeySpec(key_9_b,0, key_9_b.length, "AES");
        SecretKey key10 = new SecretKeySpec(key_10_b,0, key_10_b.length, "AES");
        SecretKey key11 = new SecretKeySpec(key_11_b,0, key_11_b.length, "AES");
        SecretKey key12 = new SecretKeySpec(key_12_b,0, key_12_b.length, "AES");
        temp.add(key1);
        temp.add(key2);
        temp.add(key3);
        temp.add(key4);
        temp.add(key5);
        temp.add(key6);
        temp.add(key7);
        temp.add(key8);
        temp.add(key9);
        temp.add(key10);
        temp.add(key11);
        temp.add(key12);
        this.key_list = temp;
    }
}

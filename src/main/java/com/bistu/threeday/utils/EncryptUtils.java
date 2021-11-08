package com.bistu.threeday.utils;

import javax.crypto.Cipher;
import java.util.Arrays;

public class EncryptUtils {
    public static void main(String[] args) throws Exception{
        test1();
    }

    public static void test() throws Exception{
        String name = "运动员名字A";
        System.out.println("原始数据: "+name);
        //密钥库
        KeyLibrary library = new KeyLibrary();
        //取钥匙加密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");;
        cipher.init(Cipher.ENCRYPT_MODE,library.key_list.get(0));
        byte[] encrypts = cipher.doFinal(name.getBytes());
        //把Arrays.toString(encrypts)存入数据库，以String类型
        System.out.println("加密结果: " + encrypts.length + ":" + Arrays.toString(encrypts));
        //取出Arrays.toString(encrypts)后解密
        cipher.init(Cipher.DECRYPT_MODE, library.key_list.get(0));
        byte[] decrypts = cipher.doFinal(encrypts);
        String name_ = new String(decrypts);
        System.out.println("解密结果: "+name_);
    }

    public static  void test1() throws Exception {
        String name = "运动员名字A";
        System.out.println("原始数据: "+name);
        byte[] encrypts = encrypt(name);
        //把Arrays.toString(encrypts)存入数据库，以String类型
        System.out.println("加密结果: " + encrypts.length + ":" + Arrays.toString(encrypts));
        //取出Arrays.toString(encrypts)后解密
        String name_ = decrypt(encrypts);
        System.out.println("解密结果: "+name_);
    }


    /**
     * 加密字符串成32位的byte[]（二进制）
     * @param decrypts 待加密字符串
     * @return 二进制密文（byte[]）
     */
    public static byte[] encrypt(String decrypts) throws Exception{
        if(decrypts == null){
            return null;
        }
        //密钥库
        KeyLibrary library = new KeyLibrary();
        //取钥匙加密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");;
        cipher.init(Cipher.ENCRYPT_MODE,library.key_list.get(0));
        return cipher.doFinal(decrypts.getBytes());
    }

    /**
     * 将32位的字节数组（二进制）解密成字符串明文
     * @param encrypts 待解密二进制数据（byte数组）
     * @return 字符串明文
     */
    public static String decrypt(byte[] encrypts) throws Exception{

        if(encrypts == null){
            return null;
        }
        //密钥库
        KeyLibrary library = new KeyLibrary();
        //取钥匙加密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");;
        cipher.init(Cipher.DECRYPT_MODE, library.key_list.get(0));
        byte[] decrypts = cipher.doFinal(encrypts);
        return new String(decrypts);
    }
}

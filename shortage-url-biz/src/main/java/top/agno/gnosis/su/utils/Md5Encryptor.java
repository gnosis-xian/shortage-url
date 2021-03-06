package top.agno.gnosis.su.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * 
 * @author hanxiaoqiang
 * @version $Id: Md5Encryptor.java, v 0.1 2015年11月10日 下午1:04:45 hanxiaoqiang Exp $
 */
public class Md5Encryptor {

    private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f"   };
    
    
    private static final String[] hexDigitsDX = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F"   };

    public static String encrypt(String originalStr) {
        String resultString = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(originalStr.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return resultString;
    }
    public static String encryptDX(String originalStr) {
        String resultString = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexDXString(md.digest(originalStr.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return resultString;
    }
    /**
     * Transfer byte array to HEX string
     *
     * @param b
     *            byte array
     * @return HEX string
     */

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }
    /**
     * transfer the result of md5 to upper case
     * modify by liujun
     * @param b
     * @return
     */
    private static String byteArrayToHexDXString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexDXString(b[i]));
        }
        return resultSb.toString();
    }
    /**
     * Transfer byte to HEX string
     *
     * @param b byte
     * @return HEX string
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
    
    private static String byteToHexDXString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigitsDX[d1] + hexDigitsDX[d2];
    }

    public static void main(String[] args) {
        String aa = "_input_charset=utf-8&body=2015-09-18 14:36:26&it_b_pay=1d&notify_url=http://10.0.0.28:8080&out_trade_no=45&partner=2088701958015370&payment_type=1&return_url=http://10.0.0.28:8080&seller_id=2088701958015370&service=alipay.wap.create.direct.pay.by.user&show_url=http://10.0.0.28:8080/dishes/detail/77&subject=佛跳墙&total_fee=20.0wpyvctlp9fhi5x9p4fqwrmcjtqdw05db";
        System.out.println(Md5Encryptor.encrypt(Md5Encryptor.encryptDX("smp123")));
    }
}

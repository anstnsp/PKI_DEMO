package com.aton.message.utils;

public class Util {

    //공통으로 쓰일 정적클래스로써 생성자 생성 x 
    private Util(){}; 



    /**
     * 헥사스트링을 바이트배열로 바꾼다.
     * @param s 바이트배열로 바꿀 스트링 값.
     * @return 헥사스트링을 바이트 배열로 바꾼 값.
     */
    public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	/**
     * 바이트배열을 헥사스트링으로 바꾼다. 
     * @param bytes 헥사스트링으로 바꾸고자 하는 바이트배열
     * @return 바이트배열을 헥사스트링으로 바꾼 값.
     */
	public static String byteArrayToHexString(byte[] bytes){ 
		
		StringBuilder sb = new StringBuilder(); 
		
		for(byte b : bytes){ 
			
			sb.append(String.format("%02X", b&0xff)); 
		} 
		
		return sb.toString(); 
	} 

    /**
     * true -> 1, false -> 0으로 바꾼다.
     * @param val ture/false
     * @return 1/0
     */
    public static int convertBooleanToZeroOne(boolean val) {
        return val ? 1 : 0; 
    }
}

package com.kragy.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtil {
    
    private static final String[] DIGIT_PINYIN = {"L", "Y", "E", "S", "S", "W", "L", "Q", "B", "J"};
    
    public static String getFirstLetter(String chinese) {
        if (chinese == null || chinese.trim().isEmpty()) {
            return null;
        }
        
        String cleaned = cleanString(chinese);
        
        if (cleaned.isEmpty()) {
            return null;
        }
        
        char firstChar = cleaned.charAt(0);
        
        if (firstChar >= '0' && firstChar <= '9') {
            return DIGIT_PINYIN[firstChar - '0'];
        }
        
        if ((firstChar >= 'a' && firstChar <= 'z') || (firstChar >= 'A' && firstChar <= 'Z')) {
            return String.valueOf(firstChar).toUpperCase();
        }
        
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        
        try {
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(firstChar, format);
            if (pinyinArray != null && pinyinArray.length > 0) {
                return String.valueOf(pinyinArray[0].charAt(0));
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private static String cleanString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c) || isChineseCharacter(c)) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    private static boolean isChineseCharacter(char c) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
        return block == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || block == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || block == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A;
    }
}

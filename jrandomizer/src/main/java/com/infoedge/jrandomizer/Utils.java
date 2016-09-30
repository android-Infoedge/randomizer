package com.infoedge.jrandomizer;

/**
 * Created by gagandeep on 31/7/16.
 */

public final class Utils {

    private Utils() {
    }

    public static int randomIntWithDigits(int digits) {
        int max = (int) Math.pow(10, digits) + 1;
        return randomIntWithMinMax(0, max);
    }

    public static int randomIntWithMax(int max) {
        return randomIntWithMinMax(0, max);
    }

    public static int randomIntWithMinMax(int min, int max) {
        return (int) (min + (Math.random() * (max - min + 1)));
    }

    public static long randomLongWithMinMax(long min, long max) {
        return (long) (min + (Math.random() * (max - min + 1)));
    }

    public static String randomHexOfInt(int min, int max) {
        int randomInt = randomIntWithMinMax(min, max);
        return Integer.toHexString(randomInt);
    }

    public static String randomHexOfInt(int max) {
        int randomInt = randomIntWithMinMax(0, max);
        return Integer.toHexString(randomInt);
    }

    public static String randomHexOfLong(long max) {
        long randomInt = randomLongWithMinMax(0, max);
        return Long.toHexString(randomInt);
    }

    public static String frontZeroPaddedRandomInt(int digits) {
        String randomInt = String.valueOf(randomIntWithDigits(digits));
        return frontPad(randomInt, "0", digits);
    }

    public static String frontPad(String target,String padChar, int length) {
        if (length == 0 || target.length() >= length) {
            return target;
        }
        return frontPad(padChar + target, padChar, length - 1);
    }

    public static String tailPad(String target,String padChar, int length) {
        if (length == 0 || target.length() >= length) {
            return target;
        }
        return tailPad(target + padChar, padChar, length);
    }
}

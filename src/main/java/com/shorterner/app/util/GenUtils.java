package com.shorterner.app.util;

import org.apache.commons.lang3.RandomStringUtils;

public class GenUtils {

    public static String generateCode() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

}

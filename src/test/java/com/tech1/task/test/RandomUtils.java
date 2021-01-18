package com.tech1.task.test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings({"rawtypes", "unchecked"})
public class RandomUtils {
    private static Random rnd = ThreadLocalRandom.current();


    private RandomUtils() {
    }

    public static <T extends Enum> T randomEnum(Class<?> enumClazz) {
        Object[] values = enumClazz.getEnumConstants();
        return (T) values[rnd.nextInt(values.length)];
    }
}

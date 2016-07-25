package com.andrey.englishcard.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by andrey on 22.07.16.
 */
public class DictionaryStorage {
    private DictionaryStorage() {
    }

    private static List<Pair<String, String>> d;

    public static Pair<String, String> getWord() {
        Random r = new Random();
        return d.get(r.nextInt(d.size()));
    }

    public static void putAll(List<Pair<String, String>> source) {
        d = new ArrayList<>(source);
    }
}

package com.andrey.englishcard.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.andrey.englishcard.utils.Pair.pair;

/**
 * Created by andrey on 22.07.16.
 */
public class Dictionary {
    private Dictionary() {
    }

    private static List<Pair<String, String>> d;

    static {
        d = new ArrayList<>();
        d.add(pair("bumped", "нактнуться"));
        d.add(pair("estate", "поместье"));
        d.add(pair("resist", "сопротивляться"));
        d.add(pair("prospect", "перспектива"));
        d.add(pair("tenant", "арендатор"));
        d.add(pair("harsh", "суровый"));
        d.add(pair("plump", "жирный"));
        d.add(pair("pond", "пруд"));
    }

    public static Pair<String, String> getWord() {
        Random r = new Random();
        return d.get(r.nextInt(d.size()));
    }
}

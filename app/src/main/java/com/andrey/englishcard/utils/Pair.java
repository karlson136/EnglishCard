package com.andrey.englishcard.utils;

/**
 * Created by andrey on 22.07.16.
 */
public class Pair<T, U> {
    private final T english;
    private final U russian;

    // serialization purpose
    public Pair() {
        english = null;
        russian = null;
    }

    public Pair(T key, U value) {
        this.english = key;
        this.russian = value;
    }

    public static <T, U> Pair<T, U> pair(T english, U russian) {
        return new Pair<T, U>(english, russian);
    }

    public T getEnglish() {
        return english;
    }

    public U getRussian() {
        return russian;
    }
}
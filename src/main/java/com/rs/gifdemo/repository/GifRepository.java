package com.rs.gifdemo.repository;

import com.rs.gifdemo.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class GifRepository {

    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "mols", true),
            new Gif("ben-and-mike", "mika", true),
            new Gif("book-dominos", "mem", false),
            new Gif("compiler-bot", "bot", true),
            new Gif("cowboy-coder", "code", false),
            new Gif("infinite-andrew", "andrew", true));

    public static List<Gif> getGifs() {
        return ALL_GIFS;
    }

    public List<Gif> getFavoritesGifs() {
        List<Gif> favorites = new ArrayList<>();
        for (int i = 0; i < ALL_GIFS.size(); i++) {
            if (ALL_GIFS.get(i).getFavorite()) {
                favorites.add(ALL_GIFS.get(i));
            }
        }
        return favorites;
    }

    public Gif getGifByName(String name) {

        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }
}
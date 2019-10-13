package com.rs.gifdemo.controller;

import com.rs.gifdemo.model.Gif;
import com.rs.gifdemo.repository.GifRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.rs.gifdemo.repository.GifRepository.getGifs;

@Controller
@Getter
public class GifController {

    @Autowired //@Autowired robi wstrzykiwanie zależności
            GifRepository gifRepository;

    @GetMapping("/")
    public String listGifsHome(ModelMap modelMap) {
        // 1. Wyciąganie gifów
        // List<Gif> gifList = getAllGifs(); - to jest OK, ale nie do końca wg Spring'a
        List<Gif> gifList = gifRepository.getGifs();
        // 2. Przekazanie gifa do View
        modelMap.put("gifs", gifList);
        // 3. Zwracanie widoku
        return "home";
    }

    @ResponseBody
    @GetMapping("/test")
    public String listGifs() {
        return getGifs().toString();
    }

    /*@ResponseBody
    @GetMapping("/test1")
    public String listGif() {
        List<Gif> allGifs = getAllGifs();
        /*for (int i = 0; i < allGifs.size(); i++) {
        if (allGifs/get(i).getUsername().equals("mika")){
        return allGifs.get(i).toString();
        }
        }
        for (Gif g : allGifs) {
            if (g.getUsername().equals("mika")) {
                return g.toString();
            }
        }
        return null;
    }

    @ResponseBody
    @GetMapping("/test2")
    public String listGif2() {
        List<Gif> allGifs = getAllGifs();
        List<Gif> unfavorites = new ArrayList<>();

        for (Gif x : allGifs) {
            if (!x.getFavorite()) { // getFavorite() zwraca "true" lub "false".
                // false - nie wchodzę do środka pętli, true => wchodzę do pętli
                unfavorites.add(x);
            }
        }
        return unfavorites.toString();
    }*/
}

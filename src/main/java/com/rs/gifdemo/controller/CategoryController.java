package com.rs.gifdemo.controller;

import com.rs.gifdemo.model.Category;
import com.rs.gifdemo.model.Gif;
import com.rs.gifdemo.repository.CategoryRepository;
import com.rs.gifdemo.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    GifRepository gifRepository;

    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap) {
        // 1. Wyciąganie kategorii
        List<Category> categories = categoryRepository.getAllCategories();
        // 2. Przekazanie kategorii do View
        modelMap.put("categories", categories);
        // 3. Zwracanie widoku
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String getGifsByCategory(@PathVariable int id, ModelMap modelMap){
        // 1. Pobranie potrzebnych obiektów:
        // - pobieramy listę gifów należących do danej kategorii:
        List<Gif> gifList = gifRepository.getGifsByCategoryId(id);
        Category category = categoryRepository.getCategoryById(id);
        // 2. Przekazanie do View:
        modelMap.put("gifs", gifList);
        modelMap.put("category", category);
        // 3.
        return "category";
    }




}

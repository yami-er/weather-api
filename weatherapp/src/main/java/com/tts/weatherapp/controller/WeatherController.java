package com.tts.weatherapp.controller;

import java.util.List;

import com.tts.weatherapp.model.Request;
import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.model.ZipCode;
import com.tts.weatherapp.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public String getIndex(Model model) {
        List<ZipCode> zipCodeList = weatherService.getRecentSearches();
        model.addAttribute("request", new Request());
        model.addAttribute("zip_code", zipCodeList);
        return "index";
    }

    @PostMapping
    public String postIndex(Request request, Model model) {
        List<ZipCode> zipCodeList = weatherService.getRecentSearches();
        Response data = weatherService.getForecast(request.getZipCode());

        model.addAttribute("data", data);
        model.addAttribute("zip_codes", zipCodeList);
        return "index";
    }
}
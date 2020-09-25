package com.example.multipledb.controller;

import com.example.multipledb.dao.AdvertiserDAO;
import com.example.multipledb.dao.PublisherDAO;
import com.example.multipledb.entity1.Publisher;
import com.example.multipledb.entity2.Advertiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PublisherDAO publisherDAO;

    @Autowired
    private AdvertiserDAO advertiserDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {

        List<Advertiser> advertisers = advertiserDAO.listAdvertisers();
        List<Publisher> publishers = publisherDAO.listPublishers();

        model.addAttribute("advertisers", advertisers);
        model.addAttribute("publishers", publishers);

        return "home";
    }

}

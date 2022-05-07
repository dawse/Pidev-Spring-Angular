package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.GraphService;

@Controller
public class GraphController {
	@Autowired
	GraphService gservise;
	@GetMapping("/displayBarGraph")
	public String barGraph(Model model) {
		Map<String, Integer> surveyMap = new LinkedHashMap<>();
		surveyMap.put("publications", gservise.getNumberpub());
		surveyMap.put("commentaire", gservise.getNumberComment());
		surveyMap.put("Likes", gservise.getNumberLikes());
		surveyMap.put("dislike",gservise.getNumberDislike());
		model.addAttribute("surveyMap", surveyMap);
		return "barGraph";
	}

	@GetMapping("/displayPieChart")
	public String pieChart(Model model) {
		model.addAttribute("pass", 40);
		model.addAttribute("fail", 10);
		return "pieChart";
	}



}

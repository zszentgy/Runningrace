package com.runningrace.controller;

import com.runningrace.model.Race;
import com.runningrace.model.Result;
import com.runningrace.repository.RaceRepository;
import com.runningrace.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;

@Controller
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/races")
    public String listRaces(Model model) {
        List<Race> races = raceRepository.findAll();
        model.addAttribute("races", races);
        return "races"; // returns the view name 'races.html'
    }

    @GetMapping("/addRace")
    public String showAddRaceForm(Model model) {
        model.addAttribute("race", new Race());
        return "add-race";
    }

    @PostMapping("/addRace")
    public String addRace(@ModelAttribute Race race) {
        raceRepository.save(race);
        return "redirect:/races"; // Redirect to list of races to see the new race added
    }

    // Route to display race details and results
    @GetMapping("/races/{id}")
    public String raceDetails(@PathVariable Long id, Model model) {
        Optional<Race> race = raceRepository.findById(id);
        if (!race.isPresent()) {
            return "redirect:/races"; // or a "not found" page
        }

        List<Result> results = resultRepository.findByRaceId(id);
        model.addAttribute("race", race.get());
        model.addAttribute("results", results);
        return "race-details";
    }

}

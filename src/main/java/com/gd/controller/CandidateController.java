package com.gd.controller;

import com.gd.model.entity.Candidate;
import com.gd.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/candidates")
@RestController
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping
    public List<Candidate> findByKeyWord(@RequestParam String keyWord) {
        return candidateService.findCandidates(keyWord);
    }
}

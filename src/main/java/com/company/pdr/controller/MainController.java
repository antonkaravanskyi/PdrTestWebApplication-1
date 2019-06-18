package com.company.pdr.controller;

import com.company.pdr.domain.Task;
import com.company.pdr.domain.Test;
import com.company.pdr.repos.TaskRepo;
import com.company.pdr.repos.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private TaskRepo taskRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping("/tests")
    public String greeting(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/tests")
    public String main(Map<String, Object> model) {
        Iterable<Test> tests = testRepo.findAll();

        model.put("tests", tests);

        return "main";
    }

    @GetMapping("/tests/{testId}")
    public String getTests(@PathVariable("testId") Integer testId, Map<String, Object> model) {
        Test test = testRepo.findByTestId(testId).orElse(null);

        Iterable<Test> tests = testRepo.findAll();
        model.put("tests", tests);
        model.put("test", test);

        return "main";
    }

    /* in
     *[
     *  123 => 5,
     *  124 => 2,
     * ]
    */
    /* out
     * [
     *  123 => ["user" => 5, "right" => 2],
     *  124 => ["user" => 2, "right" => 3],
     * ]
     */
    @PostMapping("/tests/{testId}")
    public String checkTests(@PathVariable("testId") Integer testId, Map<String, Object> model) {
        Test test = testRepo.findByTestId(testId).orElse(null);

        Iterable<Test> tests = testRepo.findAll();
        model.put("tests", tests);
        model.put("test", test);

        return "main";
    }
}
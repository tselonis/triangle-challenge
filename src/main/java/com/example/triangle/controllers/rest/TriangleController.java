package com.example.triangle.controllers.rest;

import com.example.triangle.business.rest.facade.api.TriangleFacade;
import com.example.triangle.response.rest.TriangleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/triangle")
public class TriangleController {

    private TriangleFacade triangleFacade;

    @Autowired
    public TriangleController(TriangleFacade triangleFacade) {
        this.triangleFacade = triangleFacade;
    }

    @GetMapping(value = "/type/evaluate")
    public TriangleResponse evaluateType(
            @Positive @RequestParam("a") int a,
            @Positive @RequestParam("b") int b,
            @Positive @RequestParam("c") int c) {

        return triangleFacade.evaluateTriangle(a, b, c);
    }

}

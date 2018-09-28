package com.example.triangle.controllers.rest;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.triangle.business.rest.services.api.TriangleService;
import com.example.triangle.enums.TriangleType;
import com.example.triangle.response.rest.TriangleResponse;

@Validated
@RestController
@RequestMapping("/triangle")
public class TriangleController {

    private TriangleService triangleService;
    private MessageSource messageSource;

    @Autowired
    public TriangleController(TriangleService triangleService, MessageSource messageSource) {
        this.triangleService = triangleService;
        this.messageSource = messageSource;
    }

    @GetMapping(value = "/type/evaluate")
    public TriangleResponse evaluateType(
        @Positive(message = "{validation.positive}") @RequestParam("a") int a,
        @Positive(message = "{validation.positive}") @RequestParam("b") int b,
        @Positive(message = "{validation.positive}") @RequestParam("c") int c) {

        TriangleType evaluatedTriangle = triangleService.determineType(a, b, c);
        return new TriangleResponse(evaluatedTriangle.isTriangle(), messageSource.getMessage(evaluatedTriangle.getMessageKey(), null, LocaleContextHolder.getLocale()));
    }

}

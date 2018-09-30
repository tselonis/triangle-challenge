package com.example.triangle.web.controller

import org.springframework.context.MessageSource

import com.example.triangle.domain.enums.TriangleType
import com.example.triangle.service.api.TriangleService

import spock.lang.Specification

class TriangleControllerSpec extends Specification {

    TriangleService triangleService;
    MessageSource messageSource
    TriangleController controller

    def setup() {
        triangleService = Mock()
        messageSource = Mock()
        controller = new TriangleController(triangleService, messageSource)
    }

    def "Verify interactions when evaluate triangle type is requested"() {
        given: "Valid input parameters"
            int a = 1, b = 2, c = 3
            TriangleType type = TriangleType.NO_TRIANGLE
            String message = "No triangle"

        when: "Triangle type evaluation is requested"
            def response = controller.evaluateType(a, b, c)

        then: "Verify correct interactions"
            1 * triangleService.determineType(a, b, c) >> type
            1 *  messageSource.getMessage(type.getMessageKey(), null, _ as Locale) >> message

        and: "Verify the correct response"
            !response.isTriangle()
            response.getDescription() == message
    }
}

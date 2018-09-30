package com.example.triangle.web.handler

import javax.validation.ConstraintViolationException

import org.springframework.http.HttpStatus

import com.example.triangle.web.response.GeneralErrorResponse

import spock.lang.Specification

class GlobalExceptionHandlerSpec extends Specification {

    private static final String ERROR_MESSAGE = "Exception message"

    def "Should return correct error response"() {
        given: "A constraint violation exception"
            ConstraintViolationException exception = new ConstraintViolationException(ERROR_MESSAGE, [].toSet())
            GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler()

        when: "The handler is being triggered"
            GeneralErrorResponse errorResponse = globalExceptionHandler.handle(exception)

        then: "Creates the correct error response"
            errorResponse.getMessage().equals(ERROR_MESSAGE)
            errorResponse.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY.value()
    }
}

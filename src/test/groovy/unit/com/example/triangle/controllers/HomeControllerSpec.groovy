package com.example.triangle.controllers

import spock.lang.Specification

class HomeControllerSpec extends Specification {

    HomeController controller

    def setup() {
        controller = new HomeController()
    }

    def "Verify view is correct"() {
        expect:
            controller.home() == "home"
    }
}

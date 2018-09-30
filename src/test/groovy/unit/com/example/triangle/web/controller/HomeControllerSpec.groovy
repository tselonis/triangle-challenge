package com.example.triangle.web.controller

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

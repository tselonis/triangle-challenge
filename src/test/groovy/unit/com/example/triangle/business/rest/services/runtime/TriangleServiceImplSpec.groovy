package com.example.triangle.business.rest.services.runtime

import com.example.triangle.business.rest.services.api.TriangleService
import com.example.triangle.enums.TriangleType

import spock.lang.Specification
import spock.lang.Unroll

class TriangleServiceImplSpec extends Specification {

    TriangleService triangleService

    def setup() {
        triangleService = new TriangleServiceImpl()
    }

    @Unroll
    def "Verify the correct evaluation of the #triangleType"() {
        when: 'Triangle type evaluation is requested'
            def response = triangleService.determineType(a, b, c)

        then: 'Verify that the correct triangle type is returned'
            response == triangleType

        where:
            a | b | c | triangleType
            7 | 1 | 2 | TriangleType.NO_TRIANGLE
            1 | 1 | 1 | TriangleType.EQUILATERAL
            5 | 4 | 5 | TriangleType.ISOSCELES
            7 | 4 | 5 | TriangleType.SCALENE
    }
}

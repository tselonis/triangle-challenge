package unit.com.example.triangle.business.rest.services

import com.example.triangle.business.rest.services.api.TriangleService
import com.example.triangle.business.rest.services.runtime.TriangleServiceImpl
import com.example.triangle.enums.TriangleType
import spock.lang.Specification
import spock.lang.Unroll

class TriangleServiceImplSpec extends Specification {

    @Unroll
    def "Should correctly determine triangle type for #triangleType"() {
        given: "A service object"
        TriangleService triangleService = new TriangleServiceImpl()

        when: "Ask to determine triangle"
        TriangleType response = triangleService.determineType(a, b, c)

        then: "The correct triangle type is returned"
        response == triangleType

        where:
        a | b | c | triangleType
        1 | 1 | 1 | TriangleType.EQUILATERAL
        5 | 4 | 5 | TriangleType.ISOSCELES
        7 | 4 | 5 | TriangleType.SCALENE
        7 | 1 | 2 | TriangleType.NO_TRIANGLE

    }
}
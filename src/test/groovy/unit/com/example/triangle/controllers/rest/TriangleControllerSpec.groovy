package unit.com.example.triangle.controllers.rest

import com.example.triangle.business.rest.facade.api.TriangleFacade
import com.example.triangle.business.rest.facade.runtime.TriangleFacadeImpl
import com.example.triangle.controllers.rest.TriangleController
import spock.lang.Specification

class TriangleControllerSpec extends Specification {

    def "Should correctly interact with dependencies"() {
        given: "Mock dependencies for Controller"
        TriangleFacade triangleFacadeMock = Mock(TriangleFacadeImpl.class)
        TriangleController triangleController = new TriangleController(triangleFacadeMock)

        when: "Evaluate triangle type is asked"
        triangleController.evaluateType(a, b, c)

        then: "Controller correctly interact with dependencies"
        1 * triangleFacadeMock.evaluateTriangle(a, b, c)

        where:
        a | b | c
        1 | 2 | 3
    }
}
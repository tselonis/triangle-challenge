package unit.com.example.triangle.controllers.rest

import com.example.triangle.business.rest.facade.api.TriangleFacade
import com.example.triangle.business.rest.facade.runtime.TriangleFacadeImpl
import com.example.triangle.business.rest.factories.TriangleResponseFactory
import com.example.triangle.controllers.rest.TriangleController
import com.example.triangle.enums.TriangleType
import spock.lang.Specification

class TriangleControllerSpec extends Specification {

    def "Should correctly interact with dependencies"() {
        given: "Mock dependencies for Controller"
        TriangleFacade triangleFacadeMock = Mock(TriangleFacadeImpl.class)
        triangleFacadeMock.evaluateTriangle(1, 1, 1) >> TriangleResponseFactory.createResponse(TriangleType.EQUILATERAL)
        TriangleController triangleController = new TriangleController(triangleFacadeMock)

        when: "Evaluate triangle type is asked"
        triangleController.evaluateType(1, 1, 1)

        then: "Controller correctly interact with dependencies"
        1 * triangleFacadeMock.evaluateTriangle(1, 1, 1)

    }

}
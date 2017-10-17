package errorcollectorissue

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DemoController)
class DemoControllerSpec extends Specification {

    void "test something"() {
        given:
        controller.demoService = Mock(DemoService)

        when:
        params.s1 = 'One'
        params.s2 = 'Two'
        def model = controller.concatStrings()

        then:
        controller.demoService.addStrings(_ as String, _ as String) >> {
            String s1, String s2 ->
                // the following line causes a compile error after upgrading to Grails 3.3.1
                assert s1 != s2
                (s1 + s2).toUpperCase()
        }
        model.result == 'ONETWO'
    }
}

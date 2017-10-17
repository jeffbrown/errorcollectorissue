package errorcollectorissue

class DemoController {

    DemoService demoService

    def concatStrings(String s1, String s2) {
        def result = demoService.addStrings(s1, s2)
        [result: result]
    }
}

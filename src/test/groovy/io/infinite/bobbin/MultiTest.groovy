package io.infinite.bobbin

import groovy.util.logging.Slf4j
import org.junit.Test

@Slf4j
class MultiTest {

    @Test
    void test() {
        (0..1000).each {
            log.debug("Debug $it")
        }
    }

}
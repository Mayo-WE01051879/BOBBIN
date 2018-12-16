package io.infinite.bobbin.tests_1_x_x.Archiving.Housekeeping

import io.infinite.bobbin.tests_1_x_x.BobbinTest
import org.junit.Before
import org.junit.Test

import java.util.zip.ZipFile

class Housekeeping extends BobbinTest {

    @Before
    void init() {
        File file = new File("./LOGS/Archiving/Housekeeping/LOG.log")
        file.getParentFile().mkdirs()
        FileWriter fileWriter = new FileWriter(file, true)
        fileWriter.write(uuid)
        fileWriter.flush()
        fileWriter.close()
    }

    @Override
    void writeLogs() {
        bobbinNameAdapter.bobbin().error("LOG","error " + uuid)
        bobbinNameAdapter.bobbin().warn("LOG", "warn " + uuid)
        Thread.currentThread().sleep(1500)
    }

    @Test
    void test() {
        super.runTest()
    }

    @Override
    void assertLogs() {
        assertFile("LOGS/Archiving/Housekeeping/LOG", ".log", ".expected")
        ZipFile zipFile = new ZipFile(new File("./LOGS/Archiving/Housekeeping/LOG.log_previous.zip"))
        assert zipFile.entries().toList().size() == 1
        zipFile.entries().each {
            assert zipFile.getInputStream(it).getText() == uuid
        }
    }

}
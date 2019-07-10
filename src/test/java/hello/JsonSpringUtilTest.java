package hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;



class JsonSpringUtilTest {

    @Test
    public void toJsonAndFromResourceTest(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("SampleResponse.json");
        Response responseOut = new Response("tendon", System.currentTimeMillis());
        JsonSpringUtil.toFileSystemJson(tempFile.toString(), responseOut);
        Response responseIn = JsonSpringUtil.fromFileSystemJson(tempFile.toString(), Response.class);
        assertEquals(responseOut, responseIn);
    }



}
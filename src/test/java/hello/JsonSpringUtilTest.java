package hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class JsonSpringUtilTest {

    @Test
    public void toJsonAndFromResourceTest(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("SampleResponse.json");
        Response responseOut = new Response("tendon", System.currentTimeMillis());
        JsonSpringUtil.toFileSystemJson(tempFile.toString(), responseOut);
        Response responseIn = JsonSpringUtil.fromFileSystemJson(tempFile.toString(), Response.class);
        assertEquals(responseOut, responseIn);
    }

    @Test
    public void fromFileSystemOrDefaultToClassPathJsonTest(@TempDir Path tempDir) throws IOException{
        Path aCurrentResponsePath = tempDir.resolve("aCurrentResponse.json");
        Response aCurrentResponse = new Response("tendon", System.currentTimeMillis());
        JsonSpringUtil.toFileSystemJson(aCurrentResponsePath.toString(), aCurrentResponse);

        String aDefaultResponsePath = "DefaultTestResponse.json";
        Response aDefaultResponse = JsonSpringUtil.fromClassPathJson(aDefaultResponsePath, Response.class);

        Path aMissingCurrentResponsePath = tempDir.resolve("aMissingResponse.json");

        //test that it gets one that already exists
        Response responseIn = JsonSpringUtil.fromFileSystemOrCopyFromDefaultClassPathJson(aCurrentResponsePath.toString(), aDefaultResponsePath, Response.class);
        assertEquals(aCurrentResponse, responseIn);

        //check that it returns the default if it doesn't exist
        responseIn = JsonSpringUtil.fromFileSystemOrCopyFromDefaultClassPathJson(aMissingCurrentResponsePath.toString(), aDefaultResponsePath, Response.class);
        assertEquals(aDefaultResponse, responseIn);
        //make sure it actually wrote a copy of the default to the missing location
        responseIn = JsonSpringUtil.fromFileSystemJson(aMissingCurrentResponsePath.toString(), Response.class);
        assertEquals(aDefaultResponse, responseIn);

        //make sure it would throw an exception if both paths are bad
        assertThrows(IOException.class, () -> JsonSpringUtil.fromFileSystemOrCopyFromDefaultClassPathJson("bad file path", "bad default path", Response.class) );
    }



}
package hello;

import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonResponsePoolDatastoreTest {
    @Test
    public void loadResponsesTest() throws IOException {
        ResponsePoolDatastore responsePoolDatastore = new JsonResponsePoolDatastore("src/test/resources/ResponsesList.json");
        assertEquals(3, responsePoolDatastore.getAllResponses().size());
    }
}

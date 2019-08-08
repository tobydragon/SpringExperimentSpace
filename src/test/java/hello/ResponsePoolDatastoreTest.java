package hello;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponsePoolDatastoreTest {

    //Implementations of ResponsePoolDatastore will call this in their tests
    public static void responsePoolDatastoreTest(ResponsePoolDatastore responsePoolDatastore) throws IOException {
        //this test assumes that the datastore starts with 3 responses
        assertEquals(3, responsePoolDatastore.getAllResponses().size());

        responsePoolDatastore.addResponse(new Response("This is a new response", System.currentTimeMillis()));
        assertEquals(4, responsePoolDatastore.getAllResponses().size());

        responsePoolDatastore.removeResponse("This is a new response");
        assertEquals(3, responsePoolDatastore.getAllResponses().size());
    }

}

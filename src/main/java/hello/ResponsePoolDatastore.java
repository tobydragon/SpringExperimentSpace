package hello;

import java.io.IOException;
import java.util.List;

public interface ResponsePoolDatastore {

    List<Response> getAllResponses();
    void addResponse(Response responseIn) throws IOException;
    void removeResponse(String responseTextIn) throws IOException;

}

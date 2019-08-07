package hello;

import java.util.List;

public interface ResponsePoolDatastore {

    List<Response> getAllResponses();
    void addResponse(Response responseIn);
    void removeResponse(Response responseIn);

}

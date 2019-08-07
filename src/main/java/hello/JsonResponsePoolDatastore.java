package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonResponsePoolDatastore implements ResponsePoolDatastore {

    private List<Response> responses;
    private String filePath;

    public JsonResponsePoolDatastore(String filePath) throws IOException {
        this.filePath = filePath;
        this.responses = JsonUtil.listFromJsonFile(filePath, Response.class);
    }

    @Override
    public List<Response> getAllResponses() {
        return new ArrayList<Response>(responses);
    }

    @Override
    public void addResponse(Response responseIn) {
        responses.add(responseIn);
    }

    @Override
    public void removeResponse(Response responseIn) {
        responses.remove(responseIn);
    }
}

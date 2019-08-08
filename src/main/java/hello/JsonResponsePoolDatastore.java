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
        return new ArrayList<>(responses);
    }

    @Override
    public void addResponse(Response responseIn) throws IOException {
        responses.add(responseIn);
        JsonUtil.toJsonFile(filePath, responses);
    }

    @Override
    public void removeResponse(String responseTextIn) throws IOException {
        for(Response currResponse : responses){
            if(currResponse.getResponseText().equals(responseTextIn)){
                responses.remove(currResponse);
                JsonUtil.toJsonFile(filePath, responses);
            }
        }
    }
}

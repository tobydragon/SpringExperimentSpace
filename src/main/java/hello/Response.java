package hello;

public class Response {
    private String responseText;
    private long timestamp;

    public Response() {
    }

    public Response(String responseText, long timestamp) {
        this.responseText = responseText;
        this.timestamp = timestamp;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        }
        if (!Response.class.isAssignableFrom(otherObj.getClass())) {
            return false;
        }
        Response other = (Response) otherObj;
        return this.getResponseText().equals(other.getResponseText())
                && this.getTimestamp() == (other.getTimestamp());
    }
}

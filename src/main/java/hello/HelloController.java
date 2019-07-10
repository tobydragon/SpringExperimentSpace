package hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Date;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() throws IOException {
        Response response = JsonSpringUtil.fromJsonResource("localData/CurrentResponse.json", Response.class);
        return response.getResponseText() + new Date(response.getTimestamp()).toString();
    }

    @RequestMapping("/change")
    public void change(@RequestParam String newGreeting) throws IOException {
        Response response = new Response(newGreeting, System.currentTimeMillis());
        JsonSpringUtil.toJsonResource("localData/CurrentResponse.json", response);
    }
    
}

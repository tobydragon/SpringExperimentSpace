package hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Date;

@RestController
public class HelloController {

    @RequestMapping("/resetToDefault")
    public String defaultGreeting() throws IOException {
        Response response = JsonSpringUtil.fromClassPathJson("DefaultResponse.json", Response.class);
        JsonSpringUtil.toFileSystemJson("localData/CurrentResponse.json", response);
        return greeting();
    }


    @RequestMapping("/")
    public String greeting() throws IOException {
        Response response = JsonSpringUtil.fromFileSystemOrCopyFromDefaultClassPathJson("localData/CurrentResponse.json", "DefaultResponse.json", Response.class);
        return response.getResponseText() + " at " + new Date(response.getTimestamp()).toString();
    }

    @RequestMapping("/change")
    public String change(@RequestParam String newGreeting) throws IOException {
        Response response = new Response(newGreeting, System.currentTimeMillis());
        JsonSpringUtil.toFileSystemJson("localData/CurrentResponse.json", response);
        return greeting();
    }
    
}

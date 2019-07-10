package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.IOException;

public class JsonSpringUtil {

    // loads from the resources folder, rather than user.dir
    public static <T> T fromClassPathJson(String relativePath, Class<? extends T> classToBeCreated) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.readValue(new ClassPathResource(relativePath).getInputStream(), classToBeCreated);
    }

    public static <T> T fromFileSystemJson(String relativePath, Class<? extends T> classToBeCreated) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.readValue(new FileSystemResource(relativePath).getFile(), classToBeCreated);
    }

    public static void toFileSystemJson(String relativePath, Object objectToSerialize) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new FileSystemResource(relativePath).getFile();
        if (!file.exists()){
            file.createNewFile();
        }
        mapper.writeValue(file, objectToSerialize);
    }
}

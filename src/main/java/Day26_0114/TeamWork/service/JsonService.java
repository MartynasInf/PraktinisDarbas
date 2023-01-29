package Day26_0114.TeamWork.service;

import Day26_0114.TeamWork.entity.Teacher;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonService {
    public void addToJson(String filePath, List<Teacher> teacherList) {
        try {
            new ObjectMapper().writeValue(new File(filePath), teacherList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

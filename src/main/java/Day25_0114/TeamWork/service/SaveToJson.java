package Day25_0114.TeamWork.service;

import Day25_0114.TeamWork.entity.Patient;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveToJson {
    public void listToJson(List<Patient> givenList){
        String json = new Gson().toJson(givenList);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/Patient.json");
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package daos;

import com.google.gson.Gson;
import models.QuestionList;
import services.GetService;

import java.io.IOException;

public class QuestionListDAO {
    private final Gson gson = new Gson();
    private final GetService getService =  GetService.getInstance();


    public Object getQuestionList()throws IOException {
        return gson.fromJson(getService.getResponse("http://localhost:8080/questionlist"),Object.class);
    }
}

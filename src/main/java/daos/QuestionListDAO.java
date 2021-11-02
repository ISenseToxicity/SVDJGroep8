package daos;

import com.google.gson.Gson;
import models.ExceptionReturnObject;
import models.QuestionList;
import services.GetService;
import java.io.IOException;


public class QuestionListDAO {
    private final Gson gson = new Gson();
    private final GetService getService =  GetService.getInstance();

    //made this because both objects need te be checked and handled in questioncontroller backend will return one of these 2 objects
    public Object[] getQuestionList()throws IOException {
       String response = getService.getResponse("http://localhost:8080/questionlist");
       Object[] objects = new Object[2];

       objects[0] = gson.fromJson(response, ExceptionReturnObject.class);
       objects[1] = gson.fromJson(response,QuestionList.class);
       return objects;
    }
}

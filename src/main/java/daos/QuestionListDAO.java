package daos;

import models.Answer;
import models.Question;
import models.QuestionList;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionListDAO {
   // private final Gson gson = new Gson();
   // private final RequestService requestService =  RequestService.getInstance();
    QuestionList questionList = new QuestionList();


    public QuestionList getQuestionList()throws IOException {
        //todo add a global DAO URL and change return to the gson return
       // return gson.fromJson(requestService.getResponse("/QuestionList"),QuestionList.class);
        tempFill();
        return questionList;
    }

       //todo remove tempfill
    public void tempFill(){
        ArrayList<Question> questions =new ArrayList<>();
        for(int i = 0; i < 9; i++){
            ArrayList<Answer> answers = new ArrayList<>();
            Question question = new Question(String.valueOf(i), i +"MJSDGO",answers,"sfgjfdgoidgf","kjfdslfjgdoid");
            questions.add(question);
        }
        questionList.setQuestions(questions);
    }
}

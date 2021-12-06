import controllers.ControllerRegistry;
import controllers.ReformRequestController;
import controllers.RequestController;
import models.Answer;
import models.Category;
import models.Question;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class QuestionTest {

    @Test
    public void should_get_correct_Question_0() {

        // Arrange

        ControllerRegistry.register(new ReformRequestController());
        ControllerRegistry.register(new RequestController());
        RequestController requestController = (RequestController) ControllerRegistry.get(RequestController.class);

        ArrayList<Answer> answers = new ArrayList<>();

        ArrayList<Category> categoriesAnswer1 = new ArrayList<>();
        categoriesAnswer1.add(new Category(1L, "name1" ,"description1"));
        categoriesAnswer1.add(new Category(2L, "name2" ,"description2"));
        categoriesAnswer1.add(new Category(6L, "Ditiseengrotemooiecategorie","mooiemooiecategoriejeweetzelfg"));
        answers.add(new Answer("1", "answer_text1", categoriesAnswer1));

        ArrayList<Category> categoriesAnswer2 = new ArrayList<>();
        categoriesAnswer2.add(new Category(1L, "name1", "description1"));
        categoriesAnswer2.add(new Category(5L,"name5", "description5"));
        categoriesAnswer2.add(new Category(6L, "Ditiseengrotemooiecategorie", "mooiemooiecategoriejeweetzelfg"));
        answers.add(new Answer("2", "answer_text1", categoriesAnswer2));

        Question expectedQuestion = new Question("1", "question_text1", answers, "extra_info_tile1", "extra_info_description1", "extra_info_video_url1");

        // Act

        Question resultQuestion = requestController.makeRequestOfReceivingQuestions().get(0);

        // Assert

        Assert.assertEquals(expectedQuestion.toString(), resultQuestion.toString());

    }

}

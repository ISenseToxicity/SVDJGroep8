package daos;

import models.Route;
import services.PostService;

import java.io.IOException;

public class RouteDAO {

    private static RouteDAO routeDAO;
    private PostService postService;

    public RouteDAO() {
        postService = PostService.getInstance();
    }

    public static synchronized RouteDAO getInstance() {
        if(routeDAO == null) {
            routeDAO = new RouteDAO();
        }
        return routeDAO;
    }

    public void post(String jsonString) throws IOException, InterruptedException {
        //TODO: extract Json from route
        postService.post("localhost", jsonString);
    }

}

/* Json format example for reference TODO: remove this when no longer needed
  {
    "routeid": 0,                   << get from the route model
    "time": 120,                    << get from the route model
    "given_answers": [              << loop through route ArrayList<Givenanswer>
      {                             << for each givenAnswer
        "givenanswerid": 0,         << get the id
        "elapsed_seconds": 10,      << get the elapsed seconds
        "questionid": 0,            << get the questionid
        "answerid": 1               << get the answerid
      },
      {
        "givenanswerid": 1,
        "elapsed_seconds": 10,
        "questionid": 2,
        "answerid": 1
      },
      {
        "givenanswerid": 2,
        "elapsed_seconds": 10,
        "questionid": 3,
        "answerid": 0
      },
      {
        "givenanswerid": 3,
        "elapsed_seconds": 10,
        "questionid": 5,
        "answerid": 0
      },
      {
        "givenanswerid": 4,
        "elapsed_seconds": 10,
        "questionid": 8,
        "answerid": 2
      },
      {
        "givenanswerid": 5,
        "elapsed_seconds": 10,
        "questionid": 9,
        "answerid": 1
      },
      {
        "givenanswerid": 6,
        "elapsed_seconds": 10,
        "questionid": 13,
        "answerid": 1
      },
      {
        "givenanswerid": 7,
        "elapsed_seconds": 10,
        "questionid": 14,
        "answerid": 0
      },
      {
        "givenanswerid": 8,
        "elapsed_seconds": 10,
        "questionid": 18,
        "answerid": 0
      },
      {
        "givenanswerid": 9,
        "elapsed_seconds": 10,
        "questionid": 19,
        "answerid": 2
      },
      {
        "givenanswerid": 10,
        "elapsed_seconds": 10,
        "questionid": 22,
        "answerid": 1
      }
    ]
  }
 */

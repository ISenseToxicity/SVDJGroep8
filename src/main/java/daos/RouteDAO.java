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
        //TODO: extract Json fr om route
        postService.post("localhost", jsonString);
    }

}

package controllers;

import java.util.Collection;
import java.util.HashMap;

// This class is meant to register all Controllers and only use one instance of each.
public class ControllerRegistry {

        protected  final static HashMap<String, Controller> controllers = new HashMap<>();

        public static void register(Controller controller) {
            String className = controller.getClass().getSimpleName();
            controllers.put(className, controller);
        }

        public static Controller get(Class<? extends Controller> controllerClass) {
            String className = controllerClass.getSimpleName();
            return controllers.get(className);
        }

        public static Collection<Controller> getCollection() {
            return controllers.values();
        }



    // Als je Instanties van ControllerRegistry wilt halen type dan
    // KlasNaam klasNaam = (KlasNaam) ControllerRegistry.get(KlasNaam.class);
    // :)

}
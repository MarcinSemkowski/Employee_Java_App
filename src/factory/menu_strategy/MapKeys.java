package factory.menu_strategy;

public class MapKeys {
    private static MapKeys instance;


    public static MapKeys getInstance() {
        if (instance == null) {
            synchronized (MapKeys.class) {
                if (instance == null) {
                    instance = new MapKeys();
                }
            }
        }
        return instance;
    }
}

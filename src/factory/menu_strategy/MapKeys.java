package factory.menu_strategy;

import java.util.ArrayList;
import java.util.List;

public class MapKeys {
    private static MapKeys instance;

    private List<String> mapKeys = new ArrayList<>();


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

    public List<String> getMapKeys() {
        return mapKeys;
    }

    public void setMapKeys(List<String> mapKeys) {
        this.mapKeys = mapKeys;
    }



}

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kelliejos on 4/6/16.
 */
public class CityMaps {
    private final Map<String,Integer> LosAngeles =  new HashMap<String,Integer>() {{
        put("los angeles", 2);
        put("monterey", 1);
        put("san francisco", 1);
        put("death valley", 1);
        put("redwoods", 1);
        put("napa", 1);
        put("tahoe", 1);
        put("yosemite", 1);
    }};
    private final Map<String,Integer> SanFrancisco =  new HashMap<String,Integer>() {{
        put("los angeles", 1);
        put("monterey", 0);
        put("san francisco", 2);
        put("death valley", 1);
        put("redwoods", 1);
        put("napa", 0);
        put("tahoe", 1);
        put("yosemite", 1);
    }};
    private final Map<String,Integer> Redwoods =  new HashMap<String,Integer>() {{
        put("los angeles", 1);
        put("monterey", 1);
        put("san francisco", 1);
        put("death valley", 1);
        put("redwoods", 1);
        put("napa", 1);
        put("tahoe", 1);
        put("yosemite", 1);
    }};
    private final Map<String,Integer> Monterey =  new HashMap<String,Integer>() {{
        put("los angeles", 1);
        put("monterey", 1);
        put("san francisco", 0);
        put("death valley", 1);
        put("redwoods", 1);
        put("napa", 0);
        put("tahoe", 1);
        put("yosemite", 1);
    }};
    private final Map<String,Integer> Napa =  new HashMap<String,Integer>() {{
        put("los angeles", 1);
        put("monterey", 0);
        put("san francisco", 0);
        put("death valley", 1);
        put("redwoods", 1);
        put("napa", 2);
        put("tahoe", 1);
        put("yosemite", 1);
    }};
    private final Map<String,Integer> Tahoe =  new HashMap<String,Integer>() {{
        put("los angeles", 1);
        put("monterey", 1);
        put("san francisco", 1);
        put("death valley", 1);
        put("redwoods", 1);
        put("napa", 1);
        put("tahoe", 2);
        put("yosemite", 1);
    }};
    private final Map<String,Integer> DeathValley =  new HashMap<String,Integer>() {{
        put("los angeles", 1);
        put("monterey", 1);
        put("san francisco", 1);
        put("death valley", 1);
        put("redwoods", 1);
        put("napa", 1);
        put("tahoe", 1);
        put("yosemite", 1);
    }};
    private final Map<String,Integer> Yosemite =  new HashMap<String,Integer>() {{
        put("los angeles", 1);
        put("monterey", 1);
        put("san francisco", 1);
        put("death valley", 1);
        put("redwoods", 1);
        put("napa", 1);
        put("tahoe", 1);
        put("yosemite", 2);
    }};
    private final Map<String,Map<String,Integer>> NodeList =  new HashMap<String,Map<String,Integer>>() {{
        put("los angeles", LosAngeles);
        put("monterey", Monterey);
        put("san francisco", SanFrancisco);
        put("death valley", DeathValley);
        put("redwoods", Redwoods);
        put("napa", Napa);
        put("tahoe", Tahoe);
        put("yosemite", Yosemite);
    }};

    public Map<String, Integer> getMapForNode (String node) {
        return NodeList.get(node);
    }
}

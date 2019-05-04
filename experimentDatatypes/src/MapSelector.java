import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MapSelector implements Serializable {
    public static final long serialVersionUID = 1L;
    LinkedHashMap<String, MapSelector> nest = new LinkedHashMap<>();
    private String id;
    private String name;
    private String type;

    public MapSelector(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public MapSelector() {

    }

    public static void main(String[] args) {
        new MapSelector().work();
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (Exception e) {
            System.out.println("Json parssing error" + e.getMessage());
        }
        return json;
    }

    public void work() {
        LinkedHashMap<String, MapSelector> data = new LinkedHashMap<>();
        data.put("India", new MapSelector("+91", "India", "Country"));
        data.get("India").nest.put("Gujarat", new MapSelector("GJ", "gujarat", "State"));
        data.get("India").nest.get("Gujarat").nest.put("Surat", new MapSelector("395009", "surat", "city"));
        data.get("India").nest.put("Gujarat", new MapSelector("GJ", "gujarat", "State"));
        data.get("India").nest.put("Rajasthan", new MapSelector("RJ", "rajasthan", "State"));
        if (!data.containsKey("India")) {
            data.put("India", new MapSelector("+91", "India", "Country"));
        }
        //  System.out.println(data);
        data.put("USA", new MapSelector("+XX", "USA", "Country"));
        System.out.println(data);
        //new MapSelector().display(data);

    }
    //    void display(HashMap<String, MapSelector> data){
//        System.out.println("result : [");
//        for (SelectorData s:data) {
//            System.out.println(s);
//        }
//        System.out.println("]");
//    }
}

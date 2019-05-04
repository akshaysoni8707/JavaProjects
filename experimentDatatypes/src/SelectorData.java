import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SelectorData implements Serializable {
    public static final long serialVersionUID = 1L;
    ArrayList<SelectorData> nest = new ArrayList<>();
    private String id;
    private String name;
    private String type;

    public SelectorData(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public SelectorData() {

    }

    public static void main(String[] args) {
        ArrayList<SelectorData> data = new ArrayList<>();
        data.add(new SelectorData("+91", "India", "Country"));
        data.get(0).nest.add(new SelectorData("GJ", "gujarat", "State"));
        data.get(0).nest.add(new SelectorData("GJ", "gujarat", "State"));
        data.get(0).nest.get(0).nest.add(new SelectorData("395009", "surat", "city"));
        System.out.println(data);
        new SelectorData().display(data);

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

    void JSONarray(ArrayList<SelectorData> selectorData) {
        System.out.println("{result:\t[" + selectorData + "]\n}");
    }

    String JSONnestarray(ArrayList<SelectorData> selectorData) {
        StringBuilder sb = new StringBuilder();
        for (SelectorData s : selectorData) {
            sb.append(s.toString());
        }
        return sb.toString();
    }

    void display(ArrayList<SelectorData> data) {
        System.out.println("result : [");
        for (SelectorData s : data) {
            System.out.println(s);
        }
        System.out.println("]");
    }
}

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.Map;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Template1 implements Serializable {
    public static final long serialVersionUID = 1L;
    private static int i = 0;
    // @JsonProperty(" ")
    private String v = "";
    private LinkedHashMap<String, Template1> nest = new LinkedHashMap<>();

    private String loop(int n) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb1.append("\t\t");
        }
        return sb1.toString();
    }

    void makeNest(String key) {
        this.nest.putIfAbsent(key, new Template1());
    }

    Template1 getNest(String key) {
        return this.nest.get(key);
    }

    void putValue(String value) {
        this.v = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i1;
        i++;
        i1 = i;
        if (!this.v.equals("")) {
            sb.append("\"").append(this.v).append("\"");
        }
        for (Map.Entry entry : nest.entrySet()) {
            //      i++;
            //    sb.append(loop(i-  1)+"{").append(entry.getKey()).append(":\n").append(entry.getValue().toString()).append(loop(i-1)+"}\n");
            sb.append("\n").append(loop(i1)).append("{").append("\"").append(entry.getKey()).append("\"").append(":").append(entry.getValue().toString()).append("\n").append(loop(i1)).append("}");
        }
        i--;
        return sb.toString();

/*        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {

            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (Exception e) {
            System.out.println("Json parssing error" + e.getMessage());
        }
        return json;*/


    }


}

public class DynamicSelector {
//    public static void print(String jsonString){
//        ObjectMapper objectMapper = new ObjectMapper();
//        Object object = null;
//        try {
//            object = objectMapper.readValue(jsonString, Object.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("JSON  mapping to Object with pretty print");
//        try {
//            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        Template1 template1 = new Template1();
        DynamicSelector sample = new DynamicSelector();
        template1.makeNest("India");
        template1.getNest("India").makeNest("Gujarat");
        template1.getNest("India").makeNest("Rajasthan");
        template1.getNest("India").makeNest("Maharashtra");
        template1.getNest("India").getNest("Gujarat").makeNest("Surat");
        template1.getNest("India").getNest("Gujarat").makeNest("Navsari");
        template1.getNest("India").getNest("Gujarat").makeNest("Baroda");
        template1.getNest("India").getNest("Maharashtra").makeNest("Mumbai");
        template1.getNest("India").getNest("Maharashtra").makeNest("Pune");
        template1.getNest("India").getNest("Rajasthan").makeNest("Jaipur");
        template1.getNest("India").getNest("Rajasthan").makeNest("Udaipur");
        template1.getNest("India").getNest("Gujarat").putValue("dslkvzksldcvksvdslsdjkb,kfsiugfsugclzscglzsbc");
        template1.makeNest("USA");
        template1.getNest("USA").makeNest("NewYork");
        template1.getNest("USA").getNest("NewYork").putValue("afdsxfbcb");
        template1.getNest("India").getNest("Gujarat").getNest("Surat").makeNest("River");
        template1.getNest("India").getNest("Gujarat").getNest("Surat").getNest("River").putValue("Tapi");
        template1.getNest("India").getNest("Gujarat").getNest("Surat").makeNest("Pincode");
        template1.getNest("India").getNest("Gujarat").getNest("Surat").getNest("Pincode").putValue("395009");
        System.out.println(template1);
        //     print(template1.toString());
        //   template1.disp();
    }
}

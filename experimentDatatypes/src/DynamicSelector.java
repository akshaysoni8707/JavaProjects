import java.io.IOException;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Template implements Serializable {
    public static final long serialVersionUID = 1L;
    static int i = 0;
    // @JsonProperty(" ")
    String v = "";
    LinkedHashMap<String, Template> nest = new LinkedHashMap<>();

    public String loop(int n) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb1.append("\t\t");
        }
        return sb1.toString();
    }

    public void makeNest(String key) {
        this.nest.putIfAbsent(key, new Template());
    }

    public Template getNest(String key) {
        return this.nest.get(key);
    }

    public void putValue(String value) {
        this.v = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i1 = 0;
        i++;
        i1 = i;
        if (!this.v.equals("")) {
            sb.append("\"").append(this.v).append("\"");
        }
        for (Map.Entry entry : nest.entrySet()) {
            //      i++;
            //    sb.append(loop(i-  1)+"{").append(entry.getKey()).append(":\n").append(entry.getValue().toString()).append(loop(i-1)+"}\n");
            sb.append("\n" + loop(i1) + "{").append("\"").append(entry.getKey()).append("\"").append(":").append(entry.getValue().toString()).append("\n" + loop(i1) + "}");
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
        Template template = new Template();
        DynamicSelector sample = new DynamicSelector();
        template.makeNest("India");
        template.getNest("India").makeNest("Gujarat");
        template.getNest("India").makeNest("Rajasthan");
        template.getNest("India").makeNest("Maharashtra");
        template.getNest("India").getNest("Gujarat").makeNest("Surat");
        template.getNest("India").getNest("Gujarat").makeNest("Navsari");
        template.getNest("India").getNest("Gujarat").makeNest("Baroda");
        template.getNest("India").getNest("Maharashtra").makeNest("Mumbai");
        template.getNest("India").getNest("Maharashtra").makeNest("Pune");
        template.getNest("India").getNest("Rajasthan").makeNest("Jaipur");
        template.getNest("India").getNest("Rajasthan").makeNest("Udaipur");
        template.getNest("India").getNest("Gujarat").putValue("dslkvzksldcvksvdslsdjkb,kfsiugfsugclzscglzsbc");
        template.makeNest("USA");
        template.getNest("USA").makeNest("NewYork");
        template.getNest("USA").getNest("NewYork").putValue("afdsxfbcb");
        template.getNest("India").getNest("Gujarat").getNest("Surat").makeNest("River");
        template.getNest("India").getNest("Gujarat").getNest("Surat").getNest("River").putValue("Tapi");
        System.out.println(template);
        //     print(template.toString());
        //   template.disp();
    }
}

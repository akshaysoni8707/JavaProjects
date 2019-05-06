import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Template implements Serializable {
    public static final long serialVersionUID = 1L;

    @JsonProperty(" ")
    LinkedHashMap<String, Template> nest = new LinkedHashMap<>();


    public String loop(int n) {
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb1.append("\t\t");
        }
        return sb1.toString();
    }

    @Override
    public String toString() {
//        StringBuffer sb = new StringBuffer();
//        int i = 0;
//        for (Map.Entry entry : nest.entrySet()) {
//            i++;
//            sb.append(loop(i-1)+"{").append(entry.getKey()).append(":\n").append(entry.getValue().toString()).append(loop(i-1)+"}\n");
//        }
//        return sb.toString();

        return "\t\n" + nest + "\t\n";


//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = "";
//        try {
//
//            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.nest.entrySet().toArray());
//        } catch (Exception e) {
//            System.out.println("Json parssing error" + e.getMessage());
//        }
//        return json;
    }

}

public class DynamicSelector {
    LinkedHashMap<String, Template> template = new LinkedHashMap<>();

//    @Override
//    public String toString() {
//        return "DynamicSelector{" +
//                "template=" + template +
//                '}';
//    }

    public static void main(String[] args) {
        Template template = new Template();
        template.nest.putIfAbsent("India", new Template());
        template.nest.get("India").nest.putIfAbsent("Gujarat", new Template());
        template.nest.get("India").nest.putIfAbsent("Rajasthan", new Template());
        template.nest.get("India").nest.putIfAbsent("Maharashtra", new Template());
        template.nest.get("India").nest.get("Gujarat").nest.putIfAbsent("Surat", new Template());
        template.nest.get("India").nest.get("Gujarat").nest.putIfAbsent("Navsari", new Template());
        template.nest.get("India").nest.get("Gujarat").nest.putIfAbsent("Baroda", new Template());
        template.nest.get("India").nest.get("Maharashtra").nest.putIfAbsent("Mumbai", new Template());
        template.nest.get("India").nest.get("Maharashtra").nest.putIfAbsent("Pune", new Template());
        template.nest.get("India").nest.get("Rajasthan").nest.putIfAbsent("Jaipur", new Template());
        template.nest.get("India").nest.get("Rajasthan").nest.putIfAbsent("Udaipur", new Template());
        template.nest.get("India").nest.get("Gujarat").nest.putIfAbsent("Description", new Template());
        template.nest.get("India").nest.get("Gujarat").nest.get("Description").nest.putIfAbsent("dslkvzksldcvksvdslsdjkb,kfsiugfsugclzscglzsbc", new Template());
        System.out.println(template);
        //   template.disp();
    }
}

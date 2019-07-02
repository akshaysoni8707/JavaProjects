import java.util.*;

class Template {
    public static final long serialVersionUID = 1L;
    private static int i = 0;
    private String v = "";
    private LinkedHashMap<String, Template> nest = new LinkedHashMap<>();

    private String loop(int n) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb1.append("\t");
        }
        return sb1.toString();
    }

    void makeNest(String key) {
        this.nest.putIfAbsent(key, new Template());
    }

    Template getNest(String key) {
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
        if (!v.equals("")) {
            sb.append("\"").append(this.v).append("\"");
        }
        for (Iterator<Map.Entry<String, Template>> iterator = nest.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry entry = iterator.next();
            sb.append("\n").append(loop(i1)).append("\"").append(entry.getKey()).append("\"").append(":").append("{").append(entry.getValue().toString()).append("\n").append(loop(i1)).append("}");
            if (iterator.hasNext()) {
                sb.append(",");
            }
        }
        i--;
        return sb.toString();

    }

    Template find(String findString) {
        Template foundTemplate;
        String[] stringsplitter = findString.split("[.]");
        foundTemplate = this.getNest(stringsplitter[0]);
        for (int i = 1; i < stringsplitter.length; i++) {
            foundTemplate = foundTemplate.getNest(stringsplitter[i]);
        }
        return foundTemplate;
    }


}

public class FinalDynamicMapSelector {
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
        template.makeNest("USA");
        template.getNest("USA").makeNest("NewYork");
        template.getNest("India").getNest("Gujarat").getNest("Surat").makeNest("River");
        template.getNest("India").getNest("Gujarat").getNest("Surat").getNest("River").makeNest("Tapi");
        template.getNest("India").getNest("Gujarat").getNest("Surat").makeNest("Pincode");
        //   template.getNest("India").getNest("Gujarat").getNest("Surat").getNest("Pincode").putValue("395009");
        //  System.out.println(template);
        System.out.println(template.find("India.Rajasthan"));
    }
}



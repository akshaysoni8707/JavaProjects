import java.util.LinkedHashMap;
import java.util.Map;

class Template {
    public static final long serialVersionUID = 1L;
    private static int i = 0;
    private String v = "";
    private LinkedHashMap<String, Template> nest = new LinkedHashMap<>();

    private String loop(int n) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb1.append("\t\t");
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
        if (!this.v.equals("")) {
            sb.append("\"").append(this.v).append("\"");
        }
        for (Map.Entry entry : nest.entrySet()) {
            sb.append("\n").append(loop(i1)).append("{").append("\"").append(entry.getKey()).append("\"").append(":").append(entry.getValue().toString()).append("\n").append(loop(i1)).append("}");
        }
        i--;
        return sb.toString();

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
        template.getNest("India").getNest("Gujarat").putValue("dslkvzksldcvksvdslsdjkb,kfsiugfsugclzscglzsbc");
        template.makeNest("USA");
        template.getNest("USA").makeNest("NewYork");
        template.getNest("USA").getNest("NewYork").putValue("afdsxfbcb");
        template.getNest("India").getNest("Gujarat").getNest("Surat").makeNest("River");
        template.getNest("India").getNest("Gujarat").getNest("Surat").getNest("River").putValue("Tapi");
        template.getNest("India").getNest("Gujarat").getNest("Surat").makeNest("Pincode");
        template.getNest("India").getNest("Gujarat").getNest("Surat").getNest("Pincode").putValue("395009");
        System.out.println(template);
    }
}



import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
	Stack<Integer> st = new Stack<>();
        st.push(2);
	st.push(3);
	//Hashtable<String, Double> hm = new Hashtable<>();
        HashMap<String, Double> hm = new HashMap<>();
	hm.put("10", 34.33);
        hm.put("2", 100.33);
	Set set = hm.entrySet();
	Iterator i = set.iterator();
	for(Map.Entry me:hm.entrySet()) {
	    //Map.Entry me = (Map.Entry)i.next();
	    System.out.print(me.getKey() + ": ");
	    System.out.println(me.getValue());
	}

    }
}

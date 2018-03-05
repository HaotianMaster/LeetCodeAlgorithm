// Input: [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
// Output: ["JFK","KUL"]
// Expected: ["JFK","NRT","JFK","KUL"]
class Solution {
    HashMap<String, PriorityQueue<String>> map = new HashMap<>(); 
    
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) {
            return res;
        }
               
        for (String[] ticket : tickets) {
            if (map.containsKey(ticket[0])) {
                PriorityQueue<String> q = map.get(ticket[0]);
                q.add(ticket[1]);
                map.put(ticket[0], q);
            }
            else {
                PriorityQueue<String> q = new PriorityQueue<>();
                q.add(ticket[1]);
                map.put(ticket[0], q); 
            }
        }
        
        return findItineraryHelper(tickets, "JFK", 0);
    }
    
    public List<String> findItineraryHelper(String[][] tickets, String from, int pos) {
        List<String> res = new ArrayList<>();
        if (pos == tickets.length) {
            return res;
        }

        if (pos == 0) {
            res.add(from);
        }
        String to = "";
        
        if (map.containsKey(from) && !map.get(from).isEmpty()) {
            to = map.get(from).poll();
            res.add(to);            
        }

        
        List<String> subList = findItineraryHelper(tickets, to, pos+1);
        if (subList != null) {
            for (String place : subList) res.add(place);
        }      
        
        return res;      
    }
}


// This solution solves the above corner case.
class Solution {
    HashMap<String, PriorityQueue<String>> map = new HashMap<>(); 
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(String[][] tickets) {        
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) {
            return res;
        }
               
        for (String[] ticket : tickets) {
            if (map.containsKey(ticket[0])) {
                PriorityQueue<String> q = map.get(ticket[0]);
                q.add(ticket[1]);
                map.put(ticket[0], q);
            }
            else {
                PriorityQueue<String> q = new PriorityQueue<>();
                q.add(ticket[1]);
                map.put(ticket[0], q); 
            }
        }
        
        findItineraryHelper("JFK");
        return res;
    }
    
    public void findItineraryHelper(String from) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            findItineraryHelper(map.get(from).poll());
        }       
        res.add(0, from);
    }
}

// Using stack, but actually has same logic with recursion. 
class Solution { 
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) {
            return res;
        }
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (map.containsKey(ticket[0])) {
                PriorityQueue<String> q = map.get(ticket[0]);
                q.add(ticket[1]);
                map.put(ticket[0], q);
            }
            else {
                PriorityQueue<String> q = new PriorityQueue<>();
                q.add(ticket[1]);
                map.put(ticket[0], q); 
            }
        }
        Deque<String> st = new ArrayDeque<>();
        st.push("JFK");
        while (!st.isEmpty()) {
            while (map.containsKey(st.peek()) && !map.get(st.peek()).isEmpty()) {
                st.push(map.get(st.peek()).poll());
            }
            res.add(0, st.pop());
        }
        return res;
    }
}
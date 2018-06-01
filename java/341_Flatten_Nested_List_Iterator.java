//Perform the flatten process on the fly using stack!
//In the constructor we push the elements of nestedListinto the stack from back to front. 
//So when we call pop(), the very first element of nestedList is returned. 
//Afterwards, in the hasNext function, we check the top element in the stack. 
//If it is a Integer, return true. Otherwise, we take out every element of the list and push them to the stack from back to front (flatten again). 
//Until we find an Integer. The reason to do so is that there may be a lot of nested empty lists. 
//Thus until we actually find an integer, we are not sure if there is a next integer.
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> st;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.st = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            st.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            return null;
        }
        return st.pop().getInteger();        
    }

    @Override
    public boolean hasNext() {
        while (!st.isEmpty()) {
            NestedInteger curr = st.pop();
            if (!curr.isInteger()) {
                for (int i = curr.getList().size() - 1; i >= 0; i--) {
                    st.push(curr.getList().get(i));
                }
            }
            else {
                st.push(curr);
                return true;
            }
        }
        return false;
    }
}

// Rather than perform the flatten process on the fly, we could flatten the nextedList completely in the constructor.
// Use a flattenHelper() function to flatten the nextedList recursively into a flattenedList. 
// And thus we could construct a Iterator<Integer> based on the flattenedList we got.
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> flattenedList;
    private Iterator<Integer> it;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.flattenedList = new ArrayList<Integer>();
        flattenHelper(nestedList);
        this.it = this.flattenedList.iterator();
    }
    public void flattenHelper(List<NestedInteger> nestedList) {
        for (NestedInteger nestedlist : nestedList) {
            if (nestedlist.isInteger()) {
                this.flattenedList.add(nestedlist.getInteger());
            }
            else {
                flattenHelper(nestedlist.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return this.it.next();
    }

    @Override
    public boolean hasNext() {
        return this.it.hasNext();
    }
}










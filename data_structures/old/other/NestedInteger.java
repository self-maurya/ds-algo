package old.other;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;

    public NestedInteger() {
        this.list = new ArrayList<>();
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    public NestedInteger(Integer integer) {
        this.integer = integer;
    }

    public void add(NestedInteger nestedInteger) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.add(nestedInteger);
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return this.integer;
    }

    public boolean isInteger() {
        return this.integer != null;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        return this.printNI(this, sb);
    }

    public String printNI(NestedInteger nestedInteger, StringBuilder sb) {
        if (nestedInteger.isInteger()) {
            sb.append(nestedInteger.integer);
            sb.append(",");
        }
        sb.append("[");
        for(NestedInteger ni: nestedInteger.list) {
            if (ni.isInteger()) {
                sb.append(ni.integer);
                sb.append(",");
            } else {
                printNI(ni, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

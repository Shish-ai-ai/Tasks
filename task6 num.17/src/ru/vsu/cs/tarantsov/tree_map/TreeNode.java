package ru.vsu.cs.tarantsov.tree_map;

import java.util.Map;
import java.util.Set;

public class TreeNode implements Map.Entry<String, Integer> {
    private String key;
    private int value;
    private TreeNode less;
    private TreeNode bigger;

    public TreeNode(String key, int value) {
        this.key = key;
        this.value = value;
    }


    public Integer getValue(String key) {

        if (key.compareTo(this.key) > 0) {
            if (bigger == null) {
                bigger = new TreeNode(key, 0);
                return 0;
            }
            return bigger.getValue(key);
        } else if (key.compareTo(this.key) < 0) {
            if (less == null) {
                less = new TreeNode(key, 0);
                return 0;
            }
            return less.getValue(key);
        }
        return value;
    }


    public Integer setValue(String key, int value) {
        if (this.key.equals(key)) {
            this.value = value;
            return value;
        }
        if (key.compareTo(this.key) > 0) {
            if (bigger == null) {
                bigger = new TreeNode(key, value);
                return 0;
            }
            bigger.setValue(key, value);
            return bigger.getValue();
        } else if (key.compareTo(this.key) < 0) {
            if (less == null) {
                less = new TreeNode(key, value);
                return 0;
            }
            less.setValue(key, value);
            return less.getValue();
        }
        return value;
    }

    public boolean containsKey(String key) {
        return this.key.equals(key)
                || (less != null && less.containsKey(key))
                || (bigger != null && bigger.containsKey(key));
    }

    public int size() {
        return 1 + (less == null ? 0 : less.size()) + (bigger == null ? 0 : bigger.size());
    }

    public void entrySet(Set<Map.Entry<String, Integer>> result) {
        result.add(this);
        if (bigger != null) {
            bigger.entrySet(result);
        }
        if (less != null) {
            less.entrySet(result);
        }
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Integer setValue(Integer value) {
        this.value = value;
        return value;
    }

}

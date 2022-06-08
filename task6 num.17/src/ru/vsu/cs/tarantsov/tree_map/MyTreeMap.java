package ru.vsu.cs.tarantsov.tree_map;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyTreeMap implements Map<String , Integer> {

    private TreeNode root;

    @Override
    public int size() {
        return root.size();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean containsKey(Object key) {
        if (root == null)
            return false;
        return root.containsKey((String) key);
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Integer get(Object key) {
        return root.getValue((String) key);
    }

    @Override
    public Integer put(String key, Integer value) {
        if (root == null) {
            root = new TreeNode(key, value);
            return 0;
        }
        root.setValue(key, value);
        return value;
    }

    @Override
    public Integer remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Integer> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Integer> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Integer>> entrySet() {
        Set<Entry<String, Integer>> result = new HashSet<>();
        root.entrySet(result);
        return result;
    }
}

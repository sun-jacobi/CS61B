package bstmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private int size;

    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left;
        private BSTNode right;
        BSTNode(K k, V v) {
            key = k;
            value = v;
        }
    }

    private BSTNode root;

    public BSTMap() {
        size = 0;
        root = null;
    }
    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    private boolean containsKey(K key, BSTNode node) {
        if (node == null) {
            return false;
        } else if (key.equals(node.key)) {
            return true;
        } else if (key.compareTo(node.key) > 0) {
            return containsKey(key, node.right);
        } else {
            return containsKey(key, node.left);
        }
    }
    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is value");
        } else {
            return containsKey(key, root);
        }
    }
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        BSTNode p = find(key, root);
        if (p == null) {
            return null;
        } else {
            return p.value;
        }

    }
    private BSTNode find(K key, BSTNode node) {
        if (node == null) {
            return null;
        } else if (node.key.equals(key)) {
            return node;
        } else if (key.compareTo(node.key) > 0) {
            return find(key, node.right);
        } else {
            return find(key, node.left);
        }
    }

    public int size() {
        return size;
    }
    @Override
    public void put(K key, V value) {
        if (value == null && key == null) {
            throw new IllegalArgumentException("key and value is null");
        }
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        root = put(key, value, root);
        size++;
    }
    private BSTNode put(K key, V value, BSTNode node) {
        if (node == null) {
            return new BSTNode(key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = put(key, value, node.right);
        } else {
            node.left = put(key, value, node.left);
        }
        return node;
    }
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        dfsSet(set, root);
        return set;
    }
    private void dfsSet(Set<K> set, BSTNode node) {
        if (node == null) {
            return;
        }
        dfsSet(set, node.left);
        set.add(node.key);
        dfsSet(set, node.right);
    }



    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        V val = this.get(key);
        root = remove(key, root);
        return val;

    }
    public void printInOrder() {
        dfs(root);
    }
    private void dfs(BSTNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        System.out.println(node.key);
        dfs(node.right);
    }

    private BSTNode remove(K key, BSTNode node) {
        if (node == null) {
            return null;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(key, node.right);
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(key, node.left);
        } else {
            size--;
            if (node.right == null && node.left == null) {
                return null;
            } else if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                BSTNode tmp = min(node.right);
                node.value = tmp.value;
                node.key = tmp.key;
                tmp = null;
            }
        }
        return node;
    }
    private BSTNode min(BSTNode node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }


    public V remove(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        if (this.get(key) != value) {
            return null;
        } else {
            return this.remove(key);
        }
    }

    @Override
    public Iterator<K> iterator() {
        return this.keySet().iterator();
    }

}

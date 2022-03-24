package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    // You should probably define some more!
    private int size;
    private int bSize;
    private double loadFactor;

    /** Constructors */
    public MyHashMap() {
        size = 0;
        buckets = createTable(16);
        bSize = 16;
        loadFactor = 0.75;
    }

    public MyHashMap(int initialSize) {
        buckets = createTable(initialSize);
        loadFactor = 0.75;
        bSize = initialSize;
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        buckets = createTable(initialSize);
        loadFactor = maxLoad;
        bSize = initialSize;
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key, value);
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        Collection<Node>[] table = new Collection[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = createBucket();
        }
        return table;
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!
    public void clear() {
        size = 0;
        for (int i = 0; i < bSize; i++) {
            buckets[i] = createBucket();
        }
    }

    public boolean containsKey(K key) {
        int i = Math.floorMod(key.hashCode(),bSize);
        for (Node p : buckets[i]) {
            if (p.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        int i = Math.floorMod(key.hashCode(),bSize);
        for (Node p : buckets[i]) {
            if (p.key.equals(key)) {
                return p.value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private void resize(int chains) {
        MyHashMap<K, V> tmp =  new MyHashMap<>(chains, loadFactor);
        for (Collection<Node> p : buckets) {
            for (Node x : p) {
                tmp.put(x.key, x.value);
            }
        }
        this.size = tmp.size;
        this.buckets = tmp.buckets;
        this.bSize = chains;
    }

    public void put(K key, V value) {
        int i = Math.floorMod(key.hashCode(),bSize);
        if (!this.containsKey(key)) {
            buckets[i].add(createNode(key, value));
            size += 1;
        } else {
            for (Node x : buckets[i]) {
                if (x.key.equals(key)) {
                    x.value = value;
                }
            }
        }
        if ((float)size/bSize >=  loadFactor){
            resize(bSize * 2);
        }
    }

    public V remove(K key) {
        if (!this.containsKey(key)) {
            return null;
        }
        int i = Math.floorMod(key.hashCode(),bSize);
        Node q = null;
        V val = null;
        for (Node p : buckets[i]) {
            if (p.key.equals(key)) {
                q = p;
                val = p.value;
                break;
            }
        }
        buckets[i].remove(q);
        return val;
    }

    public V remove(K key, V value) {
        if (!this.containsKey(key)) {
            return null;
        }
        int i = Math.floorMod(key.hashCode(),bSize);
        Node q = null;
        V val = null;
        for (Node p : buckets[i]) {
            if (p.key.equals(key) && p.value.equals(value)) {
                q = p;
                val = p.value;
                break;
            }
        }
        buckets[i].remove(q);
        return val;
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < bSize ;i++){
            for (Node p : buckets[i]) {
                set.add(p.key);
            }
        }
        return set;
    }

    public Iterator<K> iterator() {
        return this.keySet().iterator();
    }

}

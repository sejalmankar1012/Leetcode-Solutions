class MyHashMap {
    private static final int kSize = 10000;
    private List<Entry>[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new List[kSize];
        for (int i = 0; i < kSize; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /** Put a key-value pair into the map. If the key already exists, update the value. */
    public void put(int key, int value) {
        int hash = key % kSize;
        List<Entry> bucket = buckets[hash];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry(key, value));
    }

    /** Get the value of a key. Returns -1 if the key does not exist. */
    public int get(int key) {
        int hash = key % kSize;
        List<Entry> bucket = buckets[hash];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return -1;
    }

    /** Remove a key from the map if it exists. */
    public void remove(int key) {
        int hash = key % kSize;
        List<Entry> bucket = buckets[hash];

        for (Iterator<Entry> iterator = bucket.iterator(); iterator.hasNext();) {
            Entry entry = iterator.next();
            if (entry.key == key) {
                iterator.remove();
                return;
            }
        }
    }

    private static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
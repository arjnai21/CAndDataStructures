package bca.util;

public class BCAMapByArrayList<V> implements BCAMap<V>{
    private BCAArrayList<BCAEntry<V>> map = new BCAArrayList<>();

    @Override
    public int size(){
        return map.size();
    }

    @Override
    public boolean isEmpty(){
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(String key){
        if(key == null)
            throw new NullPointerException();

        for(int i=0;i<map.size();i++){
            if(key.equals(map.get(i).key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value){
        if(value == null)
            throw new NullPointerException();

        for(int i=0;i<map.size();i++){
            if(value.equals(map.get(i).value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(String key){
        if(key == null)
            throw new NullPointerException();
        for(int i=0;i<map.size();i++){
            if(key.equals(map.get(i).key)){
                return map.get(i).value;
            }
        }

        return null;


    }

    @Override
    public V getOrDefault(String key,V defaultValue){
        if(key == null)
            throw new NullPointerException();
        for(int i=0;i<map.size();i++){
            if(key.equals(map.get(i).key)){
                return map.get(i).value;
            }
        }

        return defaultValue;
    }

    @Override
    public V put(String key,V value){
        if(key == null || value == null)
            throw new NullPointerException();
        for(int i=0;i<map.size();i++){
            if(key.equals(map.get(i).key)){
                V val = map.remove(i).value;
                map.add(new BCAEntry<>(key, value));
                return val;
            }
        }
        map.add(new BCAEntry<>(key, value));
        return null;

    }

    @Override
    public V remove(String key){
        if(key == null)
            throw new NullPointerException();

        for(int i=0;i<map.size();i++){
            if(key.equals(map.get(i).key)){

                return map.remove(i).value;
            }
        }
        return null;
    }

    @Override
    public void clear(){
        map = new BCAArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public BCAEntry<V>[] toArray(){
        BCAEntry<V>[] ret =new BCAEntry[map.size()];
        for(int i=0;i<map.size();i++){
            ret[i] = map.get(i);
        }
        return ret;
    }

    @Override
    public String[] keys(){
        String[] ret = new String[map.size()];
        for(int i=0;i<map.size();i++){
            ret[i] = map.get(i).key;
        }
        return ret;
    }

    @Override
    public BCAList<V> values(){
        BCAList<V> ret = new BCAArrayList<>();
        for(int i=0;i<map.size();i++){
            ret.add(map.get(i).value);
        }
        return ret;
    }
}

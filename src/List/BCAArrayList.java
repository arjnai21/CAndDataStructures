package List;

import bca.util.BCAList;

public class BCAArrayList implements BCAList{
    Object[] array;
    int listSize;


    public BCAArrayList(){
        listSize = 0;
        array = new Object[10];
    }

    @Override
    public void add(Object o){
        if(listSize>=array.length-1){
            expand();
        }
        array[listSize++] = o;

    }

    @Override
    public void add(int index,Object o){
        if(listSize>=array.length-1){
            expand();
        }
        for(int i=listSize;i>index;i--){
            array[i] = array[i-1];
        }
        array[index] = o;
    }

    @Override
    public void clear(){

    }

    @Override
    public boolean contains(Object o){
        return false;
    }

    @Override
    public Object get(int index) {
        if(index<0 || index >= listSize)
            throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public int indexOf(Object o){
        for(int i=0;i<listSize;i++){
            if(array[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty(){
        return listSize>0;
    }

    @Override
    public int lastIndexOf(Object o){
        for(int i=listSize-1;i<0;i--){
            if(array[i].equals(o)) return i;
        }
        return -1;

    }

    @Override
    public Object remove(int index){

        return null;
    }

    @Override
    public boolean remove(Object o){
        return false;
    }

    @Override
    public int size(){
        return listSize;
    }

    @Override
    public String toString(){
        return null;
    }

    private void expand(){
        Object[] newArray = new Object[(int) (array.length*1.5)];
        for(int i=0;i<listSize;i++){
            newArray[i] = array[i];
        }

        array = newArray;

    }
}

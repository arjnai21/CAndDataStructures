package bca.util;

import bca.util.BCAList;

public class BCAArrayList<T> implements BCAList<T>{
    protected T[] array;
    protected int listSize;

    @SuppressWarnings("unchecked")
    public BCAArrayList(){

        listSize=0;
        array=(T[]) new Object[10];
    }

    @Override
    public void add(T o){
        if(listSize >= array.length-1){
            expand();
        }
        array[listSize++]=o;

    }

    @Override
    public void add(int index,T o){
        if(index<0||index>listSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i=listSize;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=o;
        listSize++;
    }

    @Override
    public void clear(){
        for(int i=0;i<listSize;i++){
            array[i]=null;
        }
        listSize=0;
    }

    @Override
    public boolean contains(T o){
        for(int i=0;i<listSize;i++){
            if(array[i].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public T get(int index){
        if(index<0||index >= listSize)
            throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public int indexOf(Object o){
        for(int i=0;i<listSize;i++){
            if(array[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty(){
        return listSize<=0;
    }

    @Override
    public int lastIndexOf(T o){
        for(int i=listSize-1;i>=0;i--){
            if(array[i].equals(o))
                return i;
        }
        return -1;

    }

    @Override
    public T remove(int index){
        if(index<0||index >= listSize)
            throw new ArrayIndexOutOfBoundsException();
        T ret=array[index];
        for(int i=index;i<listSize;i++){
            array[i]=array[i+1];
        }

        array[listSize--]=null;
        return ret;
    }

    @Override
    public boolean remove(T o){
        for(int i=0;i<listSize;i++){
            if(array[i].equals(o)){
                this.remove(i);
                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    private void expand(){
        T[] newArray=(T[]) new Object[(int)(array.length*1.5)];
        System.arraycopy(array,0,newArray,0,array.length);
        for(int i=0;i<listSize;i++){
            newArray[i]=array[i];
        }

        array=newArray;

    }

    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<listSize;i++){
            builder.append(i);
            builder.append(": ");
            builder.append(array[i]);
            builder.append("; ");

        }
        return builder.toString();
    }

    @Override
    public int size(){
        return listSize;
    }

}

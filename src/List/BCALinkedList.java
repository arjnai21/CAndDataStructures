package List;


import bca.util.BCAList;

/**************************
 *
 * Linked list implementation of BCAList
 *
 */
public class BCALinkedList implements BCAList{
    private Node head=null;
    private Node tail=null;
    private int listSize=0;

    public BCALinkedList(){

    }

    @Override
    public void add(Object o){
        Node add=new Node(o);
        if(listSize<=0){
            head=add;
            tail=add;
        }else{
            tail.next=add;
            tail=add;
        }
        listSize++;
    }

    @Override
    public void add(int index,Object o){
        if(index<0||index>listSize)
            throw new ArrayIndexOutOfBoundsException();
        Node add=new Node(o);
        if(index==0){
            head=add;
            listSize++;
            return;
        }
        Node curNode=head;
        for(int i=0;i<index-1;i++){
            curNode=curNode.next;
        }

        Node temp=curNode.next;
        curNode.next=add;
        add.next=temp;
        if(listSize==index)
            tail=add;
        listSize++;
    }

    @Override
    public void clear(){
        Node curNode=head;
        for(int i=0;i<listSize;i++){
            curNode.data=null;
            curNode=curNode.next;
        }
        listSize=0;
    }

    @Override
    public boolean contains(Object o){
        Node curNode=head;
        for(int i=0;i<listSize;i++){
            if(curNode.data.equals(o))
                return true;
            curNode=curNode.next;
        }
        return false;
    }

    @Override
    public Object get(int index){
        if(index<0||index >= listSize)
            throw new ArrayIndexOutOfBoundsException();
        Node curNode=head;
        for(int i=0;i<index;i++){
            curNode=curNode.next;
        }
        return curNode.data;
    }

    @Override
    public int indexOf(Object o){
        Node curNode=head;
        for(int i=0;i<listSize;i++){
            if(curNode.data.equals(o)){
                return i;
            }
            curNode=curNode.next;
        }
        return -1;
    }

    @Override
    public boolean isEmpty(){
        return listSize<=0;
    }

    @Override
    public int lastIndexOf(Object o){
        Node curNode=head;
        int ind=-1;
        for(int i=0;i<listSize;i++){
            if(curNode.data.equals(o))
                ind=i;
            curNode=curNode.next;
        }
        return ind;
    }

    @Override
    public Object remove(int index){

        if(index==0){
            Object ret=head.data;
            head=head.next;
            listSize--;
            return ret;

        }
        Node curNode=head;
        for(int i=0;i<index-1;i++){
            curNode=curNode.next;
        }
        Object ret=curNode.next.data;
        curNode.next=curNode.next.next;
        if(index==listSize-1){
            tail=curNode;
        }
        listSize--;
        return ret;
    }

    @Override
    public boolean remove(Object o){
        Node curNode=head;
        for(int i=0;i<listSize;i++){
            if(curNode.data.equals(o)){
                this.remove(i);
                return true;
            }
            curNode=curNode.next;
        }
        return false;
    }

    @Override
    public int size(){
        return listSize;
    }

    @Override
    public String toString(){
        Node curNode=head;
        StringBuilder s=new StringBuilder();
        for(int i=0;i<listSize;i++){
            s.append(i);
            s.append(": ");
            s.append(curNode.data);
            s.append("; ");
            curNode=curNode.next;
        }
        return s.toString();
    }

    /************************
     *
     * Node is an inner class (or nested class) for building the linked list.
     * BCALinkedList can use it but it is not obviously accessible to other classes.
     * (We can use "private" to hide it from outside classes, but we will leave it accessible)
     */
    private class Node{
        Object data=null;
        Node next=null;

        public Node(Object o){
            data=o;
        }
    }
}

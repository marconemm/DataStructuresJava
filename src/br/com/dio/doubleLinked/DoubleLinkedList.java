package br.com.dio.doubleLinked;

import br.com.dio.models.DoubleNode;

public class DoubleLinkedList<T> {

    private DoubleNode<T> firstNode;
    private DoubleNode<T> lastNode;
    private int length;

    public DoubleLinkedList() {
        firstNode = null;
        lastNode = null;
        length = 0;
    }

    DoubleNode<T> getNode(int index){
        final int maxIndex = length-1;
        final int minIndex = -(length);

        if (index != 0 && (index > maxIndex || index < minIndex)){
            throw new IndexOutOfBoundsException("The max index to this list must be an \"int\" between: " + minIndex + " and " + maxIndex);
        }

        DoubleNode<T> result;
        if (index >= 0) {
        	result = firstNode;
        	
        	for (int i = 0; i < index; i++) {
        		result = result.getNextNode();
        	}
        } else {
        	result = lastNode;
        	index = (index * -1) - 1;
        	
        	for (int i = 0; i < index; i++) {
        		result = result.getPrevNode();
        	}        	
        }

        return  result;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty(){
        return (firstNode == null || lastNode == null);
    }

    public T get(int index){
        return getNode(index).getValue();
    }
    
    public int add(DoubleNode<T> newNode) {
    	
    	 if (isEmpty()){
    		 firstNode = newNode;
             lastNode = newNode;
         } else {        	 
        	 lastNode.setNextNode(newNode);    	 
        	 newNode.setPrevNode(lastNode);
        	 lastNode = newNode;  	
         }
    	
    	return ++length;
	}

    public int add(DoubleNode<T> newNode, int index) {
    	
        if (isEmpty()){
            firstNode = newNode;
            lastNode = newNode;            
        } else {
        	DoubleNode<T> auxNode = (index >= 0) ? getNode(index) : getNode(index + 1);
        	
        	if(index == 0) {
    			auxNode.setPrevNode(newNode);
    			newNode.setNextNode(auxNode);
    			firstNode = newNode;    			
        	}else if (index == -1) {
        		auxNode.setNextNode(newNode);
        		newNode.setPrevNode(auxNode);
        		lastNode = newNode;
    		} else {
    			newNode.setPrevNode(auxNode.getPrevNode());
    			auxNode.getPrevNode().setNextNode(newNode);
    			auxNode.setPrevNode(newNode);
    			newNode.setNextNode(auxNode);
    		}
        }        
        return ++length;
    }

	public T remove(int index) {
		
		if (!isEmpty()){
            
        	DoubleNode<T> auxNode = (index >= 0) ? getNode(index) : getNode(index);
        	T result = auxNode.getValue();
        	
        	if(index == 0) {
    			auxNode.getNextNode().setPrevNode(null);
    			firstNode = auxNode.getNextNode();  			
        	}else if (index == -1) {
        		auxNode.getPrevNode().setNextNode(null);
        		lastNode = auxNode.getPrevNode();
    		} else {
    			auxNode.getPrevNode().setNextNode(auxNode.getNextNode());
    			auxNode.getNextNode().setPrevNode(auxNode.getPrevNode());
    		}
        	
        	auxNode = null;
        	length--;
        	
        	return result;
        }
		
		return null;
	}
    @Override
	public String toString() {
    	if (firstNode == null) {
    		return "[]";
    	}
    	
    	DoubleNode<T> auxNode = firstNode;
    	String result = "[";
    	
    	while (auxNode.getNextNode() != null) {
    		result += auxNode.getValue() + ", ";
    		auxNode = auxNode.getNextNode();
    		}
    	
    	result += auxNode.getValue() + ", ";
    	
    	result = result.substring(0, result.length() - 2);
    	
    	result += "]";
    			
		return result;
	}
    
    
}

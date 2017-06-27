package kenny.algorithm.container.list_container;

class Node{
	int value;
	Node pNext;
}

public class SimpleLinkedList {

	Node pHeader = null;

	// add a new node at the end
	public void addNodeAtEnd(int value){
		if(pHeader == null){
			pHeader = new Node();
			pHeader.value = value;
			pHeader.pNext = null;
			System.out.print("Node:"+value+" ");
		} else {
			Node pCurrent = pHeader;
			while(pCurrent.pNext != null){
				pCurrent = pCurrent.pNext;
			}
			pCurrent.pNext = new Node();
			pCurrent.pNext.value = value;
			pCurrent.pNext.pNext = null;
			System.out.print("Node:"+value+" ");
		}
	}

	public void addNodeBehindOneNode(int nodeValue, int value){
		Node pCurrent = pHeader;
		while(pCurrent != null){
			if(pCurrent.value == nodeValue){
				Node pTemp = pCurrent.pNext;
				pCurrent.pNext = new Node();
				pCurrent.pNext.value = value;
				pCurrent.pNext.pNext = pTemp;
				return;
			} else {
				pCurrent = pCurrent.pNext;
			}
		}
		System.out.print("can't find nodeValue " + nodeValue);
		System.out.println();
	}
	
	public void showList(){
		Node pCurrent = pHeader;
		while(pCurrent != null){
			System.out.print("NodeValue:"+pCurrent.value+" | ");
			pCurrent = pCurrent.pNext;
		}
	}
	

	public static void main(String[] args) {

		SimpleLinkedList list = new SimpleLinkedList();
		for(int i = 0; i < 10; i++){
			list.addNodeAtEnd(i);
		}
		System.out.println();
		list.showList();
		System.out.println();
		list.addNodeBehindOneNode(63, 87);
		//System.out.println();
		list.showList();
	}

}

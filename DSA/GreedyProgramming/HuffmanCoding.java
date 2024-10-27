//Huffamn Coding

//The idea is to assign variable-length codes to input characters, lengths of the assigned codes are based on the frequencies of corresponding characters.
//The variable length codes assigned to input characters are Prefix codes.
//The code assigned to one character is not the prefix of code assigned to any other character.

import java.util.Comparator; 
import java.util.PriorityQueue;

class HuffmanCoding{

	class HuffmanNode{
		int data;
		char c;
		HuffmanNode left;
		HuffmanNode right;
	}

	class MyComparator implements Comparator<HuffmanNode>{
		public int compare(HuffmanNode x, HuffmanNode y){
			return x.data - y.data;
		} 
	}

	public void printVariableCodes(HuffmanNode r, String s){
		if(r.left == null && r.right == null && Character.isLetter(r.c)){
			System.out.println(r.c + " : " + s);
			return;
		}
		printVariableCodes(r.left, s+"0");
		printVariableCodes(r.right, s+"1");
	}

	public void buildHuffmanTree(char[] charArray, int[] charFreq){
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(charArray.length, new MyComparator());
		//create a leaf node and build a min heap of all leaf nodes. Initially, the least frequent character is at root.
		for(int i=0;i<charArray.length;i++){
			HuffmanNode hn = new HuffmanNode();
			hn.c = charArray[i];
			hn.data = charFreq[i];
			hn.left = null;
			hn.right = null;
			pq.add(hn);
		}
		HuffmanNode root = null;
		while(pq.size() > 1){
			//extract two nodes with min freq from the min heap
			HuffmanNode x = pq.peek();
			pq.poll();
			HuffmanNode y = pq.peek();
			pq.poll();
			//create an internal node with a freq equal to the sum of freq of extracted nodes. 
			HuffmanNode f = new HuffmanNode();
			f.data = x.data + y.data;
			f.c = '-';
			f.left = x;
			f.right = y;
			root =f;
			pq.add(f);
		}
		//the loop iterates until there exists only one node(root node holding the tree) in the queue	
		printVariableCodes(root, "");
	}

	public static void main(String[] args){
		char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
		int[] charFreq = {12, 2, 7, 13, 14, 85};
		HuffmanCoding hc = new HuffmanCoding();
		hc.buildHuffmanTree(charArray, charFreq);
	}
}
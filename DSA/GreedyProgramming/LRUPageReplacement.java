//Least Recently Used Page replacement algorithm

//Given a sequence of pages in an array pages[] of length N and memory capacity C, find the number of page faults using Least Recently Used (LRU) Algorithm. 

//Sol: Create a LinkedHashSet fo size capacity to store the pages in the memory.
//Iterate over each page, if page is not present in the memory then inc pagefault, if memory is full then remove first entry(since we insert new into entry)
//Else if page is present in memory then also remove that entry to add again as recently used.
//In either condition, add the page into memory.

import java.util.LinkedHashSet;
import java.util.Iterator;

class LRUPageReplacement{

	public static int getPageFaults(int[] pages, int c){
		int res =0;
		LinkedHashSet<Integer> memory = new LinkedHashSet<>(c);
		//LinkedHashSet is an ordered version of the hashSet that maintains a doubly linkedlist across all the elements. 
		//It lets us iterate through the elements in the order in which they were inserted.
		//Extends HashSet class and implements Set interface.
		for(int i=0;i<pages.length;i++){
			if(!memory.contains(pages[i])){
				res++;
				if(memory.size()==c){
					Iterator<Integer> it = memory.iterator();
					it.next();
					it.remove();
				}
			}
			else{
				memory.remove(pages[i]);
			}
			memory.add(pages[i]);
		}
		return res;

	}

	public static void main(String[] args){
		int[] pages = {2, 3, 1, 3, 1, 3, 1, 2};
		System.out.println(getPageFaults(pages, 3));
	}
}
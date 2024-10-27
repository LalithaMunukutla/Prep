//You are given two arrays, start and end each of size N.
//For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. 
//Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time. 

//Create a collection of start time, end time, position. 
//Sort the collection wrt end time, if same end time consider position
//Populate res list with positions which has start time great than prev entry's end time.


import java.util.*;

class NMeetingsInOneRoom{

	class Meeting{
		int s;
		int e;
		int pos;

		Meeting(int s, int e, int pos){
			this.s =s;
			this.e =e;
			this.pos =pos;
		}
	}

	class MeetingComparator implements Comparator<Meeting>{
		public int compare(Meeting m1, Meeting m2){
			if(m1.e <m2.e){
				return -1;
			}
			else if(m1.e >m2.e){
				return 1;
			}
			else if(m1.pos <m2.pos){
				return -1;
			}
			return 1;
		}
	}

	public void getAllMeetings(int[] start, int[] end){
		List<Meeting> mList = new ArrayList<>();
		for(int i=0;i<start.length;i++){
			mList.add(new Meeting(start[i], end[i], i+1));
		}
		Collections.sort(mList, new MeetingComparator());
		List<Integer> res = new ArrayList<>();
		res.add(mList.get(0).pos);
		int limit = mList.get(0).e;
		for(int i=1;i<start.length;i++){
			if(mList.get(i).s>limit){
				limit = mList.get(i).e;
				res.add(mList.get(i).pos);
			}
		}

		for(int i=0;i<res.size();i++){
			System.out.print("(" + mList.get(res.get(i)-1).s +", " + mList.get(res.get(i)-1).e + ") ");
		}
	}

	public static void main(String[] args){
		int[] start = {1,3,0,5,8,5};
		int[] end = {2,4,5,7,9,9};
		NMeetingsInOneRoom nm = new NMeetingsInOneRoom();
		nm.getAllMeetings(start, end);
	}
}
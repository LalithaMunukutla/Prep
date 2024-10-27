//Job Sequencing Problem

//a set of N jobs where each job comes with a deadline and profit. The profit can only be earned upon completing the job within its deadline. 
//Find the number of jobs done and the maximum profit that can be obtained. Each job takes a single unit of time and only one job can be performed at a time.

//Sort the jobs based on profit. Initialise an array of size max deadline of the jobs with -1 to track the job schedules.
//For each job, check in the schedule array if that slot is already taken starting fom its deadline to 0. 
//If slot is available, then increment jobs count and add that job's profit to the return result.

import java.util.Arrays;

class JobSequencing{

	class Job{
		int id;
		int deadline;
		int profit;
		Job(int id, int deadline, int profit){
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}

	public int[] getJobSequence(Job[] jobs){
		Arrays.sort(jobs, (a,b) -> (b.profit-a.profit));
		int[] res = new int[2];
		int maxTime = 0;
		for(int i=0; i<jobs.length;i++){
			maxTime = Math.max(maxTime, jobs[i].deadline);
		}
		int[] schedule = new int[maxTime+1];
		for(int i=1;i<schedule.length;i++){
			schedule[i] = -1;
		}
		int countJobs =0, maxProfit =0;
		for(int i=0;i<jobs.length;i++){
			for(int j=jobs[i].deadline;j>0;j--){
				if(schedule[j]==-1){
					schedule[j]=i;
					countJobs++;
					maxProfit+=jobs[i].profit;
					break;
				}
			}
		}
		res[0]=countJobs;
		res[1]=maxProfit;
		return res;
	}

	public static void main(String[] args){
		JobSequencing js = new JobSequencing();
		Job[] jobs = {js.new Job(1,4,20),js.new Job(2,1,10),js.new Job(3,1,40),js.new Job(4,1,30)};
		int[] res = js.getJobSequence(jobs);
		System.out.println(res[0] + " " + res[1]);
	}
}
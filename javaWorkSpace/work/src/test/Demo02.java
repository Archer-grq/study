package test;

@SuppressWarnings("all")
public class Demo02 {
	
	public static void main(String[] args) {
		
		int[][] lists={{0,11,12,13,14,15},{0,0,5,10,15,20},{0,2,10,30,32,40},{0,20,21,22,23,24}};
		int[] ma=new int[lists.length+1];
		int[] max =new int[lists.length+1];
		ma[ma.length-1]=0;
		
		max=getMax(5, 0, lists, ma, max);
		for(int i:max) {
			System.out.print(i+" ");
		}
	}
	
	public static int[] getMax(int restMoney,int i,int[][] lists,int[] ma,int[] max) {
		if(i==lists.length-1) {
			ma[i]=restMoney;
			ma[i+1]=0;
			for(int m=0;m<ma.length-1;m++) {
				ma[i+1]+=lists[m][ma[m]];
			}
			if(ma[i+1]>max[i+1]) {
				for(int b=0;b<ma.length;b++) {
					max[b]=ma[b];
				}
			}
			return max;
		}else {
			for(int j=0;j<=restMoney;j++) {
				ma[i]=j;
				max=getMax(restMoney-j, i+1, lists, ma,max);
			}
			return max;
		}
	}
}

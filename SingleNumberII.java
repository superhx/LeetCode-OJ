public class SingleNumberII {
	public int singleNumber(int[] A) {
		int[] count=new int[32];
		int res=0;
		for(int i=0;i<32;i++){
			count[i]=0;
			for(int a:A)
				if(((a>>i)&1)==1)
					++count[i];
			res|=(count[i]%3)<<i;
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] A={1,1,1,3};
	}
}
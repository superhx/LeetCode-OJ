public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int gasInCar=0;
    	int stationNum=gas.length;
    	boolean isCircle;
    	for(int i=0;i<stationNum;i++){
    		isCircle=true;
    		gasInCar=0;
    		for(int j=0;j<stationNum;j++){
    			int station=(i+j)%stationNum;
    			gasInCar+=gas[station];
    			if(gasInCar<cost[station]){
    				isCircle=false;
    				break;
    			}
    			else
    				gasInCar-=cost[station];
    		}
    		if(isCircle)
    			return i;
    	}
        return -1;
    }
}
package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int nodeNum=rowIndex+1;
        List<Integer> row=new ArrayList<Integer>(nodeNum);

        int half=(nodeNum+1)/2;
        int prevNode=1;
        row.add(prevNode);
        for(int i=1;i<half;i++){
            int node= (int) (prevNode/((double)i)*(nodeNum-i)+0.5);
            row.add(node);
            prevNode=node;
        }
        for(int i=nodeNum%2==0?half-1:half-2;i>=0;i--){
            row.add(row.get(i));
        }
        return row;
    }
}
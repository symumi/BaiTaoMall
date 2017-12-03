package team.jmu.pojo;

import java.util.ArrayList;

public class ListNum extends ArrayList<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
             public ListNum(int fir,int sec){
            	 int rem = fir%sec;
            	 int theNum = fir/sec;
            	 if(rem!=0){
            		 theNum++;
            	 }
            	 Integer j;
            	 for(int i=0;i<theNum;i++ ){
            		 j = new Integer(i);
            		 this.add(j);
            	 }
             }
}

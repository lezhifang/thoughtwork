package main.java;

public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
    	int n = 10;//代表格子总数
    	String[] bowGridTmp = bowlingCode.split("\\|");//实现以"|"这个划分
        int cunt = 0;//用来计算空字符串个数
        for(int i = 0; i < bowGridTmp.length; i++){
        	if(bowGridTmp[i].equals("")){
        		cunt++;
        	}
        }
        
        String[] bowGrid = new String[bowGridTmp.length-cunt];
        for(int i = 0,j = 0; i < bowGridTmp.length; i++){
        	if(!bowGridTmp[i].equals("")){
        		bowGrid[j++] = bowGridTmp[i];
        	}
        }
       int sum = 0;//总分
       for(int i = 0; i < n-2; i++){
    	   int GridScore = 0;
    	   int iTmp = i;
    	 //第1种情况
    	   if(bowGrid[iTmp].equals("X")){//第一重判断
    		   GridScore += 10;
    		   iTmp++;
    		   
    		   if(bowGrid[iTmp].equals("X")){//第二重判断
    			   GridScore += 10;
        		   iTmp++;
        		   
        		   if(bowGrid[iTmp].equals("X")){//第三重判断
        			   GridScore += 10;
            		   //iTmp++;
        		   }else{
        			   if((bowGrid[iTmp].charAt(0))>='1'&&(bowGrid[iTmp].charAt(0))<='9'){
        				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(0))+""));
        			   }
        		   }//第三重判断结束
    		   }else{
    			   if((bowGrid[iTmp].charAt(1))=='/'){
    				   GridScore += 10;
    			   }else{
    				   for(int l=0;l<2;l++){
    					   if((bowGrid[iTmp].charAt(l))>='1'&&(bowGrid[iTmp].charAt(l))<='9')
            				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(l))+""));
    				   }
    			   }
    		   }//第二重判断结束
    		   
    	   }else{//第2种情况
    		   if((bowGrid[iTmp].charAt(1))=='/'){//第一重判断
    			   GridScore += 10;
    			   iTmp++;
    			   if(bowGrid[iTmp].equals("X")){//第二重判断
    				   GridScore += 10;
    			   }else{
    				   if((bowGrid[iTmp].charAt(0))>='1'&&(bowGrid[iTmp].charAt(0))<='9')
        				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(0))+""));
    			   }//第二重判断结束
    		   
    		   }else{//第3种情况
    			   for(int l=0;l<2;l++){
					   if((bowGrid[iTmp].charAt(l))>='1'&&(bowGrid[iTmp].charAt(l))<='9')
        				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(l))+""));
				   }
    		   }
    	   }//第一重判断结束
    	   
    	   sum += GridScore;
       }
       
       
       
       for(int i = n-2; i < n; i++){
    	   int GridScore = 0;
    	   int iTmp = i;
    	   if(bowGrid[n-1].equals("X")){//2次额外机会
    		   if(i != (n-1)){
    			   if(bowGrid[iTmp].equals("X")){
    				   GridScore += 20;
        			   iTmp += 2;
        			   if(bowGrid[iTmp].charAt(0)=='X'){
        				   GridScore += 10;
        			   }else{
        				   if((bowGrid[iTmp].charAt(0))>='1'&&(bowGrid[iTmp].charAt(0))<='9')
            				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(0))+""));
        			   }
    			   }else{
    				   if((bowGrid[iTmp].charAt(1))=='/'){
    					   GridScore += 20;
    				   }else{
    					   for(int l=0;l<2;l++){
        					   if((bowGrid[iTmp].charAt(l))>='1'&&(bowGrid[iTmp].charAt(l))<='9')
                				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(l))+""));
        				   }
    				   }
    			   }
    			  
    		   }else{//i == (n-1)
    			   GridScore += 10;
    			   iTmp++;
    			   for(int l=0;l<2;l++){
					   if(bowGrid[iTmp].charAt(l)=='X'){
						   GridScore += 10;
					   }else{
						   if((bowGrid[iTmp].charAt(l))>='1'&&(bowGrid[iTmp].charAt(l))<='9'){
							   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(l))+""));
						   }
					   }
				   }
    		   }//2次额外机会结束
    		 
    	   }else{
    		   if((bowGrid[n-1].charAt(1))=='/'){//1次额外机会
    			   if(i != (n-1)){
    				   if(bowGrid[iTmp].equals("X")){
    					   GridScore += 20;
        			   }else{
        				   if((bowGrid[iTmp].charAt(1))=='/'){
        					   GridScore += 10;
        					   iTmp++;
        					   if((bowGrid[iTmp].charAt(0))>='1'&&(bowGrid[iTmp].charAt(0))<='9')
                				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(0))+""));
        				   }else{
        					   for(int l=0;l<2;l++){
            					   if((bowGrid[iTmp].charAt(l))>='1'&&(bowGrid[iTmp].charAt(l))<='9')
                    				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(l))+""));
            				   }
        				   }
        			   }
    			   }else{//i == (n-1)
    				   GridScore += 10;
    				   iTmp++;
    				   if(bowGrid[iTmp].equals("X")){
						   GridScore += 10;
					   }else{
						   if((bowGrid[iTmp].charAt(0))>='1'&&(bowGrid[iTmp].charAt(0))<='9'){
							   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(0))+""));
						   }
					   }
    			   }
    			   
    		   }else{//没有额外机会
    			   if(i != (n-1)){
    				   if(bowGrid[iTmp].equals("X")){
    					   GridScore += 10;
    					   iTmp++;
    					   for(int l=0;l<2;l++){
        					   if((bowGrid[iTmp].charAt(l))>='1'&&(bowGrid[iTmp].charAt(l))<='9')
                				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(l))+""));
        				   }
        			   }else{
        				   if((bowGrid[iTmp].charAt(1))=='/'){
        					   GridScore += 10;
        					   iTmp++;
        					   if((bowGrid[iTmp].charAt(0))>='1'&&(bowGrid[iTmp].charAt(0))<='9')
                				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(0))+""));
        				   }else{
        					   for(int l=0;l<2;l++){
            					   if((bowGrid[iTmp].charAt(l))>='1'&&(bowGrid[iTmp].charAt(l))<='9')
                    				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(l))+""));
            				   }
        				   }
        			   } 
    			   }else{//i == (n-1)
    				   for(int l=0;l<2;l++){
    					   if((bowGrid[iTmp].charAt(l))>='1'&&(bowGrid[iTmp].charAt(l))<='9')
            				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(l))+""));
    				   }
    			   }
    		   }
    	   }
    	   
    	   
    	   sum += GridScore;
       }
        
        return sum;
    }
}

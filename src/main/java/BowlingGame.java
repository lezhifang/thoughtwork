package main.java;

public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
    	int n = 10;//�����������
    	String[] bowGridTmp = bowlingCode.split("\\|");//ʵ����"|"�������
        int cunt = 0;//����������ַ�������
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
       int sum = 0;//�ܷ�
       for(int i = 0; i < n-2; i++){
    	   int GridScore = 0;
    	   int iTmp = i;
    	 //��1�����
    	   if(bowGrid[iTmp].equals("X")){//��һ���ж�
    		   GridScore += 10;
    		   iTmp++;
    		   
    		   if(bowGrid[iTmp].equals("X")){//�ڶ����ж�
    			   GridScore += 10;
        		   iTmp++;
        		   
        		   if(bowGrid[iTmp].equals("X")){//�������ж�
        			   GridScore += 10;
            		   //iTmp++;
        		   }else{
        			   if((bowGrid[iTmp].charAt(0))>='1'&&(bowGrid[iTmp].charAt(0))<='9'){
        				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(0))+""));
        			   }
        		   }//�������жϽ���
    		   }else{
    			   if((bowGrid[iTmp].charAt(1))=='/'){
    				   GridScore += 10;
    			   }else{
    				   for(int l=0;l<2;l++){
    					   if((bowGrid[iTmp].charAt(l))>='1'&&(bowGrid[iTmp].charAt(l))<='9')
            				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(l))+""));
    				   }
    			   }
    		   }//�ڶ����жϽ���
    		   
    	   }else{//��2�����
    		   if((bowGrid[iTmp].charAt(1))=='/'){//��һ���ж�
    			   GridScore += 10;
    			   iTmp++;
    			   if(bowGrid[iTmp].equals("X")){//�ڶ����ж�
    				   GridScore += 10;
    			   }else{
    				   if((bowGrid[iTmp].charAt(0))>='1'&&(bowGrid[iTmp].charAt(0))<='9')
        				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(0))+""));
    			   }//�ڶ����жϽ���
    		   
    		   }else{//��3�����
    			   for(int l=0;l<2;l++){
					   if((bowGrid[iTmp].charAt(l))>='1'&&(bowGrid[iTmp].charAt(l))<='9')
        				   GridScore += (Integer.parseInt((bowGrid[iTmp].charAt(l))+""));
				   }
    		   }
    	   }//��һ���жϽ���
    	   
    	   sum += GridScore;
       }
       
       
       
       for(int i = n-2; i < n; i++){
    	   int GridScore = 0;
    	   int iTmp = i;
    	   if(bowGrid[n-1].equals("X")){//2�ζ������
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
    		   }//2�ζ���������
    		 
    	   }else{
    		   if((bowGrid[n-1].charAt(1))=='/'){//1�ζ������
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
    			   
    		   }else{//û�ж������
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

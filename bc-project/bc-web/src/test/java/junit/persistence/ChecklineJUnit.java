package junit.persistence;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bc.saas.persistence.Pk10Mapper;
import org.bc.saas.persistence.entity.Pk10;
import org.bc.saas.service.Pk10Service;
import org.bc.saas.util.SendTools;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import junit.BaseJUnit;

/**
 * @author : R&M www.rmworking.com/blog
 *         2018/4/24 14:28
 *         saas-base-organization
 *         com.ikang.saas.junit.persistence
 */
public class ChecklineJUnit extends BaseJUnit{
 
    @Autowired
    private Pk10Mapper pk10Mapper;
   @Autowired
   Pk10Service pk10Service;
    @Test
    public void insert(){
    	List list=new ArrayList();
    	
    	for(int j=693666;j>693636;j--){
    		List m=new ArrayList();
    		Map qs=new HashMap();
    		String t=String.valueOf(j).toString();
    		m.add(t.substring(t.length()-2, t.length()));
        for(int i=1;i<11;i++){
    	 Pk10 a=   pk10Mapper.findiscx(String.valueOf(i),j,5);
    	 if(a!=null)  m.add("热");//System.out.println("============="+i+"===热==============");
    	 else         m.add("冷");//System.out.println("============="+i+"===冷==============");
   
        }
     list.add(m);
    	}
    	
    	
    	for(int k=0;k<list.size();k++){
    		
    		System.out.println(list.get(k).toString());
    		
    	}
    }
     
    @Test 
    public void aaa(){
    	List plist=new ArrayList();
    	List<Pk10> aaa=pk10Mapper.findallid();
       	int kk=6;
       	int test1=0;
       	String param="";
       	for(int u=0;u<aaa.size()-20;u++){
    	for(int m=u;m<u+6;m++){
    			param=param+aaa.get(m).getId()+",";
    		   test1=test1+1;
    		   if(test1==kk){
    			test1=0;
    			System.out.println(param);
    			plist.add(param.substring(0,param.length()-1));
    			param="";
    			
    		}
    	}
       	}
    }
    @Test
    public void csqs(){
    	
    	

    	
    	  Map t = new HashMap();
    	  for(int j=6;j<21;j++){
    	  String pp="5";
    	  int cs=j;
    	  

      	List plist=new ArrayList();
      	List<Pk10> aaa=pk10Mapper.findallid();
         	int kk=j;
         	int test1=0;
         	String param="";
         	for(int u=0;u<aaa.size()-20;u++){
      	      for(int m=u;m<u+6;m++){
      			param=param+aaa.get(m).getId()+",";
      		   test1=test1+1;
      		   if(test1==kk){
      			test1=0;
      			System.out.println(param);
      			plist.add(param.substring(0,param.length()-1));
      			param="";
      			
      		}
      	}
         	}
      
    	  
    	  for(int i=0;i<plist.size();i++){    
    	    
    	     
    	      
    	      String ddddd=plist.get(i).toString();
    	      String dddd=ddddd.substring(0,ddddd.indexOf(","));
    	      List<Pk10> dsqbc111 = this.pk10Mapper.finddsqwc(dddd,plist.get(i).toString(),j);
    	      Pk10 f= dsqbc111.get(0);
    	      Pk10 ddd=new Pk10();
    	      if(f.getNumber1().equals(pp))ddd.setNumber1(pp);else  ddd.setNumber1("");
    	      if(f.getNumber2().equals(pp))ddd.setNumber2(pp);else  ddd.setNumber2("");
    	      if(f.getNumber3().equals(pp))ddd.setNumber3(pp);else  ddd.setNumber3("");
    	      if(f.getNumber4().equals(pp))ddd.setNumber4(pp);else  ddd.setNumber4("");
    	      if(f.getNumber5().equals(pp))ddd.setNumber5(pp);else  ddd.setNumber5("");
    	      if(f.getNumber6().equals(pp))ddd.setNumber6(pp);else  ddd.setNumber6("");
    	      if(f.getNumber7().equals(pp))ddd.setNumber7(pp);else  ddd.setNumber7("");
    	      if(f.getNumber8().equals(pp))ddd.setNumber8(pp);else  ddd.setNumber8("");
    	      if(f.getNumber9().equals(pp))ddd.setNumber9(pp);else  ddd.setNumber9("");
    	      if(f.getNumber10().equals(pp))ddd.setNumber10(pp);else  ddd.setNumber10("");
    	     
    	      ddd.setId(Integer.valueOf(dddd));
    	      ddd.setQs(j);
    	      if(j==6) pk10Mapper.insertpk10wc6(ddd);
    	      if(j==7) pk10Mapper.insertpk10wc7(ddd);
    	      if(j==8) pk10Mapper.insertpk10wc8(ddd);
    	      if(j==9) pk10Mapper.insertpk10wc9(ddd);
    	      if(j==10) pk10Mapper.insertpk10wc10(ddd);
    	      if(j==11) pk10Mapper.insertpk10wc11(ddd);
    	      if(j==12) pk10Mapper.insertpk10wc12(ddd);
    	      if(j==13) pk10Mapper.insertpk10wc13(ddd);
    	      if(j==14) pk10Mapper.insertpk10wc14(ddd);
    	      if(j==15) pk10Mapper.insertpk10wc15(ddd);
    	      if(j==16) pk10Mapper.insertpk10wc16(ddd);
    	      if(j==17) pk10Mapper.insertpk10wc17(ddd);
    	      if(j==18) pk10Mapper.insertpk10wc18(ddd);
    	      if(j==19) pk10Mapper.insertpk10wc19(ddd);
    	      if(j==20) pk10Mapper.insertpk10wc20(ddd);
    	       
    	     
    	      
    	    }
    	  
    	  }
    }
    
    @Test
    public void cslr(){
    	
		for (int i = 694407; i >= 694407 - 10; i--) {
			Map instM = new HashMap();
			for (int j = 1; j < 11; j++) {
				List<Map> list = pk10Mapper.selectlr(j, i-5, i );
				String col = "";
				for (int k = 0; k < list.size(); k++) {
					Map m = list.get(k);
					col = col + m.get("number" + j) + ",";
				}
				instM.put("number" + j, col.substring(0, col.length() - 1));
			}
			Pk10 ddd=pk10Mapper.selectByPrimaryKeypk10lrh(i+1);
			if(ddd==null){
			instM.put("id", i+1);
			pk10Mapper.pk10lrh(instM);
			}
			
		}
    	
    	
    }
}

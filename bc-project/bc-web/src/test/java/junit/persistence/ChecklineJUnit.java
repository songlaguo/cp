package junit.persistence;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bc.saas.persistence.Pk10Mapper;
import org.bc.saas.persistence.entity.Pk10;
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
     
}

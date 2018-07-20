package org.bc.saas.service;


 
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.bc.saas.persistence.Pk10Mapper;
import org.bc.saas.persistence.entity.Pk10;
import org.bc.saas.util.SendTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor={Exception.class})
public class Pk10Service
{
  private final Pk10Mapper pk10Mapper;
  
  @Autowired
  public Pk10Service(Pk10Mapper pk10Mapper)
  {
    this.pk10Mapper = pk10Mapper;
  }
  
  private int fsguok = 0;
  private int num = 1;
  
  @Scheduled(cron="0 0/1 * * * ?")
  public void timerToNow()
    throws Exception
  {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date now = new Date();
    String sdate1 = sdf1.format(now) + " 09:00:00";
    String sdate2 = sdf1.format(now) + " 23:58:00";
    Date data1 = sdf2.parse(sdate1);
    Date data2 = sdf2.parse(sdate2);
    if ((data1.getTime() < now.getTime()) && (data2.getTime() > now.getTime()))
    {
      System.out.println("-----------------执行了:" + sdf2.format(now));
    querypk10();
    }
    else
    {
      this.fsguok = 0;
    }
  }
  
  public boolean querypk10()
    throws Exception
  {
    Date a = new Date();
    Pk10 cpmax = this.pk10Mapper.findMaxIdData();
    Date maxDate = cpmax.getDateline();
    long interval = (a.getTime() - maxDate.getTime()) / 1000L / 60L;
    if (interval > 6L) {
      this.num = 50;
    } else {
      this.num = 1;
    }
    insertpk10();
    
    return false;
  }
  
  public void insertpk10()
    throws Exception
  {
    String name = "bjpks";
    String uid = "1029836";
    String token = "d36b9a7224e4cfda202f5a2b4b1d6b3486e22757";
    String url = "http://api.caipiaokong.com/lottery/";
    JSONObject object = SendTools.getCpData(name, uid, token, this.num);
    try
    {
      Iterator it = object.keys();
      while (it.hasNext())
      {
        String key = (String)it.next();
        String value = object.getString(key);
        JSONObject object1 = JSONObject.fromObject(value);
        String outputStr = "id:" + key;
        outputStr = outputStr + " number:" + object1.getString("number");
        outputStr = outputStr + " dateline:" + object1.getString("dateline");
        System.out.println(outputStr);
        String numbers = object1.getString("number");
        String[] numberList = numbers.split(",");
        Pk10 cp = new Pk10();
        cp.setId(Integer.valueOf(Integer.valueOf(key).intValue()));
        cp.setNumber1(numberList[0]);
        cp.setNumber2(numberList[1]);
        cp.setNumber3(numberList[2]);
        cp.setNumber4(numberList[3]);
        cp.setNumber5(numberList[4]);
        cp.setNumber6(numberList[5]);
        cp.setNumber7(numberList[6]);
        cp.setNumber8(numberList[7]);
        cp.setNumber9(numberList[8]);
        cp.setNumber10(numberList[9]);
        String date1 = object1.getString("dateline");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cp.setDateline(sdf.parse(date1));
        Pk10 czcp = this.pk10Mapper.selectByPrimaryKey(Integer.valueOf(Integer.valueOf(key).intValue()));
        if (czcp == null) {
          this.pk10Mapper.insert(cp);
        }
      }
      List<Pk10> listcp = this.pk10Mapper.selectPk10List(Integer.valueOf(10));
      pdPk10(listcp);
    }
    catch (JSONException e)
    {
      e.printStackTrace();
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
  }
  
  public void pdPk10(List<Pk10> listcp)
    throws Exception
  {
    Map t = new HashMap();
    String mes = "";
    int maxid = this.pk10Mapper.findMax();
    if ((this.fsguok != 0) && (this.fsguok == maxid))
    {
      System.out.println("=========发送过了======" + mes);
      return;
    }
    String mes18_5 = "";
    mes18_5 = analysisPk10(maxid, mes18_5, 17, 5, t);
    mes = mes + mes18_5;
    System.out.println("==18期没有出现的===" + mes18_5);
    String mes17_5 = "";
    mes17_5 = analysisPk10(maxid, mes17_5, 17, 5, t);
    mes = mes + mes17_5;
    System.out.println("==17期没有出现的===" + mes17_5);
    String mes16_5 = "";
    mes16_5 = analysisPk10(maxid, mes16_5, 16, 5, t);
    mes = mes + mes16_5;
    System.out.println("==16期没有出现的===" + mes16_5);
    String mes15_5 = "";
    mes15_5 = analysisPk10(maxid, mes15_5, 15, 5, t);
    mes = mes + mes15_5;
    System.out.println("==15期没有出现的===" + mes15_5);
    String mes14_5 = "";
    mes14_5 = analysisPk10(maxid, mes14_5, 14, 5, t);
    mes = mes + mes14_5;
    System.out.println("==14期没有出现的===" + mes14_5);
  
    String mes13_5 = "";
    mes13_5 = analysisPk10(maxid, mes13_5, 13, 5, t);
    mes = mes + mes13_5;
    System.out.println("==13期没有出现的===" + mes13_5);
    
    String mes12_5 = "";
    mes12_5 = analysisPk10(maxid, mes12_5, 12, 5, t);
    mes = mes + mes12_5;
    System.out.println("==12期没有出现的===" + mes12_5);
    
    String mes11_5 = "";
    mes11_5 = analysisPk10(maxid, mes11_5, 11, 5, t);
    mes = mes + mes11_5;
    System.out.println("==11期没有出现的===" + mes11_5);
    /*  
    String mes10_5 = "";
    mes10_5 = analysisPk10(maxid, mes10_5, 10, 5, t);
    mes = mes + mes10_5;
    System.out.println("==10期没有出现的===" + mes10_5);
    
    String mes9_5 = "";
    mes9_5 = analysisPk10(maxid, mes9_5, 9, 5, t);
    mes = mes + mes9_5;
    System.out.println("==9期没有出现的===" + mes9_5);
    
    String mes8_5 = "";
    mes8_5 = analysisPk10(maxid, mes8_5, 8, 5, t);
    mes = mes + mes8_5;
    System.out.println("==7期没有出现的===" + mes8_5);
    if (mes != "") {
      mes = mes + "\r\n=============\r\n";
    }*/
    String mes12_6 = "";
    mes12_6 = analysisPk10(maxid, mes12_6, 12, 4, t);
    mes = mes + mes12_6;
    System.out.println("==12期没有出现的===" + mes12_6);
    /*  
    String mes11_6 = "";
    mes11_6 = analysisPk10(maxid, mes11_6, 11, 4, t);
    mes = mes + mes11_6;
    System.out.println("==11期没有出现的===" + mes11_6);
    
    String mes110_6 = "";
    mes110_6 = analysisPk10(maxid, mes110_6, 10, 4, t);
    mes = mes + mes110_6;
    System.out.println("==10期没有出现的===" + mes110_6);
    
    String mes9_6 = "";
    mes9_6 = analysisPk10(maxid, mes9_6, 9, 4, t);
    mes = mes + mes9_6;
    System.out.println("==9期没有出现的===" + mes9_6);
    
    String mes8_6 = "";
    mes8_6 = analysisPk10(maxid, mes8_6, 8, 4, t);
    mes = mes + mes8_6;
    System.out.println("==8期没有出现的===" + mes8_6);
    
    String mes7_6 = "";
    mes7_6 = analysisPk10(maxid, mes7_6, 7, 4, t);
    mes = mes + mes7_6;
    System.out.println("==7期没有出现的===" + mes7_6);
    
    String mes6_6 = "";
    mes6_6 = analysisPk10(maxid, mes6_6, 6, 4, t);
    mes = mes + mes6_6;
    
    System.out.println("==6期没有出现的===" + mes6_6);
    */
    
   // mes=mes+findle(maxid,6);
    if (!mes.equals(""))
    {
      System.out.println("������");
     Pk10 p= listcp.get(0);
      String kjh=p.getNumber1()+":"+p.getNumber2()+":"+p.getNumber3()+":"+p.getNumber4()+":"+p.getNumber5()+":"+p.getNumber6()+":"+p.getNumber7()+":"+p.getNumber8()+":"+p.getNumber9()+":"+p.getNumber10();
      this.fsguok = maxid;
      mes = mes.substring(0, mes.length() - 1);
      SendTools.sendMsg("北京pk10第" + (maxid + 1) + "期:\n 开奖号:"+kjh, "\n"+mes, "仅供参考");
      mes = "";
    }
  }
  
  public String analysisPk10(int maxid, String mes, int endnum, int numSize, Map t)
  {
    for (int j = 1; j < 11; j++)
    {
      Map<String, String> mm = SendTools.examplePk10();
      String test = "";
      String test1 = "";
      List<Pk10> dsqbc111 = this.pk10Mapper.findcxcs("number" + j, maxid - (endnum - 1), maxid, "'03','04','05','06','07'");
      int n1 = 0;
      int size = dsqbc111.size();
      if (size == numSize)
      {
        n1 = numSize;
        for (int c = 0; c < n1; c++)
        {
          Pk10 p = (Pk10)dsqbc111.get(c);
          mm.remove(p.getNumber1().trim());
        }
        for (Map.Entry<String, String> entry : mm.entrySet())
        {
          test = test + ((String)entry.getKey()).substring(1, 2);
          
          test1 = test1 + (String)entry.getKey() + ",";
        }
        if ((!test.equals("")) && 
          (t.get(test) == null))
        {
          t.put(test, test);
          mes = mes + (j > 9 ? 0 : j) + "/" + test + "/5#";
        }
      }
    }
    if (mes != "") {
      mes = "\r\n " + endnum + " ������������:\r\n" + mes + "\r\n";
    }
    return mes;
  }
  
  
	public String findle(int MaxId,int qs) {
		String mes="";
		List list = new ArrayList();
		for (int j = MaxId; j > (MaxId-20); j--) {
			List m = new ArrayList();
			String t=String.valueOf(j).toString();
			m.add(t.substring(t.length()-2, t.length()));
			for (int i = 1; i < 11; i++) {
				Pk10 a = pk10Mapper.findiscx(String.valueOf(i), j,qs);
				if (a != null)
					m.add("热");
				else
					m.add("冷");
			}
			list.add(m);
		}
		for (int k = 0; k < list.size(); k++) {
			//System.out.println(list.get(k).toString());
			mes=mes+list.get(k).toString()+"\r\n";
		}
		 String bt="[期, 一, 二, 三, 四, 五, 六, 七, 八, 九, 十]";
		      
		return bt+mes;
	}
  public static void main(String[] args)
    throws Exception
  {
    Pk10Service a = new Pk10Service(null);
    SendTools.sendMsg("sasdfasdf", "dddd  \r ddds", "afasdff");
  }
}

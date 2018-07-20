package org.bc.saas.persistence.entity;

 

import java.io.Serializable;

public class Pk10jgb
  implements Serializable
{
  private static final long serialVersionUID = 8076018414947748291L;
  private Integer id;
  private Integer qh;
  private Integer position;
  private String content;
  private Double dzje;
  private Integer bs;
  private Double ylje;
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public Integer getQh()
  {
    return this.qh;
  }
  
  public void setQh(Integer qh)
  {
    this.qh = qh;
  }
  
  public Integer getPosition()
  {
    return this.position;
  }
  
  public void setPosition(Integer position)
  {
    this.position = position;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setContent(String content)
  {
    this.content = content;
  }
  
  public Double getDzje()
  {
    return this.dzje;
  }
  
  public void setDzje(Double dzje)
  {
    this.dzje = dzje;
  }
  
  public Integer getBs()
  {
    return this.bs;
  }
  
  public void setBs(Integer bs)
  {
    this.bs = bs;
  }
  
  public Double getYlje()
  {
    return this.ylje;
  }
  
  public void setYlje(Double ylje)
  {
    this.ylje = ylje;
  }
}

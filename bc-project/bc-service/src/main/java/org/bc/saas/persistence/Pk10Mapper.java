package org.bc.saas.persistence;

 
 
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.bc.saas.persistence.entity.Pk10;
import org.bc.saas.persistence.entity.Pk10jgb;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public  interface Pk10Mapper
{
  @Delete({"delete from pk10", "where id = #{id,jdbcType=BIGINT}"})
  public  int deleteByPrimaryKey(Long paramLong);
  
  @Insert({"insert into pk10 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,dateline)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} , #{dateline,jdbcType=TIMESTAMP} )"})
  public  int insert(Pk10 paramPk10);
  
  @Insert({"insert into pk10jgb (  qh,position,content,dzje,bs,ylje)", "values (  #{qh,jdbcType=BIGINT}, #{position,jdbcType=BIGINT}, #{content,jdbcType=VARCHAR}, ", "#{dzje,jdbcType=DOUBLE}, #{bs,jdbcType=BIGINT}, #{ylje,jdbcType=DOUBLE} )"})
  public  int insertpk10jgb(Pk10jgb paramPk10jgb);
  
  @Select({"select * from pk10jgb", "where id = #{qh,jdbcType=INTEGER} and position=#{position,jdbcType=INTEGER}"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER, id=true), @org.apache.ibatis.annotations.Result(column="qh", property="qh", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="position", property="position", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="content", property="content", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="dzje", property="dzje", jdbcType=org.apache.ibatis.type.JdbcType.DOUBLE), @org.apache.ibatis.annotations.Result(column="bs", property="bs", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="ylje", property="ylje", jdbcType=org.apache.ibatis.type.JdbcType.DOUBLE)})
  public  Pk10jgb findjgb1(@Param("qh") int paramInt1, @Param("position") int paramInt2);
  
  @Select({"select * from pk10", "where id = #{id,jdbcType=INTEGER}"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER, id=true), @org.apache.ibatis.annotations.Result(column="number1", property="number1", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number2", property="number2", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number3", property="number3", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number4", property="number4", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number5", property="number5", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number6", property="number6", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number7", property="number7", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number8", property="number8", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number9", property="number9", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number10", property="number10", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="dateline", property="dateline", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP)})
  public  Pk10 selectByPrimaryKey(Integer paramInteger);
  
  @Select({"select * from pk10 order by id desc limit 0,1"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER, id=true), @org.apache.ibatis.annotations.Result(column="number1", property="number1", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number2", property="number2", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number3", property="number3", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number4", property="number4", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number5", property="number5", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number6", property="number6", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number7", property="number7", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number8", property="number8", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number9", property="number9", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number10", property="number10", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="dateline", property="dateline", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP)})
  public  List<Pk10> selectPk10List(Integer paramInteger);
  
  @Select({" select * from pk10 where id=(select max(id) from pk10 ) "})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER, id=true), @org.apache.ibatis.annotations.Result(column="number1", property="number1", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number2", property="number2", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number3", property="number3", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number4", property="number4", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number5", property="number5", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number6", property="number6", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number7", property="number7", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number8", property="number8", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number9", property="number9", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number10", property="number10", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="dateline", property="dateline", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP)})
  public  Pk10 findMaxIdData();
  
  @Select({"select max(id) as maxid from pk10 "})
  public  int findMax();
  
  @Select({"select ${col}  from pk10 where id  between ${min} and ${max} and ${col} not in (${notnum}) "})
  @Results({@org.apache.ibatis.annotations.Result(column="number1", property="number1", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number2", property="number2", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number3", property="number3", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number4", property="number4", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number5", property="number5", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number6", property="number6", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number7", property="number7", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number8", property="number8", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number9", property="number9", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number10", property="number10", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR)})
  public  List<Pk10> findqbuc1(@Param("col") String paramString1, @Param("min") int paramInt1, @Param("max") int paramInt2, @Param("notnum") String paramString2);
  
  @Select({"select distinct(${col}) from pk10 where id  between ${min} and ${max} and ${col} not in (${notnum}) "})
  @Results({@org.apache.ibatis.annotations.Result(column="number1", property="number1", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number2", property="number2", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number3", property="number3", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number4", property="number4", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number5", property="number5", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number6", property="number6", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number7", property="number7", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number8", property="number8", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number9", property="number9", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number10", property="number10", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR)})
  public  List<Pk10> findqbuc2(@Param("col") String paramString1, @Param("min") int paramInt1, @Param("max") int paramInt2, @Param("notnum") String paramString2);
  
  @Select({"select DISTINCT( ${col})  as number1 from pk10 where id BETWEEN  ${min} and ${max} order by ${col} "})
  @Results({@org.apache.ibatis.annotations.Result(column="number1", property="number1", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number2", property="number2", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number3", property="number3", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number4", property="number4", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number5", property="number5", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number6", property="number6", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number7", property="number7", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number8", property="number8", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number9", property="number9", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number10", property="number10", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR)})
  public  List<Pk10> findcxcs(@Param("col") String paramString1, @Param("min") int paramInt1, @Param("max") int paramInt2, @Param("notnum") String paramString2);
  
 
  @Select({"SELECT number${num} as number1 FROM pk10 WHERE id=${id} AND number${num} IN(SELECT number${num} FROM pk10 WHERE id BETWEEN (${id}-${qs}) AND (${id}-1)) "})
  @Results({@org.apache.ibatis.annotations.Result(column="number1", property="number1", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number2", property="number2", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number3", property="number3", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number4", property="number4", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number5", property="number5", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number6", property="number6", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number7", property="number7", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number8", property="number8", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number9", property="number9", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="number10", property="number10", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR)})
  
  public  Pk10 findiscx(@Param("num") String num,@Param("id") int id,@Param("qs") int qs );
  
  
  @Select({"select ${id} as id, count(DISTINCT( number1)) as number1,count(DISTINCT( number2)) as number2,count(DISTINCT( number3)) as number3,count(DISTINCT( number4)) as number4,count(DISTINCT( number5)) as number5,count(DISTINCT( number6)) as number6,count(DISTINCT( number7)) as number7,count(DISTINCT( number8)) as number8,count(DISTINCT( number9)) as number9,count(DISTINCT( number10)) as number10 , ${cs} as qs from pk10 where id in (${parm})"})
  @Results({
	  @org.apache.ibatis.annotations.Result(column="number1", property="number1", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR),
	  @org.apache.ibatis.annotations.Result(column="number2", property="number2", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR),
	  @org.apache.ibatis.annotations.Result(column="number3", property="number3", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), 
	  @org.apache.ibatis.annotations.Result(column="number4", property="number4", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), 
	  @org.apache.ibatis.annotations.Result(column="number5", property="number5", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), 
	  @org.apache.ibatis.annotations.Result(column="number6", property="number6", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), 
	  @org.apache.ibatis.annotations.Result(column="number7", property="number7", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR),
	  @org.apache.ibatis.annotations.Result(column="number8", property="number8", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR),
	  @org.apache.ibatis.annotations.Result(column="number9", property="number9", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), 
	  @org.apache.ibatis.annotations.Result(column="number10", property="number10", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR),
	  @org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER, id=true),
	  @org.apache.ibatis.annotations.Result(column="qh", property="qh", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER)})
  public  List<Pk10> finddsqwc(@Param("id") String id,@Param("parm") String parm,@Param("cs") int cs);
  
  
  @Insert({"insert into pk10wc6 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc6(Pk10 paramPk10);
  @Insert({"insert into pk10wc7 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc7(Pk10 paramPk10);
  @Insert({"insert into pk10wc8 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc8(Pk10 paramPk10);
  @Insert({"insert into pk10wc9 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc9(Pk10 paramPk10);
  @Insert({"insert into pk10wc10 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc10(Pk10 paramPk10);
  @Insert({"insert into pk10wc11 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc11(Pk10 paramPk10);
  @Insert({"insert into pk10wc12 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc12(Pk10 paramPk10);
  @Insert({"insert into pk10wc13 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc13(Pk10 paramPk10);
  @Insert({"insert into pk10wc14 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc14(Pk10 paramPk10);
  @Insert({"insert into pk10wc15 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc15(Pk10 paramPk10);
  @Insert({"insert into pk10wc16 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc16(Pk10 paramPk10);
  @Insert({"insert into pk10wc17 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc17(Pk10 paramPk10);
  @Insert({"insert into pk10wc18 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc18(Pk10 paramPk10);
  @Insert({"insert into pk10wc19 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc19(Pk10 paramPk10);
  @Insert({"insert into pk10wc20 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc20(Pk10 paramPk10);
  
  @Insert({"insert into pk10wc9 (id, number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,qs)", "values (#{id,jdbcType=BIGINT}, #{number1,jdbcType=VARCHAR}, #{number2,jdbcType=VARCHAR}, #{number3,jdbcType=VARCHAR}, ", "#{number4,jdbcType=VARCHAR}, #{number5,jdbcType=VARCHAR}, #{number6,jdbcType=VARCHAR}, #{number7,jdbcType=VARCHAR},", " #{number8,jdbcType=VARCHAR}, #{number9,jdbcType=VARCHAR}, #{number10,jdbcType=VARCHAR} ,#{qs,jdbcType=BIGINT} )"})
  public  int insertpk10wc(Pk10 paramPk10);
 
  
  @Select({"  select id from pk10 order by id desc "})
  @Results({
	
	  @org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER, id=true)})
  public  List<Pk10> findallid();

  
  
}

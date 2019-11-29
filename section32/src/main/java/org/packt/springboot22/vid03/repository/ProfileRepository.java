package org.packt.springboot22.vid03.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.scripting.freemarker.FreeMarkerLanguageDriver;
import org.packt.springboot22.vid03.model.Profile;

@Mapper
public interface ProfileRepository {
	
	@Insert("INSERT INTO signup (id, name, email, mobile, address, username, password, approved, birthday) "
			+ "VALUES (#{id}, #{name}, #{email},#{mobile}, #{address}, #{username}, #{password}, #{approved}, #{bday})")
	public int save(Profile profile);
	
	@Update("Update signup set name=#{name}, " +
		        " email=#{email}, mobile=#{mobile}, address=#{address}, username=#{username}, password=#{password} where id=#{id}")
	public int update(Profile profile);
	
	@Delete("Delete from signup where id = #{id}")
	public int delete(Long id);
	
	@Select("SELECT * from signup")
	public List<Profile> findAll();
		
	
	@Select("SELECT * from signup where id = #{id}")
	@Results(id = "oneProfile", value = {
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "mobile", column = "mobile"),
			@Result(property = "address", column = "address"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "approved", column = "approved"),
			@Result(property = "bday", column = "birthday")
	})
	public Profile findProfile(Long id);
		
	
	
	
	
	
	
	
	@Lang(FreeMarkerLanguageDriver.class)
	@Select("ftl_users_list.ftl")
	public List<Profile> findByNameLike(@Param("expr") String expr);

	@Lang(FreeMarkerLanguageDriver.class)
	@Insert("ftl_users_save.ftl")
	public void saveMany(@Param("records") List<Profile> records);
}

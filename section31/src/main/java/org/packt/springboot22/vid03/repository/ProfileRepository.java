package org.packt.springboot22.vid03.repository;

import java.util.List;
import java.util.stream.Stream;

import org.packt.springboot22.vid03.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
	
	public List<Profile> findByNameIgnoreCase(String name);
	public List<Profile> findByUsernameAndPassword(String username, String password);
	public List<Profile> findByUsernameStartingWith(String prefix);
	public List<Profile> findByApprovedTrue();
	
	@Query(value = "select * from signup", nativeQuery = true)
	public List<Profile> findProfiles();
	
	@Query(value = "from Profile")
	public Stream<Profile> findStreamProfiles();
	
	@Query(value = "from Profile p WHERE p.id = :id")
	public Profile findProfile(@Param("id") Long id);
	
	@Query(value = "from Profile p WHERE p.username = ?1 AND p.password = ?2")
	public List<Profile> findProfiles (String username, String password);
	
	@Query(value = "Select * from signup WHERE username LIKE ?1 AND password LIKE ?2", nativeQuery = true)
	public List<Profile> findNativeProfiles (String username, String password);
	
	@Modifying
	@Query(value = "delete from signup where username = :username ", nativeQuery = true)
	public void deleteByUsername(@Param("username") String username);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update signup set name = ?1 where username = ?2", nativeQuery = true)
	public void updateByUsername(String name, String username);
		
	public List<Profile> findByProfileName(String name);
	
	public List<Profile> findByProfileContact(@Param("mobile") String mobileNum);


}

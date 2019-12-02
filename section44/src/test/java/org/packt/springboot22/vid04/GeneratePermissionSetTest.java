package org.packt.springboot22.vid04;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.packt.springboot22.vid04.model.PermissionSets;
import org.packt.springboot22.vid04.repository.PermissionRepository;
import org.packt.springboot22.vid04.repository.PermissionSetsRepository;
import org.packt.springboot22.vid04.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class GeneratePermissionSetTest {
	
	@Autowired
	private PermissionSetsRepository permissionSetsRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Test
	void contextLoads() {
		
		List<PermissionSets> userPerms = permissionSetsRepository.findAllByLoginId(201L);
		System.out.println(userPerms.size());
		System.out.println(roleRepository.findById(userPerms.get(0).getRoleId()).get().getName());
		System.out.println(permissionRepository.findById(userPerms.get(0).getPermId()).get().getName());
	}

}

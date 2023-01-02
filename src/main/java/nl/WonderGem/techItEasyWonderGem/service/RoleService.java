package nl.WonderGem.techItEasyWonderGem.service;

import nl.WonderGem.techItEasyWonderGem.dto.RoleDto;
import nl.WonderGem.techItEasyWonderGem.model.Role;
import nl.WonderGem.techItEasyWonderGem.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository repos;


    public RoleService(RoleRepository repos) {
        this.repos = repos;

    }

    public String createRole(RoleDto roleDto) {

        Role newRole = new Role();
        newRole.setRolename(roleDto.rolename);

        return repos.save(newRole).getRolename();

    }

}

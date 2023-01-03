package nl.WonderGem.techItEasyWonderGem.service;

import nl.WonderGem.techItEasyWonderGem.dto.RoleDto;
import nl.WonderGem.techItEasyWonderGem.mapper.RoleMapperImpl;
import nl.WonderGem.techItEasyWonderGem.model.Role;
import nl.WonderGem.techItEasyWonderGem.repository.RoleRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    private final RoleRepository repos;
   private final RoleMapperImpl mapper;


    public RoleService(RoleRepository repos, RoleMapperImpl mapper) {
        this.repos = repos;
        this.mapper = mapper;
    }

    public String createRole(RoleDto roleDto) {

        Role newRole = mapper.roleDtoToRole(roleDto);

        return repos.save(newRole).getRolename();

    }

    public Role getRole(String id){
        return repos.getReferenceById(id);
    }

    public Iterable<RoleDto> getAllRoles(){
        List<Role> reposRolesList = repos.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();

        for (Role role :
                reposRolesList) {

            roleDtos.add(mapper.roleToRoleDTO(role));

        }
        return roleDtos;
    }

    public void deleteRole(String role) {
        repos.deleteById(role);
    }

}

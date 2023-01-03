package nl.WonderGem.techItEasyWonderGem.mapper;

import nl.WonderGem.techItEasyWonderGem.dto.RoleDto;
import nl.WonderGem.techItEasyWonderGem.model.Role;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(uses = UserMapper.class, componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoleMapper {

    RoleDto roleToRoleDTO(Role role);

    Role roleDtoToRole(RoleDto roleDto);


}

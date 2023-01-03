package nl.WonderGem.techItEasyWonderGem.dto;

import lombok.Getter;
import lombok.Setter;
import nl.WonderGem.techItEasyWonderGem.model.Role;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Getter
@Setter
public class UserDto {
    public String username;
    public Collection<Role> roles;
}

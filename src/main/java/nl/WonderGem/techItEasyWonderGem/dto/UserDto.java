package nl.WonderGem.techItEasyWonderGem.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {
    @NotBlank
    public String username;
@NotBlank
    public String password;
@NotBlank
    public String[] roles;
}

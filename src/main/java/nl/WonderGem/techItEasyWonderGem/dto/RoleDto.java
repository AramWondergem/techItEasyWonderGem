package nl.WonderGem.techItEasyWonderGem.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RoleDto {

    @NotBlank
    public String rolename;
}

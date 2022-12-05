package nl.WonderGem.techItEasyWonderGem.dto;

import nl.WonderGem.techItEasyWonderGem.model.CiModule;
import nl.WonderGem.techItEasyWonderGem.model.Television;

import javax.validation.constraints.NotBlank;

public class CiModuleInputDto {
    public long id;
    @NotBlank
    public Television television;
    @NotBlank
    public String name;
    public String type;
    public double price;

    public CiModule toCiModule () {
        CiModule c = new CiModule();

        c.setId(id);
        c.setTelevision(television);
        c.setName(name);
        c.setType(type);
        c.setPrice(price);

        return c;
    }

    public CiModule toUpdatedCiModule (CiModule c) {

        c.setId(id);
        c.setTelevision(television);
        c.setName(name);
        c.setType(type);
        c.setPrice(price);

        return c;
    }
}

package nl.WonderGem.techItEasyWonderGem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.WonderGem.techItEasyWonderGem.model.CiModule;
import nl.WonderGem.techItEasyWonderGem.model.Television;

import javax.persistence.ManyToOne;

public class CiModuleDto {


    public long id;
    public Television television;
    public String name;
    public String type;
    public double price;

    public static CiModuleDto fromCiModule(CiModule ciMo) {
        CiModuleDto ciMoDto = new CiModuleDto();

        ciMoDto.id = ciMo.getId();
        ciMoDto.television = ciMo.getTelevision();
        ciMoDto.name = ciMo.getName();
        ciMoDto.type = ciMo.getType();
        ciMoDto.price = ciMo.getPrice();

        return ciMoDto;

    }


}

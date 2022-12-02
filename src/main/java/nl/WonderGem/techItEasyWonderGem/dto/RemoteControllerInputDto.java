package nl.WonderGem.techItEasyWonderGem.dto;

import nl.WonderGem.techItEasyWonderGem.model.RemoteController;
import nl.WonderGem.techItEasyWonderGem.model.Television;

import javax.validation.constraints.NotBlank;

public class RemoteControllerInputDto {

    public long id;
    @NotBlank
    public Television television;
    public String compatibleWith;
    public String batteryType;
    @NotBlank
    public String name;
    public String brand;
    public double price;
    public Integer originalStock;

    public RemoteController toRemoteController() {
        RemoteController r = new RemoteController();

        r.setId(id);
        r.setTelevision(television);
        r.setCompatibleWith(compatibleWith);
        r.setBatteryType(batteryType);
        r.setName(name);
        r.setBrand(brand);
        r.setPrice(price);
        r.setOriginalStock(originalStock);

        return r;
    }
}

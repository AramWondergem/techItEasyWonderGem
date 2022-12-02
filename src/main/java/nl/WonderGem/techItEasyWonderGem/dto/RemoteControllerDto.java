package nl.WonderGem.techItEasyWonderGem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.WonderGem.techItEasyWonderGem.model.RemoteController;
import nl.WonderGem.techItEasyWonderGem.model.Television;

import javax.persistence.OneToOne;

public class RemoteControllerDto {

    public long id;
    public Television television;
    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public double price;
    public Integer originalStock;

    public static RemoteControllerDto fromRemoteController(RemoteController r){
        RemoteControllerDto rd = new RemoteControllerDto();

        rd.id = r.getId();
        rd.television = r.getTelevision();
        rd.compatibleWith = r.getCompatibleWith();
        rd.batteryType = r.getBatteryType();
        rd.name = r.getName();
        rd.brand = r.getBrand();
        rd.price = r.getPrice();
        rd.originalStock = r.getOriginalStock();

        return rd;
    }
}

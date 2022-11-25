package nl.WonderGem.techItEasyWonderGem.dto;

import nl.WonderGem.techItEasyWonderGem.model.Television;

import javax.validation.constraints.NotBlank;

public class TelevisionDto {

   public long id;
   public String type;
   public String brand;
   public String name;
   public Double price;
   public Double availableSize;
   public Double refreshRate;
   public String screenType;
   public String screenQuality;
   public Boolean smartTv;
   public Boolean wifi;
   public Boolean voiceControl;
   public Boolean hdr;
   public Boolean bluetooth;
   public Boolean ambiLight;
   public Integer originalStock;
   public Integer sold;

   public static TelevisionDto fromTelevision(Television t) {
      TelevisionDto telDto = new TelevisionDto();

      telDto.id = t.getId();
      telDto.type = t.getType();
      telDto.brand = t.getBrand();
      telDto.name = t.getName();
      telDto.price = t.getPrice();
      telDto.availableSize = t.getAvailableSize();
      telDto.refreshRate = t.getRefreshRate();
      telDto.screenType = t.getScreenType();
      telDto.screenQuality = t.getScreenQuality();
      telDto.smartTv = t.getSmartTv();
      telDto.wifi = t.getWifi();
      telDto.voiceControl = t.getVoiceControl();
      telDto.hdr = t.getHdr();
      telDto.bluetooth = t.getBluetooth();
      telDto.ambiLight = t.getAmbiLight();
      telDto.originalStock = t.getOriginalStock();
      telDto.sold = t.getSold();

      return telDto;
   }
}

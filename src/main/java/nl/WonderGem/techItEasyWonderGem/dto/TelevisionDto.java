package nl.WonderGem.techItEasyWonderGem.dto;

import nl.WonderGem.techItEasyWonderGem.model.CiModule;
import nl.WonderGem.techItEasyWonderGem.model.RemoteController;
import nl.WonderGem.techItEasyWonderGem.model.Television;
import nl.WonderGem.techItEasyWonderGem.model.WallBracket;

import java.util.List;

public class TelevisionDto {

   // todo aanpassen naar nieuwe relaties

   public long id;

   public RemoteController remoteController;
   public List<CiModule> ciModuleList;
   public List<WallBracket> wallBracketList;
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

      telDto.remoteController = t.getRemoteController();
      telDto.ciModuleList = t.getCiModuleList();
      telDto.wallBracketList = t.getWallBracketList();
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

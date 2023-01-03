package nl.WonderGem.techItEasyWonderGem.dto;

import nl.WonderGem.techItEasyWonderGem.model.CiModule;
import nl.WonderGem.techItEasyWonderGem.model.RemoteController;
import nl.WonderGem.techItEasyWonderGem.model.Television;
import nl.WonderGem.techItEasyWonderGem.model.WallBracket;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class TelevisionInputDto {
    public long id;

    public RemoteController remoteController;
    public List<CiModule> ciModuleList;
    public List<WallBracket> wallBracketList;
    @NotBlank
    public String type;
    @NotBlank
    public String brand;
    @NotBlank
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

    public Television toTelevision () {
        Television t = new Television();

        t.setId(id);
        t.setRemoteController(remoteController);
        t.setCiModuleList(ciModuleList);
        t.setWallBracketList(wallBracketList);
        t.setType(type);
        t.setBrand(brand);
        t.setName(name);
        t.setPrice(price);
        t.setAvailableSize(availableSize);
        t.setRefreshRate(refreshRate);
        t.setScreenType(screenType);
        t.setScreenQuality(screenQuality);
        t.setSmartTv(smartTv);
        t.setWifi(wifi);
        t.setVoiceControl(voiceControl);
        t.setHdr(hdr);
        t.setBluetooth(bluetooth);
        t.setAmbiLight(ambiLight);
        t.setOriginalStock(originalStock);
        t.setSold(sold);

        return t;
    }
}

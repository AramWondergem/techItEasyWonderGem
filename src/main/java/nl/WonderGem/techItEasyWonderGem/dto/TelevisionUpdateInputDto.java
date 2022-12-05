package nl.WonderGem.techItEasyWonderGem.dto;

import nl.WonderGem.techItEasyWonderGem.model.CiModule;
import nl.WonderGem.techItEasyWonderGem.model.RemoteController;
import nl.WonderGem.techItEasyWonderGem.model.Television;
import nl.WonderGem.techItEasyWonderGem.model.WallBracket;

import javax.validation.constraints.NotBlank;
import java.util.List;


// I added this class, because I wanted to update the television without knowing the obligated fields in the TelevisionInputDto.
public class TelevisionUpdateInputDto {

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

    public Television toUpdatedTelevision(Television televisionToBeUpdated) {
        televisionToBeUpdated.setRemoteController(remoteController);
        televisionToBeUpdated.setCiModuleList(ciModuleList);
        televisionToBeUpdated.setWallBracketList(wallBracketList);
        televisionToBeUpdated.setType(type);
        televisionToBeUpdated.setBrand(brand);
        televisionToBeUpdated.setName(name);
        televisionToBeUpdated.setPrice(price);
        televisionToBeUpdated.setAvailableSize(availableSize);
        televisionToBeUpdated.setRefreshRate(refreshRate);
        televisionToBeUpdated.setScreenType(screenType);
        televisionToBeUpdated.setScreenQuality(screenQuality);
        televisionToBeUpdated.setSmartTv(smartTv);
        televisionToBeUpdated.setWifi(wifi);
        televisionToBeUpdated.setVoiceControl(voiceControl);
        televisionToBeUpdated.setHdr(hdr);
        televisionToBeUpdated.setBluetooth(bluetooth);
        televisionToBeUpdated.setAmbiLight(ambiLight);
        televisionToBeUpdated.setOriginalStock(originalStock);
        televisionToBeUpdated.setSold(sold);

        return televisionToBeUpdated;
    }
}


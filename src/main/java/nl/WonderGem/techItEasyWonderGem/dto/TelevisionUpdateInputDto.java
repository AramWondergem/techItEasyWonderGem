package nl.WonderGem.techItEasyWonderGem.dto;

import nl.WonderGem.techItEasyWonderGem.model.Television;

import javax.validation.constraints.NotBlank;


// I added this class, because I wanted to update the television without knowing the obligated fields in the TelevisionInputDto.
public class TelevisionUpdateInputDto {

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


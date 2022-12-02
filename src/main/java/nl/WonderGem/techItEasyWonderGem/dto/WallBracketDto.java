package nl.WonderGem.techItEasyWonderGem.dto;
import nl.WonderGem.techItEasyWonderGem.model.Television;
import nl.WonderGem.techItEasyWonderGem.model.WallBracket;


import java.util.List;

public class WallBracketDto {

    public long id;
    public List<Television> televisionList;
    public String size;
    public boolean ajustable;
    public String name;
    public double price;

    public static WallBracketDto fromWallBracket (WallBracket w) {
        WallBracketDto wd = new WallBracketDto();

        wd.id = w.getId();
        wd.televisionList = w.getTelevisionList();
        wd.size = w.getSize();
        wd.ajustable = w.isAjustable();
        wd.name = w.getName();
        wd.price = w.getPrice();

        return wd;
    }

}

package nl.WonderGem.techItEasyWonderGem.dto;

import nl.WonderGem.techItEasyWonderGem.model.Television;
import nl.WonderGem.techItEasyWonderGem.model.WallBracket;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class WallBracketInputDto {

    public long id;
    public List<Television> televisionList;
    public String size;
    public boolean ajustable;
    @NotBlank
    public String name;
    public double price;

    public WallBracket toWallBracket () {
        WallBracket w = new WallBracket();

        w.setId(id);
        w.setTelevisionList(televisionList);
        w.setAjustable(ajustable);
        w.setName(name);
        w.setPrice(price);

        return w;
    }

    public WallBracket toUpdatedWallBracket (WallBracket w) {

        w.setId(id);
        w.addTelevisionList(televisionList); // this is not a set function, because a set function will override the list. I did not want that, but you should take this into account.
        w.setAjustable(ajustable);
        w.setName(name);
        w.setPrice(price);

        return w;
    }
}

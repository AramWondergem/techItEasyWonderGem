package nl.WonderGem.techItEasyWonderGem.service;

import nl.WonderGem.techItEasyWonderGem.dto.*;
import nl.WonderGem.techItEasyWonderGem.model.Television;
import nl.WonderGem.techItEasyWonderGem.model.WallBracket;
import nl.WonderGem.techItEasyWonderGem.repository.WallBracketRepository;
import nl.WonderGem.techItEasyWonderGem.utility.Utility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

    private final WallBracketRepository repos;

    public WallBracketService(WallBracketRepository repos) {
        this.repos = repos;
    }

    public Iterable<WallBracketDto> getAllTelevisions() {

        List<WallBracket> reposWallBracketList = repos.findAll();
        List<WallBracketDto> wallBracketDtoList = new ArrayList<>();

        for (WallBracket t :
                reposWallBracketList) {

            wallBracketDtoList.add(WallBracketDto.fromWallBracket(t));

        }

        return wallBracketDtoList;
    }

    public WallBracketDto getTelevisionByID(long id) {

        if (Utility.idChecker(id,repos)){
            WallBracket requestedItem = repos.findById(id).get();
            return WallBracketDto.fromWallBracket(requestedItem);

        } else {
            return null;
        }
    }

    public long createTelevision(WallBracketInputDto wallBracketInputDto) {

        WallBracket telSaved = repos.save(wallBracketInputDto.toWallBracket());

        return telSaved.getId();
    }

    public boolean deleteWallBracket(Long id) {

        if (Utility.idChecker(id,repos)){
            repos.deleteById(id);
            return true;

        } else {

            return false;
        }

    }

    public boolean updateWallBracket(Long id, WallBracketInputDto wallBracketInputDto) {
        if (Utility.idChecker(id,repos)){
            WallBracket tobeUpdated = repos.findById(id).get();
            WallBracket updatedWallBracket = wallBracketInputDto.toUpdatedWallBracket(tobeUpdated);
            repos.save(updatedWallBracket);
            return true;

        } else {

            return false;
        }


    }


}

package nl.WonderGem.techItEasyWonderGem.service;

import nl.WonderGem.techItEasyWonderGem.dto.TelevisionDto;
import nl.WonderGem.techItEasyWonderGem.dto.TelevisionInputDto;
import nl.WonderGem.techItEasyWonderGem.dto.TelevisionUpdateInputDto;
import nl.WonderGem.techItEasyWonderGem.model.CiModule;
import nl.WonderGem.techItEasyWonderGem.model.RemoteController;
import nl.WonderGem.techItEasyWonderGem.model.Television;
import nl.WonderGem.techItEasyWonderGem.model.WallBracket;
import nl.WonderGem.techItEasyWonderGem.repository.CiModuleRepository;
import nl.WonderGem.techItEasyWonderGem.repository.RemoteControllerRepository;
import nl.WonderGem.techItEasyWonderGem.repository.TelevisionRepository;
import nl.WonderGem.techItEasyWonderGem.repository.WallBracketRepository;
import nl.WonderGem.techItEasyWonderGem.utility.Utility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository reposTV;
    private final CiModuleRepository reposCiMo;
    private final RemoteControllerRepository reposReCo;
    private final WallBracketRepository reposWaBr;



    public TelevisionService(TelevisionRepository reposTV,CiModuleRepository reposCiMo,RemoteControllerRepository reposReCo, WallBracketRepository reposWaBr) {
        this.reposTV = reposTV;
        this.reposCiMo = reposCiMo;
        this.reposReCo = reposReCo;
        this.reposWaBr = reposWaBr;
    }


    public Iterable<TelevisionDto> getAllTelevisions() {

        List<Television> reposTVList = reposTV.findAll();
        List<TelevisionDto> telDtoList = new ArrayList<>();

        for (Television t :
                reposTVList) {

            telDtoList.add(TelevisionDto.fromTelevision(t));

        }

        return telDtoList;
    }

    public TelevisionDto getTelevisionByID(long id) {

        if (Utility.idChecker(id, reposTV)){
            Television requestedTelevision = reposTV.findById(id).get();
            return TelevisionDto.fromTelevision(requestedTelevision);

        } else {
            return null;
        }
    }

    public long createTelevision(TelevisionInputDto telInputDto) {

        Television telSaved = reposTV.save(telInputDto.toTelevision());

        return telSaved.getId();
    }

    public boolean deleteTelevision(Long id) {

        if (Utility.idChecker(id, reposTV)){
            reposTV.deleteById(id);
            return true;

        } else {

            return false;
        }

    }

    public boolean updateTelevision(Long id, TelevisionUpdateInputDto telUpdateInputDto) {
        if (Utility.idChecker(id, reposTV)){
            Television tobeUpdated = reposTV.findById(id).get();
            Television updatedTelevision = telUpdateInputDto.toUpdatedTelevision(tobeUpdated);
            reposTV.save(updatedTelevision);
            return true;

        } else {

            return false;
        }


    }

    public boolean assignRemoteControllerToTelevision(Long tvID, Long reCoID) {
        if (Utility.idChecker(tvID, reposTV) && Utility.idChecker(reCoID, reposReCo)){
            Television tobeUpdated = reposTV.findById(tvID).get();
            RemoteController toBeAdded = reposReCo.findById(reCoID).get();

            tobeUpdated.setRemoteController(toBeAdded);
            reposTV.save(tobeUpdated);
            return true;

        } else {

            return false;
        }

    }

    public boolean assignCiModuleToTelevision(Long tvID, Long ciMoID) {
        if (Utility.idChecker(tvID, reposTV) && Utility.idChecker(ciMoID, reposCiMo)) {
            Television tobeUpdated = reposTV.findById(tvID).get();
            CiModule toBeAdded = reposCiMo.findById(ciMoID).get();

            tobeUpdated.addCiModuleToList(toBeAdded);
            reposTV.save(tobeUpdated);
            return true;

        } else {

            return false;
        }
    }

    public boolean assignWallBracketToTelevision(Long tvID, Long waBrID) {
        if (Utility.idChecker(tvID, reposTV) && Utility.idChecker(waBrID, reposCiMo)) {
            Television tobeUpdated = reposTV.findById(tvID).get();
            WallBracket toBeAdded = reposWaBr.findById(waBrID).get();

            tobeUpdated.addWallBracketToList(toBeAdded);
            reposTV.save(tobeUpdated);
            return true;

        } else {

            return false;
        }
    }

}

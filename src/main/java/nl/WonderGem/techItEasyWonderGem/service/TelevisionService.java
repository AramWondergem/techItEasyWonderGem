package nl.WonderGem.techItEasyWonderGem.service;

import nl.WonderGem.techItEasyWonderGem.dto.TelevisionDto;
import nl.WonderGem.techItEasyWonderGem.dto.TelevisionInputDto;
import nl.WonderGem.techItEasyWonderGem.dto.TelevisionUpdateInputDto;
import nl.WonderGem.techItEasyWonderGem.model.Television;
import nl.WonderGem.techItEasyWonderGem.repository.TelevisionRepository;
import nl.WonderGem.techItEasyWonderGem.utility.Utility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;


    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }


    public Iterable<TelevisionDto> getAllTelevisions() {

        List<Television> reposTVList = repos.findAll();
        List<TelevisionDto> telDtoList = new ArrayList<>();

        for (Television t :
                reposTVList) {

            telDtoList.add(TelevisionDto.fromTelevision(t));

        }

        return telDtoList;
    }

    public TelevisionDto getTelevisionByID(long id) {

        if (Utility.idChecker(id,repos)){
            Television requestedTelevision = repos.findById(id).get();
            return TelevisionDto.fromTelevision(requestedTelevision);

        } else {
            return null;
        }
    }

    public long createTelevision(TelevisionInputDto telInputDto) {

        Television telSaved = repos.save(telInputDto.toTelevision());

        return telSaved.getId();
    }

    public boolean deleteTelevision(Long id) {

        if (Utility.idChecker(id,repos)){
            repos.deleteById(id);
            return true;

        } else {

            return false;
        }

    }

    public boolean updateTelevision(Long id, TelevisionUpdateInputDto telUpdateInputDto) {
        if (Utility.idChecker(id,repos)){
            Television tobeUpdated = repos.findById(id).get();
            Television updatedTelevision = telUpdateInputDto.toUpdatedTelevision(tobeUpdated);
            repos.save(updatedTelevision);
            return true;

        } else {

            return false;
        }


    }


}

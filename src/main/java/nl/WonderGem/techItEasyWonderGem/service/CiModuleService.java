package nl.WonderGem.techItEasyWonderGem.service;

import nl.WonderGem.techItEasyWonderGem.dto.CiModuleDto;
import nl.WonderGem.techItEasyWonderGem.dto.CiModuleInputDto;
import nl.WonderGem.techItEasyWonderGem.model.CiModule;
import nl.WonderGem.techItEasyWonderGem.repository.CiModuleRepository;
import nl.WonderGem.techItEasyWonderGem.utility.Utility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiModuleService {
    private final CiModuleRepository repos;

    public CiModuleService(CiModuleRepository repos) {
        this.repos = repos;
    }

    public Iterable<CiModuleDto> getAllTelevisions() {

        List<CiModule> reposCiModuleList = repos.findAll();
        List<CiModuleDto> ciModuleDtoList = new ArrayList<>();

        for (CiModule t :
                reposCiModuleList) {

            ciModuleDtoList.add(CiModuleDto.fromCiModule(t));

        }

        return ciModuleDtoList;
    }

    public CiModuleDto getTelevisionByID(long id) {

        if (Utility.idChecker(id,repos)){
            CiModule requestedItem = repos.findById(id).get();
            return CiModuleDto.fromCiModule(requestedItem);

        } else {
            return null;
        }
    }

    public long createTelevision(CiModuleInputDto ciModuleInputDto) {

        CiModule telSaved = repos.save(ciModuleInputDto.toCiModule());

        return telSaved.getId();
    }

    public boolean deleteCiModule(Long id) {

        if (Utility.idChecker(id,repos)){
            repos.deleteById(id);
            return true;

        } else {

            return false;
        }

    }

    public boolean updateCiModule(Long id, CiModuleInputDto ciModuleInputDto) {
        if (Utility.idChecker(id,repos)){
            CiModule tobeUpdated = repos.findById(id).get();
            CiModule updatedCiModule = ciModuleInputDto.toUpdatedCiModule(tobeUpdated);
            repos.save(updatedCiModule);
            return true;

        } else {

            return false;
        }


    }
}

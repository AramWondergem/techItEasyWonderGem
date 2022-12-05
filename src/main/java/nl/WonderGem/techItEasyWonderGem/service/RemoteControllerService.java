package nl.WonderGem.techItEasyWonderGem.service;

import nl.WonderGem.techItEasyWonderGem.dto.RemoteControllerDto;
import nl.WonderGem.techItEasyWonderGem.dto.RemoteControllerInputDto;
import nl.WonderGem.techItEasyWonderGem.model.RemoteController;
import nl.WonderGem.techItEasyWonderGem.repository.RemoteControllerRepository;
import nl.WonderGem.techItEasyWonderGem.utility.Utility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository repos;

    public RemoteControllerService(RemoteControllerRepository repos) {
        this.repos = repos;
    }

    public Iterable<RemoteControllerDto> getAllTelevisions() {

        List<RemoteController> reposRemoteControllerList = repos.findAll();
        List<RemoteControllerDto> remoteControllerDtoList = new ArrayList<>();

        for (RemoteController t :
                reposRemoteControllerList) {

            remoteControllerDtoList.add(RemoteControllerDto.fromRemoteController(t));

        }

        return remoteControllerDtoList;
    }

    public RemoteControllerDto getTelevisionByID(long id) {

        if (Utility.idChecker(id,repos)){
            RemoteController requestedItem = repos.findById(id).get();
            return RemoteControllerDto.fromRemoteController(requestedItem);

        } else {
            return null;
        }
    }

    public long createTelevision(RemoteControllerInputDto remoteControllerInputDto) {

        RemoteController telSaved = repos.save(remoteControllerInputDto.toRemoteController());

        return telSaved.getId();
    }

    public boolean deleteRemoteController(Long id) {

        if (Utility.idChecker(id,repos)){
            repos.deleteById(id);
            return true;

        } else {

            return false;
        }

    }

    public boolean updateRemoteController(Long id, RemoteControllerInputDto remoteControllerInputDto) {
        if (Utility.idChecker(id,repos)){
            RemoteController tobeUpdated = repos.findById(id).get();
            RemoteController updatedRemoteController = remoteControllerInputDto.toUpdatedRemoteController(tobeUpdated);
            repos.save(updatedRemoteController);
            return true;

        } else {

            return false;
        }


    }
}

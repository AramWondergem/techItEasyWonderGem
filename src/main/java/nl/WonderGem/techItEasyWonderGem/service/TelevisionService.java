package nl.WonderGem.techItEasyWonderGem.service;

import nl.WonderGem.techItEasyWonderGem.dto.TelevisionDto;
import nl.WonderGem.techItEasyWonderGem.dto.TelevisionInputDto;
import nl.WonderGem.techItEasyWonderGem.dto.TelevisionUpdateInputDto;
import nl.WonderGem.techItEasyWonderGem.exception.IndexOutOfBoundsException;
import nl.WonderGem.techItEasyWonderGem.exception.RecordNotFoundException;
import nl.WonderGem.techItEasyWonderGem.model.Television;
import nl.WonderGem.techItEasyWonderGem.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
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

        if (id < 0) {

            throw new IndexOutOfBoundsException("The ID should be a positive number");
        } else {

            Television requestedTelevision = repos.findById(id).orElseThrow(() -> new RecordNotFoundException(("There is no television coupled to this ID:" + id)));

            return TelevisionDto.fromTelevision(requestedTelevision);
        }
    }

    public long createTelevision(TelevisionInputDto telInputDto) {

        Television telSaved = repos.save(telInputDto.toTelevision());

        return telSaved.getId();
    }

    public boolean deleteTelevision(Long id) {

        if (id < 0) { //check if the id is positive number

            throw new IndexOutOfBoundsException("The ID should be a positive number");

        } else {
            try { // if delete function false it is checked if the ID exists in the database. If so it will throw an RecordNotFoundException.
                // otherwise the controller will throw an internal server error.
                repos.deleteById(id);
                return true;

            } catch (Exception e) {
                if (!repos.existsById(id)) {

                    throw new RecordNotFoundException("Not deleted: television with this id does not exist");

                } else {

                    return false;

                }
            }
        }

    }

    public boolean updateTelevision(Long id, TelevisionUpdateInputDto telUpdateInputDto) {
        if (id < 0) { //check if the id is positive number

            throw new IndexOutOfBoundsException("The ID should be a positive number");

        } else if (!repos.existsById(id)) {

            throw new RecordNotFoundException("This ID does not match with a television");

        } else {

            Television tobeUpdated = repos.findById(id).get();
            Television updatedTelevision = telUpdateInputDto.toUpdatedTelevision(tobeUpdated);
            repos.save(updatedTelevision);
            return true;
        }


    }


}

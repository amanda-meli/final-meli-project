package meli.dh.com.finalmeliproject.service.Representative;

import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.model.Representative;
import meli.dh.com.finalmeliproject.repository.IRepresentativeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepresentativeService implements IRepresentativeService {

    @Autowired
    private IRepresentativeRepo representativeRepo;

    @Override
    public Representative findRepresentativeById(long id) {
        try{
            return representativeRepo.findById(id).get();
        }
        catch (Exception ex) {
           throw new NotFoundExceptionImp("Representative with id " + id + " not found.");
        }
    }
}
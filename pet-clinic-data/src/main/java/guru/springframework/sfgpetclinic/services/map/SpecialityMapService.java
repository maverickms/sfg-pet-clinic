package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.models.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityMapService extends AbstractMapService implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return (Speciality) super.findById(id);
    }

    @Override
    public Speciality save(Speciality Object) {
        return (Speciality) super.save(Object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

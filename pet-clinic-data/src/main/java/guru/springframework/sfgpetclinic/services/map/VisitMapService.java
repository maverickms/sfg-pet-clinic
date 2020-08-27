package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.models.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import javax.persistence.Lob;
import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
            || visit.getPet().getOwner().getId() == null) {
            System.out.println((visit.getPet() == null)?"getPet is null":"all good with getPet");
            System.out.println((visit.getPet().getOwner() == null)?"getOwner is null":"all good with getOwner");
            System.out.println((visit.getPet().getId() == null)?"getPet.getId is null":"All good with getPet.getid");
            System.out.println((visit.getPet().getOwner().getId() == null)?"visit.getPet().getOwner().getId() is null":"all good with visit.getPet().getOwner().getId()");
            throw new RuntimeException("Invalid Visit == ");
        }

        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

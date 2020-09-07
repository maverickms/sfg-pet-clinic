package guru.springframework.sfgpetclinic.models;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name =  "vets")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER) // with setting the fetch type to eager - JPA will load all entries at once
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();
}

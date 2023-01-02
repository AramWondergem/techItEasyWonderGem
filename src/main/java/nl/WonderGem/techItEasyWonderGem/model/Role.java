package nl.WonderGem.techItEasyWonderGem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;


@Entity
@Table(name = "roles")
public class Role {


    @Id
    @Getter
    @Setter
    private String rolename;


    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;


}

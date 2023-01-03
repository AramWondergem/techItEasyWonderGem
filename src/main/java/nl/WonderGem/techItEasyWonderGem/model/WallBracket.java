package nl.WonderGem.techItEasyWonderGem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wall_brackets")
public class WallBracket {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @ManyToMany(mappedBy = "wallBracketList")
        @JsonIgnore
        private List<Television> televisionList;

        private String size;
        private boolean ajustable;
        private String name;
        private double price;

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public List<Television> getTelevisionList() {
                return televisionList;
        }

        public void setTelevisionList(List<Television> televisionList) {
                this.televisionList = televisionList;
        }

        public void addTelevisionList(List<Television> televisionList) {
                for (Television tv :
                        televisionList) {
                        this.televisionList.add(tv);
                }
        }

        public String getSize() {
                return size;
        }

        public void setSize(String size) {
                this.size = size;
        }

        public boolean isAjustable() {
                return ajustable;
        }

        public void setAjustable(boolean ajustable) {
                this.ajustable = ajustable;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }
}

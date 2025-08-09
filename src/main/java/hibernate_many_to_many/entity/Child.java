package hibernate_many_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "children_sections", joinColumns = @JoinColumn(name = "child_id"), inverseJoinColumns = @JoinColumn(name = "section_id"))
    //название таблицы-посредника - children_sections
    //в таблице children_sections будет колонка внешних ключей child_id для связи с таблицей children
    //в таблице children_sections будет колонка внешних ключей section_id для связи с таблицей sections
    private List<Section> sections;

    public Child() {
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void addSectionToChild(Section section) {
        if (this.sections == null) {
            this.sections = new ArrayList<>();
        }
        this.sections.add(section);
    }

    @Override
    public String toString() {
        return "Child{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sections=" + sections +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

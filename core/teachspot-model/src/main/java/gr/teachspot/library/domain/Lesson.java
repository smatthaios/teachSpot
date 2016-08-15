package gr.teachspot.library.domain;

import gr.teachspot.library.enumeration.Subject;
import gr.teachspot.library.enumeration.SchoolLevel;

/**
 * The type {@link gr.teachspot.library.domain.Lesson} represents the lesson entity of the application.
 */
public class Lesson {

    private Long id;
    private String name;
    private String description;
    private SchoolLevel schoolLevel;
    private Subject subject;

    public Lesson(){

    }

    public Lesson(String name, String description, SchoolLevel schoolLevel, Subject subject) {
        this.name = name;
        this.description = description;
        this.schoolLevel = schoolLevel;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the {@link SchoolLevel}
     * @return the schoolLevel
     */
    public SchoolLevel getSchoolLevel() {
        return schoolLevel;
    }

    /**
     * Sets the {@link SchoolLevel}
     * @param schoolLevel the schoolLevel
     */
    public void setSchoolLevel(SchoolLevel schoolLevel) {
        this.schoolLevel = schoolLevel;
    }

    /**
     * Gets the {@link Subject}
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets the {@link Subject}
     * @param subject the subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", schoolLevel=" + schoolLevel +
                ", subject=" + subject +
                '}';
    }
}

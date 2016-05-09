package gr.teachspot.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import gr.teachspot.library.enumeration.Profile;
import gr.teachspot.library.enumeration.UserStatus;

/**
 * The type {@link gr.teachspot.library.domain.Lesson} represents the lesson entity of the application.
 */
public class Lesson extends LoggableEntity {

    private String name;

    private String description;

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

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

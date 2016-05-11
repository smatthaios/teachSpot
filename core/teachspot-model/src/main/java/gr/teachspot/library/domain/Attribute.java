package gr.teachspot.library.domain;

import java.io.Serializable;

/**
 * The type Attribute is used to depict the different attributes of a {@link gr.teachspot.library.domain.User user} depending on their {@link gr.teachspot.library.domain.Profile profile}.
 */
public class Attribute implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 8155858884120688310L;

    /**
	 * The attribute id.
	 */
	private Long id;

    /**
	 * The attribute name.
	 */
	private String name;

    /**
	 * The attribute value.
	 */
	private String value;

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
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

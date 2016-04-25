package gr.teachspot.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/** The type {@link AbstractEntity} is the abstract domain class. All domain objects should extend this entity. */

public abstract class AbstractEntity implements Serializable {
	/** The constant serialVersionUID. */
	@JsonIgnore
	private static final long serialVersionUID = 4287803674125626642L;

	/** The id of the entity. */
	@Id
	protected String id;

	/**
	 * The _ class field is used while persisting entity at database.
	 */
	private String _class = this.getClass().getCanonicalName();

	/**
	 * Gets the id of the entity.
	 *
	 * @return the id of the entity
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the entity.
	 *
	 * @param id the id of the entity
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Prepare entity to be persisted at database. If the entity is saved for the first time, the id and is filled.
	 */
	public void prepare() {}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AbstractEntity{");
		sb.append("id='").append(id).append('\'');
		sb.append(", _class='").append(_class).append('\'');
		sb.append('}');
		return sb.toString();
	}
}

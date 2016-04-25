package gr.teachspot.library.domain;

import java.util.Date;

/**
 * The type {@link LoggableEntity} should be extended by the entities that need to have creation and modification dates updated while being
 * persisted.
 */
public abstract class LoggableEntity extends AbstractEntity {
	/**
	 * The Creation date.
	 */
	private Date creationDate;
	/**
	 * The Last modified.
	 */
	private Date lastModified;

	/**
	 * Gets last modified.
	 *
	 * @return the last modified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * Sets last modified.
	 *
	 * @param lastModified the last modified
	 */
	public void setLastModified(final Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * Gets creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets creation date.
	 *
	 * @param creationDate the creation date
	 */
	public void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Prepare entity to be persisted at database. If the entity is saved for the first time id and creationDate are filled. In any case lastModified
	 * field is updated.
	 */
	public void prepare() {
		if (id == null) {
			this.setCreationDate(new Date());
		}
		this.setLastModified(new Date());
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("LoggableEntity{");
		sb.append("creationDate=").append(creationDate);
		sb.append(", lastModified=").append(lastModified);
		sb.append('}');
		return sb.toString();
	}
}

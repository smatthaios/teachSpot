package gr.teachspot.library.domain;

import gr.teachspot.library.enumeration.AccountStatus;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Account is used for grouping the {@link User users} under a single unit.
 */
public class Account extends LoggableEntity implements Serializable {

	/** serial version UID */
	private static final long serialVersionUID = -5577750825718188508L;

	/**
	 * The Name.
	 */
	private String name;
	/**
	 * The Country.
	 */
	private String country;
	/**
	 * The Status.
	 */
	private AccountStatus status;

	/**
	 * The Parent account.
	 */
	@Transient
	private List<Account> children;

	/**
	 * The Child account ids.
	 */
	private List<String> childAccountIds;

	/**
	 * The Parent account id.
	 */
	private String parentAccountId;

	/**
	 * The Project ids.
	 */
	private List<String> projectIds;

	/**
	 * Gets project ids.
	 *
	 * @return the project ids
	 */
	public List<String> getProjectIds() {
		return projectIds;
	}

	/**
	 * Sets project ids.
	 *
	 * @param projectIds the project ids
	 */
	public void setProjectIds(final List<String> projectIds) {
		this.projectIds = projectIds;
	}

	/**
	 * Add project.
	 *
	 * @param projectId the project id
	 */
	public void addProject(final String projectId) {
		if(this.projectIds == null){
			this.projectIds = new ArrayList<>();
		}
		this.projectIds.add(projectId);
	}

	/**
	 * Gets child account ids.
	 *
	 * @return the child account ids
	 */
	public List<String> getChildAccountIds() {
		return childAccountIds;
	}

	/**
	 * Sets child account ids.
	 *
	 * @param childAccountIds the child account ids
	 */
	public void setChildAccountIds(final List<String> childAccountIds) {
		this.childAccountIds = childAccountIds;
	}

	/**
	 * Gets parent account id.
	 *
	 * @return the parent account id
	 */
	public String getParentAccountId() {
		return parentAccountId;
	}

	/**
	 * Sets parent account id.
	 *
	 * @param parentAccountId the parent account id
	 */
	public void setParentAccountId(final String parentAccountId) {
		this.parentAccountId = parentAccountId;
	}

	/**
	 * Add child accounts.
	 *
	 * @param childAccount the child account
	 */
	public void addChildAccount(final Account childAccount) {
		if (this.childAccountIds == null) {
			this.childAccountIds = new LinkedList<>();
		}
		this.childAccountIds.add(childAccount.getId());
	}

	/**
	 * Remove child account.
	 *
	 * @param childAccountId the child account id
	 */
	public void removeChildAccount(final String childAccountId) {
		if (this.childAccountIds != null) {
			this.childAccountIds.remove(childAccountId);
		}
	}

	/**
	 * Gets children.
	 *
	 * @return the children
	 */
	public List<Account> getChildren() {
		return children;
	}

	/**
	 * Sets children.
	 *
	 * @param children the children
	 */
	public void setChildren(final List<Account> children) {
		this.children = children;
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
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets country.
	 *
	 * @param country the country
	 */
	public void setCountry(final String country) {
		this.country = country;
	}

	/**
	 * Gets status.
	 *
	 * @return the status
	 */
	public AccountStatus getStatus() {
		return status;
	}

	/**
	 * Sets status.
	 *
	 * @param status the status
	 */
	public void setStatus(final AccountStatus status) {
		this.status = status;
	}

	/** {@inheritDoc}*/
	public enum FieldName implements ClassField {
		/**
		 * The NAME.
		 */
		NAME("name");

		/**
		 * The Class field.
		 */
		private final String classField;

		/**
		 * Instantiates a new Account field name.
		 *
		 * @param classField the class field
		 */
		FieldName(String classField) {
			this.classField = classField;
		}

		/** {@inheritDoc} */
		@Override
		public String getName() {
			return classField;
		}
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Account{");
		sb.append("name='").append(name).append('\'');
		sb.append(", country='").append(country).append('\'');
		sb.append(", status=").append(status);
		sb.append(", children=").append(children);
		sb.append(", childAccountIds=").append(childAccountIds);
		sb.append(", parentAccountId='").append(parentAccountId).append('\'');
		sb.append('}');
		return sb.toString();
	}
}

package gr.teachspot.library.transport;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gr.teachspot.library.enumeration.ResponseStatus;
import gr.teachspot.library.util.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * The type {@link Response} is an abstract object containing all core functionality that needs to be implemented from extending
 * classes.
 * @param <T>    the type parameter
 */
public class Response<T> {
	/** The status. */
	private ResponseStatus status;

	/** The status message. */
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String statusMessage;

	/** The date the {@link Response} was created on. */
	private String createdOn;

	/** The fault id. */
	private Long faultId;

	/** The flag that indicates if the response is synchronous or asynchronous. */
	private boolean syncResponse = true;

	/** The Data. */
	private List<T> data;

	/**
	 * Sets status.
	 *
	 * @param status the status
	 */
	public void setStatus(final ResponseStatus status) {
		this.status = status;
	}

	/**
	 * Sets created on.
	 *
	 * @param createdOn the created on
	 */
	public void setCreatedOn(final String createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Sets data.
	 *
	 * @param data the data
	 */
	public void setData(final List<T> data) {
		this.data = data;
	}

	/**
	 * Instantiates a new Response.
	 *
	 * @param data the data
	 * @param status the status
	 */
	public Response(List<T> data, ResponseStatus status) {
		this.data = data;
		this.createdOn = DateUtils.getDateInBasicFormat(new Date());
		this.status = status;
	}

	/**
	 * Instantiates a new Response.
	 *
	 * @param data the data
	 * @param status the status
	 * @param syncResponse the sync response
	 */
	public Response(List<T> data, ResponseStatus status, boolean syncResponse) {
		this.data = data;
		this.createdOn = DateUtils.getDateInBasicFormat(new Date());
		this.status = status;
		this.syncResponse = syncResponse;
	}

	/**
	 * Instantiates a new Response.
	 */
	public Response() {
	}

	/**
	 * Gets data.
	 *
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * Gets the date the {@link Response} was created on.
	 *
	 * @return the date
	 */
	public String getCreatedOn() {
		return createdOn;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status != null ? status.name() : null;
	}

	/**
	 * Gets the status message.
	 *
	 * @return the status message
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * Sets the status message.
	 *
	 * @param statusMessage the new status message
	 */
	public void setStatusMessage(final String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/**
	 * Gets the fault id.
	 *
	 * @return the fault id
	 */
	public Long getFaultId() {
		return faultId;
	}

	/**
	 * Sets the fault id.
	 *
	 * @param faultId the fault id
	 */
	public void setFaultId(final Long faultId) {
		this.faultId = faultId;
	}

	/**
	 * Is the response synchronous.
	 *
	 * @return true if the response is synchronous or false if it is asynchronous.
	 */
	public boolean isSyncResponse() {
		return syncResponse;
	}

	/**
	 * Sets the flag that indicates if the response is synchronous.
	 *
	 * @param syncResponse the flags value to be set.
	 */
	public void setSyncResponse(final boolean syncResponse) {
		this.syncResponse = syncResponse;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Response{");
		sb.append("status=").append(status);
		sb.append(", statusMessage='").append(statusMessage).append('\'');
		sb.append(", createdOn='").append(createdOn).append('\'');
		sb.append(", faultId=").append(faultId);
		sb.append(", syncResponse=").append(syncResponse);
		sb.append(", data=").append(data);
		sb.append('}');
		return sb.toString();
	}
}

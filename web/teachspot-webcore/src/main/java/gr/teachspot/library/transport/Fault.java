package gr.teachspot.library.transport;

import gr.teachspot.library.enumeration.FaultReason;

/**
 * This class contains additional information to resolve/debug cases where the actual service call has failed.
 */
public class Fault {
    /** The {@link Fault} id. */
    private Long faultId;

    /** The {@link Fault} description. */
    private String faultDescription;

    /** Instantiates a new {@link Fault}. */
    public Fault() {
    }

    /**
     * Instantiates a new {@link Fault}.
     *
     * @param faultId the {@link Fault} id
     */
    public Fault(final FaultReason faultId) {
        this.setFaultId(faultId.getId());
    }

    /**
     * Gets the {@link Fault} id.
     *
     * @return the id
     */
    public Long getFaultId() {
        return faultId;
    }

    /**
     * Sets the {@link Fault} id.
     *
     * @param faultId the new  id
     */
    public void setFaultId(final Long faultId) {
        this.faultId = faultId;
    }

    /**
     * Gets the {@link Fault} description.
     *
     * @return the description
     */
    public String getFaultDescription() {
        return faultDescription;
    }

    /**
     * Sets the {@link Fault} description.
     *
     * @param faultDescription the new description
     */
    public void setFaultDescription(final String faultDescription) {
        this.faultDescription = faultDescription;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fault{");
        sb.append("faultId=").append(faultId);
        sb.append(", faultDescription='").append(faultDescription).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

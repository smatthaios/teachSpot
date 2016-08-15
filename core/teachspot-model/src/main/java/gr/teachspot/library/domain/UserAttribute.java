package gr.teachspot.library.domain;

import java.io.Serializable;

/**
 * The type UserAttribute represents the attribute values of a user.
 */
public class UserAttribute implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 8485794150795492222L;

    /**
     * The user id.
     */
    private Long userId;

    /**
     * The attribute id.
     */
    private Long attributeId;

    /**
     * The attribute value.
     */
    private String value;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserAttribute{" +
                "userId=" + userId +
                ", attributeId=" + attributeId +
                ", value='" + value + '\'' +
                '}';
    }
}

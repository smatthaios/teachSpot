package gr.teachspot.library.transport;

import gr.teachspot.library.domain.User;
import gr.teachspot.library.domain.UserAttribute;
import gr.teachspot.library.enumeration.ProfileType;

import java.io.Serializable;
import java.util.List;

/**
 * This class represents the user data transferred between client - server for a user registration
 */
public class UserDto implements Serializable {//todo: should it be loggable entity ?

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 4587313821786917576L;

    /**
     * The standard {@link User} attributes
     */
    private User user;

    /**
     * Any extra {@link UserAttribute}
     */
    private List<UserAttribute> attributeList;

    /**
     * The profile type of the user to be registered
     */
    private ProfileType profileType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserAttribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<UserAttribute> attributeList) {
        this.attributeList = attributeList;
    }

    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }
}

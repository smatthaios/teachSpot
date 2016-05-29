package gr.teachspot.library.domain.dto;

/**
 * The UserProfile contains a pair that relates a {@link gr.teachspot.library.domain.Profile profile} to a {@link gr.teachspot.library.domain.User user}.
 */
public class UserProfile {
    /**
     * The id of the {@link gr.teachspot.library.domain.User user}
     */
    Long userId;

    /**
     * The id of the {@link gr.teachspot.library.domain.Profile profile}
     */
    Long profileId;

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets profile id.
     *
     * @return the profile id
     */
    public Long getProfileId() {
        return profileId;
    }

    /**
     * Sets profile id.
     *
     * @param profileId the profile id
     */
    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userId=" + userId +
                ", profileId=" + profileId +
                '}';
    }
}

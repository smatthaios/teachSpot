package gr.teachspot.library.domain;

import java.util.Date;

/**
 * The type {@link UserProfileLesson} represents the entity of the application that combines a user profile with a lesson
 */
public class UserProfileLesson {

    /**
     * The profile id
     */
    private Long profileId;

    /**
     * The lesson id
     */
    private Long lessonId;

    /**
     * The token
     */
    private String token;

    /**
     * The token
     */
    private Date tokenDate;

    public UserProfileLesson(Long profileId, Long lessonId) {
        this.profileId = profileId;
        this.lessonId = lessonId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenDate() {
        return tokenDate;
    }

    public void setTokenDate(Date tokenDate) {
        this.tokenDate = tokenDate;
    }

    @Override
    public String toString() {
        return "UserProfileLesson{" +
                "profileId=" + profileId +
                ", lessonId=" + lessonId +
                ", token='" + token + '\'' +
                ", tokenDate=" + tokenDate +
                '}';
    }
}

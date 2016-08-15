package gr.teachspot.library.domain;

import gr.teachspot.library.domain.Notification;

public class PairRequestNotification extends Notification {

    private String token;
    private Long profileId;
    private String firstName;
    private String lastName;
    private String lessonName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @Override
    public String toString() {
        return "PairRequestNotification{" +
                "token='" + token + '\'' +
                ", profileId=" + profileId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lessonName='" + lessonName + '\'' +
                '}';
    }
}

package gr.teachspot.library.domain;

import gr.teachspot.library.enumeration.NotificationType;

public abstract class Notification {

    private String email;
    private NotificationType type;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "email='" + email + '\'' +
                ", type=" + type +
                '}';
    }
}

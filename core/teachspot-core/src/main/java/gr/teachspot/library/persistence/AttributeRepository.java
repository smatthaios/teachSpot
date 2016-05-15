package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Attribute;
import gr.teachspot.library.domain.User;

import java.util.List;


/** The interface Attribute repository contains all {@link Attribute} related database actions. */
public interface AttributeRepository {

    /**
     * Returns the {@link Attribute} for the provided id.
     *
     * @param attributeId The id of the {@link Attribute} to search with
     * @return The {@link Attribute}
     */
    Attribute find(Long attributeId);

    /**
     * Returns a {@link List} of the {@link Attribute attributes} of a {@link User user} given his id
     * @param userId
     * @return
     */
    List<Attribute> get(Long userId);
}

package gr.teachspot.library.service;

import gr.teachspot.library.domain.Attribute;
import gr.teachspot.library.domain.User;

import java.util.List;

/** The interface Attribute service contains all the business methods related to a {@link gr.teachspot.library.domain.Attribute}. */
public interface AttributeService {

    /**
     * Returns the {@link Attribute} for the provided id.
     *
     * @param attributeId The id of the {@link Attribute} to search with
     * @return The {@link Attribute}
     */
    Attribute find(Long attributeId);

    /**
     * Returns a {@link List} of the {@link Attribute attributes} of a {@link User user} given his id
     * @param userId The id of the {@link User user} to query with.
     * @return a {@link List} of {@link Attribute attributes} for the requested user Id
     */
    List<Attribute> get(Long userId);

    /**
     * Inserts a {@link Attribute} .
     * @param attribute the {@link Attribute}  to insert
     * @return the id of the {@link Attribute} that was inserted
     */
    Long save(Attribute attribute);

    /**
     * Updates a {@link Attribute} .
     * @param attribute the {@link Attribute}  to insert
     * @return the number of rows affected
     */
    int update(Attribute attribute);

    /**
     * Deletes the {@link Attribute attribute} for the provided attribute id.
     * @param attributeId The id of the {@link Attribute} to delete
     * @return the number of rows affected
     */
    int delete(Long attributeId);
}

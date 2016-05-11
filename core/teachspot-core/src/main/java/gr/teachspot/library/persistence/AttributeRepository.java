package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Attribute;


/** The interface Attribute repository contains all {@link Attribute} related database actions. */
public interface AttributeRepository {

    /**
     * Return the {@link Attribute} for the provided id.
     *
     * @param attributeId The id of the {@link Attribute} to search with
     * @return The {@link Attribute}
     */
    Attribute find(Long attributeId);
}

package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.UserAttribute;
import gr.teachspot.library.domain.User;
import gr.teachspot.library.exception.DataException;

import java.util.List;

/** The interface UserAttribute repository contains all {@link UserAttribute} related database actions. */
public interface UserAttributeRepository {
/*    *//**
     * Returns the {@link Attribute} for the provided id.
     *
     * @param attributeId The id of the {@link Attribute} to search with
     * @return The {@link Attribute}
     *//*
    Attribute find(Long attributeId) throws DataException;

    *//**
     * Returns a {@link List} of the {@link Attribute attributes} of a {@link User user} given his id
     * @param userId The id of the {@link User user} to query with.
     * @return a {@link List} of {@link Attribute attributes} for the requested user Id
     *
     * @throws DataException if an error occurs in the database
     *//*
    List<Attribute> get(Long userId) throws DataException ;*/

    /**
     * Inserts a {@link UserAttribute} .
     * @param userAttribute the {@link UserAttribute}  to insert
     * @return the id of the {@link UserAttribute} that was inserted
     *
     * @throws DataException if an error occurs in the database
     */
    int save(UserAttribute userAttribute);

/*    *//**
     * Updates a {@link Attribute} .
     * @param attribute the {@link Attribute}  to insert
     * @return the number of rows affected
     *
     * @throws DataException if an error occurs in the database
     *//*
    int update(Attribute attribute) throws DataException ;

    *//**
     * Deletes the {@link Attribute attribute} for the provided attribute id.
     * @param attributeId The id of the {@link Attribute} to delete
     * @return the number of rows affected
     *
     * @throws DataException if an error occurs in the database
     *//*
    int delete(Long attributeId) throws DataException;*/
}

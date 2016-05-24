package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.User;

import java.util.List;

/** The interface User repository contains all {@link User} related database actions. */
public interface UserRepository{

	/**
	 * this method retrieves a List of {@link User} according to the provided criteria
	 *
	 * @param accountId
	 * @return
	 */
	List<User> findByAccount(String accountId);

	/**
	 * Return the {@link User} for the provided id.
	 *
	 * @param userId The {@link User} id
	 * @return The {@link User}
	 */
	User find(Long userId);

	/**
	 * Return the {@link User} for the provided id.
	 *
	 * @param attribute The attribute of the {@link User} to search with
	 * @param value The value of the attribute with which we want to retrieve {@link User users}
	 * @return A {@link List} of {@link User users} of which the attribute value matches the one provided.
	 */
	List<User> find(String attribute, String value);


	/**
	 * Saves the given User.
	 *
	 * @param user The {@link User} to be saved.
	 * @return The {@link User}
	 */
	/*User save(User user);*/


	/**
	 * Updates the given User.
	 *
	 * @param user The {@link User} to be saved.
	 * @return The {@link User}
	 */
	User update(User user);

}

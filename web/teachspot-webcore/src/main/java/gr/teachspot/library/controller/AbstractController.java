package gr.teachspot.library.controller;

import gr.teachspot.library.transport.Response;
import gr.teachspot.library.domain.User;
import gr.teachspot.library.enumeration.ResponseStatus;
import gr.teachspot.library.enumeration.SessionAttribute;
import gr.teachspot.library.enumeration.SupportedLanguage;
import gr.teachspot.library.exception.*;
import gr.teachspot.library.exception.SecurityException;
import gr.teachspot.library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * The abstract class AbstractController contains all eu.iri.ace.demos.exception.exception handlers for all the controllers extending the
 * AbstractController
 */
@RestController
public abstract class AbstractController {
	/** The LOGGER. */
	protected Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);

	/** The resource bundle withe the exception messages */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserService userService;

	/**
	 * Handles all type of exceptions thrown by the controllers extending the {@link AbstractController} class.
	 *
	 * @param exception the handled by this method.
	 * @param request   the request
	 */
	@ExceptionHandler(ApplicationException.class)
	protected Response handleException(ApplicationException exception, HttpServletRequest request) {
		String resourceKey = null;
		if ((exception instanceof DataException || exception instanceof ValidationException || exception instanceof SecurityException) &&
				exception.getFaultReason() != null) {
			resourceKey = exception.getFaultReason().getResourceKey();
			LOGGER.error(exception.getMessage());
		} else if (exception instanceof SessionExpiredException) {
			LOGGER.warn(exception.getMessage());

			final Response<String> response = new Response<>(null, ResponseStatus.SESSION_EXPIRED);
			response.setStatusMessage(messageSource.getMessage("sessionExpired", null, getActiveLocale(request)));
			return response;
		}

		if (!StringUtils.hasText(resourceKey)) {
			resourceKey = "genericError";
			LOGGER.error(exception.getMessage(), exception);
		}

		final Response<String> response = new Response<>(null, ResponseStatus.ERROR);
		response.setStatusMessage(messageSource.getMessage(resourceKey, exception.getArguments(), getActiveLocale(request)));
		response.setFaultId(exception.getFaultReason().getId());
		return response;
	}

	/**
	 * Handles all non {@link Exception exceptions}.
	 *
	 * @param exception the handled by this method.
	 * @param request   the request
	 */
	@ExceptionHandler(Exception.class)
	protected Response handleException(Exception exception, HttpServletRequest request) {
		LOGGER.error(exception.getMessage(), exception);

		final Response<String> response = new Response<>(null, ResponseStatus.ERROR);
		response.setStatusMessage(messageSource.getMessage("genericError", null, getActiveLocale(request)));
		return response;
	}

	/**
	 * Retrieves active locale from the application scope. This is configured with {@link SessionLocaleResolver} at spring-conf.xml.
	 *
	 * @param request the request
	 * @return the active locale
	 */
	protected Locale getActiveLocale(HttpServletRequest request) {
		Locale locale = (Locale) WebUtils.getSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		if (locale == null) {
			locale = SupportedLanguage.getDefault().getLocale();
		}
		return locale;
	}

	/**
	 * Retrieves the logged in {@link gr.teachspot.library.domain.User} from the {@link javax.servlet.http.HttpSession}.
	 *
	 * @param request the {@link javax.servlet.http.HttpServletRequest}
	 * @return the logged in {@link gr.teachspot.library.domain.User}
	 */
	protected User getActiveUser(HttpServletRequest request) {
		String userId = getActiveUserId(request);
		if (StringUtils.hasText(userId)) {
			User user = userService.find(Long.parseLong(userId));
			//remove the password for security reasons
			user.setPassword(null);
			return user;
		} else {
			return null;
		}
	}

	/**
	 * Retrieves the logged in user id from the {@link javax.servlet.http.HttpSession}.
	 *
	 * @param request the {@link javax.servlet.http.HttpServletRequest}
	 * @return the logged in user's id
	 */
	protected String getActiveUserId(HttpServletRequest request) {
		if (WebUtils.getSessionAttribute(request, (SessionAttribute.ACTIVE_USER_ID.name())) != null) {
			return WebUtils.getSessionAttribute(request, (SessionAttribute.ACTIVE_USER_ID.name())).toString();
		} else {
			return null;
		}
	}

	/**
	 * Retrieves the logged in user active profile id from the {@link javax.servlet.http.HttpSession}.
	 *
	 * @param request the {@link javax.servlet.http.HttpServletRequest}
	 * @return the logged in user's active profile id
	 */
	protected Long getActiveUserProfileId(HttpServletRequest request) {
		if (WebUtils.getSessionAttribute(request, (SessionAttribute.ACTIVE_USER_PROFILE_ID.name())) != null) {
			return Long.parseLong(WebUtils.getSessionAttribute(request, (SessionAttribute.ACTIVE_USER_PROFILE_ID.name())).toString());
		} else {
			return null;
		}
	}

	/**
	 * Returns true if the user has administrator rights.
	 *
	 * @param user - the user to check
	 * @return true if the user is administrator
	 */
	protected boolean isUserAdmin(User user) {
		return user.isAdmin();
	}
}

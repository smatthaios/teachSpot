package gr.teachspot.library.service;

import gr.teachspot.library.enumeration.FaultReason;
import gr.teachspot.library.enumeration.ResponseStatus;
import gr.teachspot.library.enumeration.SupportedLanguage;
import gr.teachspot.library.exception.*;
import gr.teachspot.library.exception.SecurityException;
import gr.teachspot.library.transport.Fault;
import gr.teachspot.library.transport.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * This is the implementation of the {@link ErrorService} class. It also contains methods needed for assembling {@link gr.teachspot.library.transport.Fault} messages.
 */
@Service
public class ErrorServiceImpl implements ErrorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorService.class);
	/**
	 * The message source.
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response assembleResult(final Exception exception, SupportedLanguage language) {
		final Response response = new Response();
        response.setStatus(ResponseStatus.ERROR);
		final Fault fault = assembleFault(exception, language, response);

		response.setStatusMessage(fault.getFaultDescription());

		assembleTimeStamp(response, language);
		return response;
	}

	/**
	 * Assemble {@link Fault} entity, to be used for returning the proper message to the client. The messages are retrieved from
	 * exception_*.properties files.
	 *
	 * @param exception the exception to retrieve data
	 * @param language  the language in which we should assemble our answer.
	 */
	private Fault assembleFault(final Exception exception, final SupportedLanguage language, Response response) {
		final Fault fault = new Fault();

		/* CASE 1: UserNotFoundException is an exception triggered when a user wasn't found */
		if (exception instanceof UserNotFoundException) {
			assembleUserException(fault, (UserNotFoundException) exception, language);
			return fault;
		}
		/* CASE 2: ValidationException  must be thrown when validations fail among applicationd */
		else if (exception instanceof EmailNotFoundException) {
			assembleEmailException(fault, (EmailNotFoundException) exception, language);
			return fault;
		}
		/* CASE 3: ValidationException  must be thrown when validations fail among applicationd */
		else if (exception instanceof ValidationException) {
			assembleValidationException(fault, (ValidationException) exception, language);
			return fault;
		}
		/* CASE 4:  UnauthorisedUserException must be thrown when an unauthorized {@link User} tried to gain access to the system*/
		else if (exception instanceof UnauthorisedUserException) {
			assembleUnauthorisedUserException(fault, (UnauthorisedUserException) exception, language);
			return fault;
		}
        /* CASE 5:  IriIOException must be thrown when an input/output exception occurs*/
		else if (exception instanceof InsufficientAccessRightException) {
			assembleInsufficientAccessRightException(fault, (InsufficientAccessRightException) exception, language);
			return fault;
		}
        /* CASE 6:  SecurityException must be thrown when an {@link User} tried to manipulate data that do not belong to him*/
		else if (exception instanceof SecurityException) {
			assembleSecurityException(fault, (SecurityException) exception, language);
			return fault;
		}
        /* CASE 7:  IriIOException must be thrown when an input/output exception occurs*/
		else if (exception instanceof EmailException) {
			assembleEmailException(fault, (EmailException) exception, language);
			return fault;
		}
        /* CASE 8:  DataException must be thrown when some data in the database are not consistent*/
		else if (exception instanceof DataException) {
			assembleDataException(fault, (DataException) exception, language);
			return fault;
		}
        /* CASE 9:  IriIOException must be thrown when an input/output exception occurs*/
		else if (exception instanceof IOException) {
			assembleIOException(fault, (IOException) exception, language);
			return fault;
		}
        /* CASE 10: Generic exception. */
		else {
			assembleException(fault, language);
			return fault;
		}
	}

	private void assembleException(final Fault fault, final SupportedLanguage language) {
		Locale locale = language.getLocale();

		final FaultReason faultId = FaultReason.GENERIC_ERROR;
		final String exMessageLocalized = messageSource.getMessage(faultId.getResourceKey(), null, locale);
		fault.setFaultDescription(exMessageLocalized);

		fault.setFaultId(faultId.getId());
	}

	private void assembleUserException(final Fault fault, final UserNotFoundException userNotFoundException, final SupportedLanguage language) {
		Locale locale = language.getLocale();

		final FaultReason faultId = userNotFoundException.getFaultReason();
		final String exMessageLocalized = messageSource.getMessage(faultId.getResourceKey(), new Object[]{userNotFoundException.getMessage()},
				locale);
		fault.setFaultDescription(exMessageLocalized);
		fault.setFaultId(faultId.getId());
	}

	private void assembleEmailException(final Fault fault, final EmailNotFoundException emailNotFoundException, final SupportedLanguage language) {
		Locale locale = language.getLocale();

		final FaultReason faultId = emailNotFoundException.getFaultReason();
		final String exMessageLocalized = messageSource.getMessage(faultId.getResourceKey(), new Object[]{emailNotFoundException.getMessage()},
				locale);
		fault.setFaultDescription(exMessageLocalized);
		fault.setFaultId(faultId.getId());
	}

	private void assembleValidationException(final Fault fault, final ValidationException validationException, final SupportedLanguage language) {
		Locale locale = language.getLocale();

		final FaultReason faultId = validationException.getFaultReason();
		final String exMessageLocalized = messageSource.getMessage(faultId.getResourceKey(), new Object[]{validationException.getMessage()}, locale);
		fault.setFaultDescription(exMessageLocalized);
		fault.setFaultId(faultId.getId());
	}

	private void assembleUnauthorisedUserException(final Fault fault, final UnauthorisedUserException unauthorisedUserException,
												   final SupportedLanguage language) {
		Locale locale = language.getLocale();

		final FaultReason faultId = unauthorisedUserException.getFaultReason();
		final String exMessageLocalized = messageSource.getMessage(faultId.getResourceKey(), new Object[]{unauthorisedUserException.getMessage()},
				locale);
		fault.setFaultDescription(exMessageLocalized);
		fault.setFaultId(faultId.getId());
	}

	private void assembleInsufficientAccessRightException(final Fault fault, final InsufficientAccessRightException
			insufficientAccessRightException, final SupportedLanguage language) {
		Locale locale = language.getLocale();

		final FaultReason faultId = insufficientAccessRightException.getFaultReason();

		final String exMessageLocalized = messageSource.getMessage(faultId.getResourceKey(), new Object[]{insufficientAccessRightException
				.getMessage()}, locale);
		fault.setFaultDescription(exMessageLocalized);
		fault.setFaultId(faultId.getId());
	}

	private void assembleEmailException(final Fault fault, final EmailException emailException, final SupportedLanguage language) {
		Locale locale = language.getLocale();

		final FaultReason faultId = emailException.getFaultReason();

		final String exMessageLocalized = messageSource.getMessage(faultId.getResourceKey(), new Object[]{emailException.getMessage()}, locale);
		fault.setFaultDescription(exMessageLocalized);
		fault.setFaultId(faultId.getId());
	}

	private void assembleSecurityException(final Fault fault, final SecurityException securityException, final SupportedLanguage language) {
		Locale locale = language.getLocale();

		final FaultReason faultId = securityException.getFaultReason();

		final String exMessageLocalized = messageSource.getMessage(faultId.getResourceKey(), new Object[]{securityException.getMessage()}, locale);
		fault.setFaultDescription(exMessageLocalized);
		fault.setFaultId(faultId.getId());
	}

	private void assembleDataException(final Fault fault, final DataException dataException, final SupportedLanguage language) {
		Locale locale = language.getLocale();

		final FaultReason faultId = dataException.getFaultReason();

		final String exMessageLocalized = messageSource.getMessage(faultId.getResourceKey(), new Object[]{dataException.getMessage()}, locale);
		fault.setFaultDescription(exMessageLocalized);
		fault.setFaultId(faultId.getId());
	}

	private void assembleIOException(final Fault fault, final IOException ioException, final SupportedLanguage language) {
		Locale locale = language.getLocale();

		final FaultReason faultId = ioException.getFaultReason();

		final String exMessageLocalized = messageSource.getMessage(faultId.getResourceKey(), new Object[]{ioException.getMessage()}, locale);
		fault.setFaultDescription(exMessageLocalized);
		fault.setFaultId(faultId.getId());
	}

	/**
	 * This method assembles the time stamp in {@link Response} object.
	 *
	 * @param response the updated object.
	 */
	private void assembleTimeStamp(final Response response, final SupportedLanguage language) {
		Locale locale = language.getLocale();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
		response.setCreatedOn(formatter.format(Calendar.getInstance(locale).getTime()));
	}

}
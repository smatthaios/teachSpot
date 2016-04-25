package gr.teachspot.library.service;

import gr.teachspot.library.transport.Response;
import gr.teachspot.library.enumeration.SupportedLanguage;

/** This interface provides methods needed for error handling. */
public interface ErrorService {
    /**
     * This method assembles an error result object. Error result object is a result object
     * which contains the error occurred during processing the client request.
     *
     * @param exception the
     * holding the cause of the exception.
     * @param language the language
     * @return the response to return
     */
    Response assembleResult(final Exception exception, SupportedLanguage language);


}

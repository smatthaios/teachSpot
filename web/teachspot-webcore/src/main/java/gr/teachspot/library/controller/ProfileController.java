package gr.teachspot.library.controller;

import gr.teachspot.library.exception.DataException;
import gr.teachspot.library.service.ProfileService;
import gr.teachspot.library.transport.Response;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import gr.teachspot.library.enumeration.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/** The {@link gr.teachspot.library.controller.ProfileController} contains all {@link gr.teachspot.library.domain.User} related methods (authenticate, retrieve etc). */
@RestController
@RequestMapping("/profiles")
public class ProfileController extends AbstractController {
	/** The prefix to be used for performance statistics */
	private static final String MODULE = "Profile";

	/** The LOGGER. */
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The Profile Service. */
	@Autowired
	private ProfileService profileService;

	/**
	 * Sends a pair request for the specific {@link gr.teachspot.library.domain.User user} given his/hers id and the provided {@link gr.teachspot.library.domain.Lesson lesson}
	 *
	 * @param profileId the {@link gr.teachspot.library.domain.User users} {@link gr.teachspot.library.domain.Profile profile} id of the {@link gr.teachspot.library.domain.Profile profile} that we want to pair.
	 * @param lessonId the {@link gr.teachspot.library.domain.Lesson lesson} id of the {@link gr.teachspot.library.domain.Lesson lesson} we want to pair with.
	 * @return a response indicating that pair request was sent successfully.
	 * @throws gr.teachspot.library.exception.DataException if pair request wasn't sent due to an error
	 */
	@RequestMapping(value = "{profileId}/lessons/{lessonId}", method = RequestMethod.POST, headers = "action=pairRequest")
	public Response<String> pairRequest(@PathVariable Long profileId, @PathVariable Long lessonId) throws
            DataException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();
		LOGGER.info("Sending pair request to Profile[id:{}] for Lesson[Id:{}].", profileId, lessonId);

		profileService.pairRequest(profileId, lessonId);

		stopWatch.stop(MODULE + "pairRequest");
		return new Response<>(null, ResponseStatus.OK);
	}
}

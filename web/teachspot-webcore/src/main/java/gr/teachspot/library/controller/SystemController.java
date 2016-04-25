package gr.teachspot.library.controller;

/*import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * This class provides functionality for the basic actions of our application.
 */
@RestController
public class SystemController extends AbstractController {
	/** The LOGGER. */
	private Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

	/**
	 * The Constant MODULE_NAME used as logging prefix.
	 */
	private final static String MODULE_NAME = "SYSTEM_";

	/**
	 * Invalidates the session after serving redirecting to login page.
	 *
	 * @param request the request
	 * @return theview to render
	 */
	@RequestMapping(value = "logout.html", method = RequestMethod.GET)
	public ModelAndView logout(final HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:login.html");
	}

	/**
	 * Invalidates the session after serving login page.
	 *
	 * @param request the request
	 * @return theview to render
	 */
	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public ModelAndView login(final HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView();
	}

	/**
	 * Serves main.html page. It passes the active user as a JSON object, to prevent loading it client side.
	 */
	/*@RequestMapping(value = "main.html", method = RequestMethod.GET)
	public ModelAndView main(final HttpServletRequest request) throws JsonProcessingException {
		ModelAndView mvc = new ModelAndView();
		mvc.getModel().put("user", new ObjectMapper().writeValueAsString(getActiveUser(request)));
		return mvc;
	}*/

}
package com.panthole.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.panthole.domain.User;
import com.panthole.service.UserService;

@Path("users")
public class UserResource {

	private static final Logger LOGGER = Logger.getLogger(UserResource.class);

	@Autowired
	private UserService userService;

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.TEXT_XML })
	public User saveUser(final User user) {
		return userService.saveUser(user);
	}
	
	@Path("/user")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public User getUserByQuery(@QueryParam("id") final String userId) {
        final User user = userService.getUser(userId);
        UserResource.LOGGER.debug(user);
        return user;
    }

}

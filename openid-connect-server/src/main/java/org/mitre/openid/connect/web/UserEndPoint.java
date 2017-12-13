package org.mitre.openid.connect.web;

import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.mitre.openid.connect.model.User;
import org.mitre.openid.connect.service.UserService;
import org.mitre.openid.connect.util.MailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping(value = "/" + UserEndPoint.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserEndPoint {

	public static final String URL = "portal/userdetails/";
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private  MailUtils mailUtils;

	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserEndPoint.class);
	private Gson gson = new Gson();
	private JsonParser parser = new JsonParser();
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateUser(@RequestBody String jsonString) {
		
		JsonObject json;
		User user = null;
		try {
			json = parser.parse(jsonString).getAsJsonObject();
			user = gson.fromJson(json, User.class);
			userService.saveOrUpdateUser(user);
			System.out.println("in update user"+ jsonString);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseUtils.renderError(new ResponseEntity<String>(), e);
		}
		return ResponseUtils.renderSuccess("OK", HttpStatus.OK);
	}
	@RequestMapping(value = "/createuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createUser(@RequestBody String jsonString) {
		System.out.println("UserEndPoint.createUser "+jsonString);
		JsonObject json;
		User user = null;
		try {
			json = parser.parse(jsonString).getAsJsonObject();
			user = gson.fromJson(json, User.class);
			System.out.println("UserEndPoint.createUser enabled"+user.getEnabled());
			userService.saveOrUpdateUser(user);
			VelocityContext velocityContext = new VelocityContext();
			velocityContext.put("userName", user.getUsername());
			velocityContext.put("emailId", user.getUsername());
			velocityContext.put("password", user.getPassword());
			velocityContext.put("template-code", "createAMSUser");
			mailUtils.sendEmail("swathi.nadipelli@ggktech.com", "User Creation at AMS", velocityContext, mailSender);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseUtils.renderError(new ResponseEntity<String>(), e);
		}
		return ResponseUtils.renderSuccess("OK", HttpStatus.OK);
	}
	
	
}

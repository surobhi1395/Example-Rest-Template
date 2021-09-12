package com.rest.template.springbootresttemplateex.service;

import com.rest.template.springbootresttemplateex.model.Datum;
import com.rest.template.springbootresttemplateex.model.PostUser;
import com.rest.template.springbootresttemplateex.model.User;
import com.rest.template.springbootresttemplateex.service.validate.UserValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserValidation userValidation;

	private final RestTemplate restTemplate;

	@Autowired
	public UserServiceImpl(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}

	@Value("${api.base.url}")
	private String baseUrl;

	@Value("${api.list.user.url}")
	private String listUserUrl;

	/**
	 * @param
	 * @return
	 */
	public List<User> getAllUsers()
	{
        String url =baseUrl+listUserUrl;
		ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(url, User.class);
		if(!ObjectUtils.isEmpty(userResponseEntity)){
			User user = userResponseEntity.getBody();
			return Arrays.asList(user);
		}
	return Collections.emptyList();
	}

	@Override
	public User addUser(PostUser postUser) {

		String url =baseUrl+listUserUrl;
		ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(url, User.class);
		if(userValidation.checkUserValidation("morpheus", "leader")){
			return userResponseEntity.getBody();
		}
		return null;
	}

}

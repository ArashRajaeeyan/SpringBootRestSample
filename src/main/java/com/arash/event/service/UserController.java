package com.arash.event.service;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arash.event.dal.UserRepository;
import com.arash.event.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * create a new User in persistence storage, generate id
	 * 
	 * @param name
	 *            name to create user object to add to persistence storage
	 * @return return new User object with generated id value
	 */
	@RequestMapping(method = POST)
	public User create(@RequestBody String name) {
		User user = new User();
		user.setName(name);
		User saved = userRepository.save(user);
		return saved;
	}

	/**
	 * update existing user field and return modified object
	 * 
	 * @param user
	 *            user object to change
	 * @return modified object
	 */
	@RequestMapping(method = PUT)
	public User update(@RequestBody User user) {
		User updated = userRepository.save(user);
		return updated;
	}

	/**
	 * Delete user with given id from persistence storage
	 * 
	 * @param id
	 */
	@RequestMapping(path = "/{id}", method = DELETE)
	public void delete(@PathVariable("id") Long id) {
		userRepository.delete(id);
	}

	/**
	 * return user with given id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/{id}", method = GET)
	public User get(@PathVariable("id") Long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	/**
	 * return all user methods
	 * 
	 * @return
	 */
	@RequestMapping(path = "/all", method = GET)
	public List<User> findAll() {
		Iterable<User> it = userRepository.findAll();
		List<User> users = new LinkedList<User>();
		for (User user : it) {
			users.add(user);
		}
		return users;
	}

	/**
	 * 
	 * @param page
	 *            zero-based page index.
	 * @param size
	 *            the size of the page to be returned.
	 * 
	 * @return a page of user entities
	 */
	@RequestMapping(method = GET)
	public Iterable<User> findAllPaged(
			@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "size", defaultValue = "4", required = false) int size) {
		Page<User> result = userRepository.findAll(new PageRequest(page, size));
		return result.getContent();
	}
	
	/**
	 * I just put this empty method as sample of one of many ways to handle
	 * exception in Spring REST
	 */
	@ResponseStatus(NOT_FOUND)
	@ExceptionHandler({ NoResultException.class })
	public void handleNoResultException() {
		// can have more error handling here
	}

}

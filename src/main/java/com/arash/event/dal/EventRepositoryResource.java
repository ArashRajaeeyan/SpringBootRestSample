package com.arash.event.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.arash.event.entity.Event;

/**
 * Spring Repository to perform as DAL and expose them in a REST Service 
 * 
 * this is based on HAL and HATEOS that not every body likes
 * 
 * 
 * if we need more control we can do it other way like what I did for User
 * 
 * 
 * @author Arash Rajaeeyan
 *
 */

@RepositoryRestResource(collectionResourceRel = "event", path = "event")
public interface EventRepositoryResource
		extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {
	
	/**
	 * Sample custom query
	 * @param eventType String 
	 * @return matching events
	 */
	@Query("SELECT e FROM Event e WHERE LOWER(e.eventType) = LOWER(:eventType)")
	public List<Event> findByEventType(@Param("eventType") String eventType);
}

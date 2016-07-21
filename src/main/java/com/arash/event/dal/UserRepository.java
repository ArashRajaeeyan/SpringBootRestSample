package com.arash.event.dal;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.arash.event.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}

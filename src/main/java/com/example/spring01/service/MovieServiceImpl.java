package com.example.spring01.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.MovieDAO;
import com.example.spring01.model.dto.MovieDTO;

@Service
public class MovieServiceImpl implements MovieService {

	@Inject
	MovieDAO moviedao;

	@Override
	public void insertMovie (MovieDTO vo) {
		
	}
}

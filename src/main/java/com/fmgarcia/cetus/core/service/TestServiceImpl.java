package com.fmgarcia.cetus.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmgarcia.cetus.core.domain.Test;
import com.fmgarcia.cetus.core.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository testRopository;

	@Override
	public Test create(Test test) {
		return testRopository.save(test);
	}

	@Override
	public List<Test> findAll() {
		return testRopository.findAll();
	}

}

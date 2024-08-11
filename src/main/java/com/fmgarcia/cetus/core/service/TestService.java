package com.fmgarcia.cetus.core.service;

import java.util.List;

import com.fmgarcia.cetus.core.domain.Test;

public interface TestService {

	public Test create(Test test);

	public List<Test> findAll();

}

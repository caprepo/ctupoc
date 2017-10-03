package com.capgemini.ctu.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capgemini.ctu.dao.CtuDao;
import com.capgemini.ctu.service.CtuService;

@Component
@Service
public class CtuServiceImpl implements CtuService{
	static Logger logger = Logger.getLogger(CtuServiceImpl.class);

	@Autowired
	private CtuDao ctuDao;

	@Value("${max.recent.transactions}")
	private Integer maxRecentTransactions;

}

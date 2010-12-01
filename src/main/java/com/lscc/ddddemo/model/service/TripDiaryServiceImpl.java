package com.lscc.ddddemo.model.service;

import org.springframework.transaction.annotation.Transactional;

import com.lscc.ddddemo.model.entity.TripDiary;

public class TripDiaryServiceImpl {
	
	@Transactional
	public TripDiary createNewDiary(String diaryName) {
		TripDiary td = new TripDiary();
		td.setName(diaryName);
		td.save();
		return td;
	}

}

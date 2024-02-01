package com.project.json;

import java.util.List;

public interface JsonService {

	List<JsonVO> getJsonList(JsonVO vo);
	
	void jsonInsert(JsonVO vo);
}

package com.xuechong.utils.json;

import com.google.gson.Gson;

public class DefaultJsonTransfomer implements JsonTransformer{

	@Override
	public String transForm(Object o) {
		return new Gson().toJson(o);
	}
	
}

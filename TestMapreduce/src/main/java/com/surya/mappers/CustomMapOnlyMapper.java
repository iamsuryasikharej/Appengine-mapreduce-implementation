package com.surya.mappers;

import com.google.appengine.tools.mapreduce.MapOnlyMapper;

public class CustomMapOnlyMapper extends MapOnlyMapper {

	@Override
	public void map(Object arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
	}

}

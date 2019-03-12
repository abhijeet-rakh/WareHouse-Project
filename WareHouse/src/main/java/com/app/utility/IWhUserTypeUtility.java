package com.app.utility;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.model.WhUserType;

public interface IWhUserTypeUtility{

	public static Map<Integer,String> ConversionListToMap(List<Object[]> list){
	  Map<Integer,String> map=list.stream().collect(Collectors.toMap(ob->(Integer)ob[0],ob->(String)ob[1]));
	  return map;
	}

}

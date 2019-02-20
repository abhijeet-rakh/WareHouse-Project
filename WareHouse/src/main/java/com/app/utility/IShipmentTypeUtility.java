package com.app.utility;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface IShipmentTypeUtility {
	
	public static Map<Integer,String> ConvertListtoMap(List<Object[]> list) {
		System.out.println("IShipmentTypeUtility Map");
		Map<Integer,String> map=list.stream().collect(Collectors.toMap(ob->(Integer)ob[0],ob->(String)ob[1]));
		return map;
	}

}

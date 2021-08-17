package com.example.SessionAndCache;

import com.example.SessionAndCache.controller.CacheController;
import com.example.SessionAndCache.store.MemoryStore;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

@SpringBootTest
class SessionAndCacheApplicationTests {


	@Test
	void contextLoads(){
		LinkedList<String> ca = new LinkedList<>();
		ca.add("hello1");
		ca.add("hello2");
		ca.add("hello3");
		ca.add("hello4");

		LinkedHashMap<String,String> ba = new LinkedHashMap<>();
		ba.put("hello1","hello1");
		ba.put("hello2","hello2");
		ba.put("hello3","hello3");
		ba.put("hello4","hello4");
		int i = 0;
		while (i < ca.size()) {
			if (ca.get(i) == "hello3")
				break ;
		}
		ba.get("hello3");
	}

	@Test
	void save() {
		CacheController cacheController = new CacheController(5);
		String res = "";
		cacheController.put("jihuhwan1");
		res = cacheController.getAll();
		System.out.println("res = " + res);
		cacheController.put("jihuhwan2");
		cacheController.put("jihuhwan3");
		res = cacheController.getAll();
		System.out.println("res = " + res);
		cacheController.put("jihuhwan1");
		res = cacheController.getAll();
		System.out.println("res = " + res);
	}
}

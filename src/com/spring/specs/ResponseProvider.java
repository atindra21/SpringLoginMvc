package com.spring.specs;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseProvider {
	
	static Logger log = Logger.getLogger(ResponseProvider.class);

	public static void getByteOfList(@SuppressWarnings("rawtypes") List list,HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			log.info(mapper.writeValueAsString(list));
			response.getOutputStream().write(mapper.writeValueAsString(list).getBytes());
		} catch ( IOException e) {
			log.error("Exception while getting bytes",e);
		}
		
	}
}

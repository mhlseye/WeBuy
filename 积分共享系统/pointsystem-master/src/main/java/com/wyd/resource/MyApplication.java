package com.wyd.resource;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class MyApplication extends ResourceConfig{
	 public MyApplication() {
	     register(RequestContextFilter.class);
		 register(MultiPartFeature.class);
		 packages("com.wyd.resource");
	    }
}

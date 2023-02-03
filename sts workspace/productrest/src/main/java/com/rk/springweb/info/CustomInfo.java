package com.rk.springweb.info;

import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import static java.util.Map.entry;

@Component
public class CustomInfo implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub
		builder.withDetails(Map.ofEntries(
			    entry("Application Name", "productrest"),
			    entry("context path", "productapi")
			));

	}

}

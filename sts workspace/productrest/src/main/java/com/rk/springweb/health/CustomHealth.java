package com.rk.springweb.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealth implements HealthIndicator {

	@Override
	public Health health() {
		return Health.up().withDetail("Success", "code green").build();
	}
}

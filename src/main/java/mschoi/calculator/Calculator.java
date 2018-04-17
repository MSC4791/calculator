package mschoi.calculator;

import org.springframework.stereotype.Service;

/**
 * Calculator Class
 */
@Service
public class Calculator {
	int sum(int a, int b) {
		return a + b;
	}
	int sub(int a, int b) {
		return a - b;
	}
}

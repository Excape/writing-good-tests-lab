package com.zuehlke.testing.testdoubles.solution;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;

import com.zuehlke.testing.testdoubles.exercise.Telephone;
import com.zuehlke.testing.testdoubles.exercise.VoiceMailService;

public class TelephoneTest {

	private static final String NUMBER = "0791234567";

	@Test
	public void testCall_busy_forwardToVoiceMail() {
		// arrange
		VoiceMailServiceSpy spy = new VoiceMailServiceSpy();
		Telephone testee = new Telephone(spy);
		testee.setBusy(true);

		// act
		testee.call(NUMBER);

		// assert
		assertThat(spy.callingNumber, is(equalTo(NUMBER)));

	}
}

class VoiceMailServiceSpy implements VoiceMailService {

	String callingNumber;

	@Override
	public void call(String callingNumber) {
		this.callingNumber = callingNumber;
	}

}
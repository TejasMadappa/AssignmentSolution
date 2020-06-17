package com.myapp.threads;

import java.util.Arrays;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.myapp.exception.UpdatesRetrievalException;
import com.myapp.model.Update;
import com.myapp.repo.UpdatesPending;

@Component
public class ScheduledTask {

	private UpdatesPending updatesPending;

	@Scheduled(fixedRate = (60 * 60 * 1000) * 4)
	public void getUpdatesEveryFourHour() throws UpdatesRetrievalException {

		// this has to hit the server. But for now, I will get some dummy update object.

		// this updates have to be cached.
		// I have not implemented as of now.
		if (updatesPending == null) {
			updatesPending = UpdatesPending.getInstance();
		}
		updatesPending.addUpdates(getUpdates());
	}

	private List<Update> getUpdates() {

		// for now I am just returning empty updates.

		return Arrays.asList(new Update());
	}
}

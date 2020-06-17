package com.myapp.repo;

import java.util.List;
import java.util.Vector;

import com.myapp.model.Update;

public class UpdatesPending {
	private volatile static UpdatesPending obj;

	private Vector<Update> updates = new Vector<>();

	public static UpdatesPending getInstance() {
		if (obj == null) {
			synchronized (UpdatesPending.class) {
				if (obj == null) {
					obj = new UpdatesPending();
				}
			}
		}

		return obj;
	}

	public void addUpdates(List<Update> updates) {
		this.updates.addAll(updates);
	}

	public void removeUpdates(List<Update> updates) {
		this.updates.removeAll(updates);
	}

	public int getUpdatesCount() {
		return updates.size();
	}

	public void clearAllUpdates() {
		updates.clear();
	}
}

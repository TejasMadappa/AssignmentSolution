package com.myapp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.model.Update;
import com.myapp.repo.UpdatesPending;

@Controller
public class AppController {

	@GetMapping("/updates")
	public String getUpdates(Model model) {
		int updateCount = UpdatesPending.getInstance().getUpdatesCount();
		
		model.addAttribute("updates", updateCount);

		return "updates";
	}

	@PostMapping("/updates")
	public void removeUpdates(@ModelAttribute List<Update> updates) {
		UpdatesPending.getInstance().removeUpdates(updates);
	}

}

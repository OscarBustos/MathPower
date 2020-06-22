package com.bustos.oscar.mathpower;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bustos.oscar.mathpower.game.ui.MainFrame;

@SpringBootApplication
public class MathPowerGameApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MathPowerGameApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MathPowerGameApplication.class);
		//AppConstants appConstants = context.getBean(AppConstants.class);
		System.setProperty("java.awt.headless", "false");
		//Constants.loadConstants(appConstants);
		MainFrame mainFrame = new MainFrame(context);
		mainFrame.setVisible(true);
		mainFrame.update();
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("texto");

		// TODO: Execute the code to load the saved state
	}
	
}

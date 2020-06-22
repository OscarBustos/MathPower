package com.bustos.oscar.mathpower.game.ui.panels;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.bustos.oscar.mathpower.game.general.GameManager;
import com.bustos.oscar.mathpower.game.general.GameStatus;

public class MainMenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainMenuPanel() {
		Init();
	}

	private void Init() {
		this.setBackground(Color.BLACK);
		JButton startButton = new JButton("Start");
		startButton.addActionListener((e) -> {
			GameManager.changeGameState(GameStatus.NEW_GAME);
		});
		this.add(startButton);

	}


}

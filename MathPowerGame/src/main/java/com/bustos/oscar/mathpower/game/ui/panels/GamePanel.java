package com.bustos.oscar.mathpower.game.ui.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.bustos.oscar.mathpower.game.general.GameManager;
import com.bustos.oscar.mathpower.game.general.GameStatus;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GamePanel() {
		Init();
	}

	private void Init() {
		this.setBackground(Color.GRAY);

		JButton endGameButton = new JButton("EndGame");
		endGameButton.addActionListener((e) -> GameManager.changeGameState(GameStatus.GAME_OVER));
		this.add(endGameButton);
		GameManager.changeGameState(GameStatus.RUNNING);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		((Graphics2D) g).drawString("" + GameManager.getCurrentStatus(), 10, 10);

	}
}

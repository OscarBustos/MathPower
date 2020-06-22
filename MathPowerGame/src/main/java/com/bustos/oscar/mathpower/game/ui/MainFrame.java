package com.bustos.oscar.mathpower.game.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;

import com.bustos.oscar.mathpower.game.general.GameLoop;
import com.bustos.oscar.mathpower.game.general.GameManager;
import com.bustos.oscar.mathpower.game.general.GameStatus;
import com.bustos.oscar.mathpower.game.ui.panels.GamePanel;
import com.bustos.oscar.mathpower.game.ui.panels.MainMenuPanel;

public class MainFrame extends JFrame implements GameLoop {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainMenuPanel mainMenu;
	private GamePanel gamePanel;

	public MainFrame(ApplicationContext context) {
		GameManager.generateInstance(context);
		awake();
		start();
	}

	@Override
	public void start() {
		GameManager.start();
	}

	@Override
	public void awake() {
		Init();
	}

	private void Init() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				GameManager.closeGame();
				System.exit(0);
			}
		});
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		mainMenu = new MainMenuPanel();
		this.add(mainMenu);

	}

	@Override
	public void update() {
		while (!GameManager.isExit()) {
			this.updateUI();
			this.validate();
			this.repaint();
		}
	}

	private void updateUI() {
		if (GameManager.isStartNewGame()) {
			this.remove(mainMenu);
			if (gamePanel == null) {
				gamePanel = new GamePanel();
			}
			this.add(gamePanel);
			GameManager.setStartNewGame(false);
		} else if (GameManager.isGameOver()) {
			if (gamePanel.isDisplayable()) {
				this.remove(gamePanel);
				this.add(mainMenu);
				GameManager.changeGameState(GameStatus.START);
			}
		}

	}

}

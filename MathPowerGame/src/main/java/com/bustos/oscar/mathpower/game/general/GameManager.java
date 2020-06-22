package com.bustos.oscar.mathpower.game.general;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;

public class GameManager {

	private static ApplicationContext applicationContext;
//	private static GameProperties gameProperties;

	private static GameStatus currentStatus;
	private static boolean gameOver;
	private static boolean showPauseMenu;
	private static boolean startNewGame;
	private static boolean running;
	private static boolean exit;

	static {
		loadGame();
	}

	public static void generateInstance(ApplicationContext context) {
		applicationContext = context;
//		applicationContext.getBean(GameProperties.class);
	}

	private GameManager() {
	}

	public static void loadGame() {

	}

	public static void start() {
		currentStatus = GameStatus.START;
		gameOver = false;

	}

	public static void closeGame() {
		System.out.println("Saving Game" + applicationContext.getApplicationName());
	}

	public static void changeGameState(GameStatus newStatus) {

		if (!currentStatus.equals(newStatus)) {
			switch (newStatus) {
			case PAUSED:
				setShowPauseMenu(true);
				break;
			case NEW_GAME:
				setStartNewGame(true);
				break;
			case RUNNING:
				setRunning(true);
				break;
			case GAME_OVER:
				setRunning(false);
				setGameOver(true);
				break;
			case START:
				setRunning(false);
				setGameOver(false);
				setStartNewGame(false);
				setShowPauseMenu(false);
			default:
				break;
			}

		}

	}

// ---------------------------SETTERS AND GETTERS--------------------------------------------------------	

	public static boolean isShowPauseMenu() {
		return showPauseMenu;
	}

	public static void setShowPauseMenu(boolean showPauseMenu) {
		GameManager.showPauseMenu = showPauseMenu;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

	public static void setGameOver(boolean gameOver) {
		GameManager.gameOver = gameOver;
	}

	public static GameStatus getCurrentStatus() {
		return currentStatus;
	}

	public static boolean isStartNewGame() {
		return startNewGame;
	}

	public static void setStartNewGame(boolean startNewGame) {
		GameManager.startNewGame = startNewGame;
	}

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		GameManager.running = running;
	}

	public static boolean isExit() {
		return exit;
	}

	public static void setExit(boolean exit) {
		GameManager.exit = exit;
	}

}

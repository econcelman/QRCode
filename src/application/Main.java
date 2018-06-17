package application;
	
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
			rectangles = createBoard(512,512,16);
			Group root = new Group();
			root.getChildren().addAll(rectangles);
			Scene scene = new Scene(root, 512,512);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public ArrayList<Rectangle> createBoard(int sceneX, int sceneY, int squareSize) {
		
		
		
		int boardX, boardY;
		
		boardX = (int) Math.floor(sceneX / squareSize);
		boardY = (int) Math.floor(sceneY / squareSize);
		
		ArrayList<Rectangle> rectangles = new ArrayList <Rectangle>();
		
		
		int[][] board = new int[boardX][boardY];
		Random rand = new Random();
		
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				board[i][j] = rand.nextInt(2);
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(board[i][j] == 1) {
					Rectangle rect = new Rectangle (i * squareSize, j * squareSize, squareSize, squareSize);
					rect.setFill(Color.BLACK);
					rectangles.add(rect);
				}
			}
		
		}
		
		Rectangle bigTopLeft = new Rectangle(0,0, squareSize*8, squareSize*8);
		bigTopLeft.setFill(Color.BLACK);
		rectangles.add(bigTopLeft);
		Rectangle middleTopLeft = new Rectangle(26,26, squareSize* 4.5, squareSize*4.5);
		middleTopLeft.setStroke(Color.WHITE);
		middleTopLeft.setStrokeWidth(20);
		rectangles.add(middleTopLeft);
		
		Rectangle bigTopRight = new Rectangle(384,0, squareSize*8, squareSize*8);
		bigTopLeft.setFill(Color.BLACK);
		rectangles.add(bigTopRight);
		Rectangle middleTopRight = new Rectangle(415,26, squareSize* 4.5, squareSize*4.5);
		middleTopRight.setStroke(Color.WHITE);
		middleTopRight.setStrokeWidth(20);
		rectangles.add(middleTopRight);
		
		Rectangle bigBottomLeft = new Rectangle(0,384, squareSize*8, squareSize*8);
		bigTopLeft.setFill(Color.BLACK);
		rectangles.add(bigBottomLeft);
		Rectangle middleBottomLeft = new Rectangle(26,415, squareSize* 4.5, squareSize*4.5);
		middleBottomLeft.setStroke(Color.WHITE);
		middleBottomLeft.setStrokeWidth(20);
		rectangles.add(middleBottomLeft);
		
		return rectangles;
	}
 
}
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public class GameMenuDemo extends Application
{

	Stage window;
	Scene main;
	Scene play;
	Scene instructions;
	Scene credits;

	private Parent createContent()
	{
		Pane root = new Pane();
		root.setPrefSize(800, 600);

		try (InputStream is = Files.newInputStream(Paths.get("res/imgs/Code_of_Honor.jpg")))
		{
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(800);
			img.setFitHeight(600);
			root.getChildren().add(img);
		} catch (IOException e)
		{
			System.out.println("Couldn't load image");
		}

		MenuItem itemExit = new MenuItem("EXIT");
		itemExit.setOnMouseClicked(event -> System.exit(0));

		MenuItem playMenu = new MenuItem("PLAY");
		playMenu.setOnMouseClicked(event -> window.setScene(play));

		MenuItem instructionMenu = new MenuItem("INSTRUCTIONS");
		instructionMenu.setOnMouseClicked(event -> window.setScene(instructions));

		MenuItem creditsMenu = new MenuItem("CREDITS");
		creditsMenu.setOnMouseClicked(event -> window.setScene(credits));

		MenuBox menu = new MenuBox(playMenu, instructionMenu, creditsMenu, itemExit);
		menu.setTranslateX(290);
		menu.setTranslateY(225);

		root.getChildren().addAll(menu);
		return root;
	}

	private Parent createInstructions()
	{
		Pane root = new Pane();
		root.setPrefSize(800, 600);

		try (InputStream is = Files.newInputStream(Paths.get("res/imgs/Code_of_Honor.jpg")))
		{
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(800);
			img.setFitHeight(600);
			root.getChildren().add(img);
		} catch (IOException e)
		{
			System.out.println("Couldn't load image");
		}

		MenuItem back = new MenuItem("BACK");
		back.setOnMouseClicked(event -> window.setScene(main));

		MenuBox menu = new MenuBox(back);
		menu.setTranslateX(290);
		menu.setTranslateY(500);

		root.getChildren().addAll(menu);
		return root;
	}

	private Parent createCredits()
	{
		Pane root = new Pane();
		root.setPrefSize(800, 600);

		try (InputStream is = Files.newInputStream(Paths.get("res/imgs/Code_of_Honor.jpg")))
		{
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(800);
			img.setFitHeight(600);
			root.getChildren().add(img);
		} catch (IOException e)
		{
			System.out.println("Couldn't load image");
		}

		MenuItem back = new MenuItem("BACK");
		back.setOnMouseClicked(event -> window.setScene(main));

		MenuBox menu = new MenuBox(back);
		menu.setTranslateX(290);
		menu.setTranslateY(500);

		root.getChildren().addAll(menu);
		return root;
	}

	private Parent createPlay()
	{
		Pane root = new Pane();
		root.setPrefSize(800, 600);

		try (InputStream is = Files.newInputStream(Paths.get("res/imgs/Code_of_Honor.jpg")))
		{
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(800);
			img.setFitHeight(600);
			root.getChildren().add(img);
		} catch (IOException e)
		{
			System.out.println("Couldn't load image");
		}

		MenuItem back = new MenuItem("BACK");
		back.setOnMouseClicked(event -> window.setScene(main));

		MenuBox menu = new MenuBox(back);
		menu.setTranslateX(290);
		menu.setTranslateY(500);

		root.getChildren().addAll(menu);
		return root;
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		main = new Scene(createContent());
		instructions = new Scene(createInstructions());
		credits = new Scene(createCredits());
		play = new Scene(createPlay());
		primaryStage.setTitle("Code of Honor");
		primaryStage.setScene(main);
		primaryStage.show();
	}

	/*
	 * private static class Title extends StackPane { public Title(String name) {
	 * Rectangle bg = new Rectangle(250, 60); bg.setStroke(Color.WHITE);
	 * bg.setStrokeWidth(2); bg.setFill(null);
	 * 
	 * Text text = new Text(name); text.setFill(Color.WHITE);
	 * text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 50));
	 * 
	 * setAlignment(Pos.CENTER); getChildren().addAll(bg, text); } }
	 */
	private static class MenuBox extends VBox
	{
		public MenuBox(MenuItem... items)
		{
			getChildren().add(createSeparator());

			for (MenuItem item : items)
			{
				getChildren().addAll(item, createSeparator());
			}
		}

		private Line createSeparator()
		{
			Line sep = new Line();
			sep.setEndX(200);
			sep.setStroke(Color.WHITE);
			return sep;
		}
	}

	private static class MenuItem extends StackPane
	{
		public MenuItem(String name)
		{
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.ORANGE), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.ORANGE) });

			Rectangle bg = new Rectangle(200, 40);
			bg.setOpacity(0.4);

			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 22));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);

			setOnMouseEntered(event -> {
				bg.setFill(gradient);
				text.setFill(Color.WHITE);
			});

			setOnMouseExited(event -> {
				bg.setFill(Color.BLACK);
				text.setFill(Color.WHITE);
			});

			setOnMousePressed(event -> {
				bg.setFill(Color.ORANGE);
			});

			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}

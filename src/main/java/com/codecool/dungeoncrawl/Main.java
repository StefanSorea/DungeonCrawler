package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.*;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.Door;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.items.Crown;
import com.codecool.dungeoncrawl.logic.actors.items.Key;
import com.codecool.dungeoncrawl.logic.actors.items.Potion;
import com.codecool.dungeoncrawl.logic.actors.items.Sword;
import com.codecool.dungeoncrawl.logic.actors.monsters.Cat;
import com.codecool.dungeoncrawl.logic.actors.monsters.Monster;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
    GameMap map;
    Canvas canvas;
    GraphicsContext context;
    Label healthLabel = new Label();
    Label damageLabel = new Label();
    public static boolean levelOneDone = false;
    private int currentLevel = 1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadLevel("/map.txt");
        context = canvas.getGraphicsContext2D();
        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("Health: "), 0, 0);
        ui.add(healthLabel, 1, 0);

        ui.add(new Label("Damage: "), 0, 23);
        ui.add(damageLabel, 1, 23);

        Label inventoryButton = new Label("INVENTORY");
        ui.add(inventoryButton,0,42);
        inventoryButton.setOnMouseClicked(value -> {

            Stage inventoryStage = new Stage();
            inventoryStage.initModality(Modality.WINDOW_MODAL);
            inventoryStage.initOwner(primaryStage);
            inventoryStage.setWidth(400);
            inventoryStage.setHeight(400);
            inventoryStage.setTitle("INVENTORY");

            ListView listView = new ListView();

            listView.getItems().add("Stone in my hand");

            for(int itemID: Inventory.inventory.keySet()){
                if(itemID ==2){
                    listView.getItems().add("A mysterious key");
                }else if(itemID ==1){
                    listView.getItems().add("A cat-slaying sword");
                }
            }

            Scene scene2 = new Scene(listView, 0, 0);
            inventoryStage.setScene(scene2);
            inventoryStage.showAndWait();

        });


        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();
    }

    private void loadLevel(String mapPath) {
        System.out.println("Loading level: " + mapPath);
        map = MapLoader.loadMap(mapPath);
        canvas = new Canvas(
                map.getWidth() * Tiles.TILE_WIDTH,
                map.getHeight() * Tiles.TILE_WIDTH);
    }

    public void message(String messageBody){
        Stage questionStage = new Stage();
        questionStage.initModality(Modality.WINDOW_MODAL);
        questionStage.setWidth(600);
        questionStage.setHeight(120);
        questionStage.setTitle("Interesting...");
        GridPane gridPane = new GridPane();


        Label messageBodyLabel = new Label(messageBody);
        gridPane.add(messageBodyLabel,0,0,1,1);

        Label yesLabel = new Label("OK");
        gridPane.add(yesLabel,0,2,2,1);

        yesLabel.setOnMouseClicked(value -> {

            questionStage.close();

        });

        Scene scene2 = new Scene(gridPane, 240, 100);
        questionStage.setScene(scene2);
        questionStage.showAndWait();

    }

    public boolean askQuestion(String questionBody){
        final boolean[] returnValue = new boolean[1];
        Stage questionStage = new Stage();
        questionStage.initModality(Modality.WINDOW_MODAL);
        questionStage.setWidth(750);
        questionStage.setHeight(120);
        questionStage.setTitle("Behold...");

        GridPane gridPane = new GridPane();


        Label questionBodyLabel = new Label(questionBody);
        gridPane.add(questionBodyLabel,0,0,1,1);

        Label yesLabel = new Label("Yes");
        gridPane.add(yesLabel,0,2,1,1);

        Label noLabel = new Label("No");
        gridPane.add(noLabel,2,2,1,1);

        yesLabel.setOnMouseClicked(value -> {

            questionStage.close();
            returnValue[0] = true;

        });

        noLabel.setOnMouseClicked(value -> {

            questionStage.close();
            returnValue[0] =false;

        });

        Scene scene2 = new Scene(gridPane, 240, 100);
        questionStage.setScene(scene2);
        questionStage.showAndWait();

        return returnValue[0];


    }


    private boolean checkIfWallCollision(int dx, int dy){
        return map.getPlayer().getCell().getNeighbor(dx,dy).getType() != CellType.WALL;
    }

    private void interactWithTheMap(int dx, int dy){
        Actor actorToInteractWith = map.getPlayer().getCell().getNeighbor(dx,dy).getActor();
        if(actorToInteractWith == null){
            map.getPlayer().move(dx, dy);
        }
        else{
            if(actorToInteractWith.getClass() == Key.class){
                boolean choice = false;
                choice = askQuestion("A mysterious key lies in this dark corner? What could it open ? Do you want to pick it up ?");
                if(choice){
                    map.getPlayer().getInventory().addToInventory(actorToInteractWith);
                    map.getPlayer().move(dx, dy);
                }
            }
            else if(actorToInteractWith.getClass() == Sword.class){
                boolean choice = false;
                choice = askQuestion("The legendary kit-cat-slayer sword has been found in this cursed place ! What luck ! Do you want to pick it up ?");
                if(choice){
                    map.getPlayer().getInventory().addToInventory(actorToInteractWith);
                    map.getPlayer().setDamage(map.getPlayer().getDamage() + 4);
                    map.getPlayer().move(dx, dy);
                }
            }
            else if (actorToInteractWith.getClass() == Potion.class) {
                boolean choice = false;
                choice = askQuestion("As you enter the village, you discover an Alchemist's shop. The vendor offers you a strength potion. Do you accept?");
                if (choice){
                    map.getPlayer().getInventory().addToInventory(actorToInteractWith);
                    map.getPlayer().setDamage(map.getPlayer().getDamage() + 10);
                    map.getPlayer().move(dx, dy);
                }
            }
            else if (actorToInteractWith.getClass() == Crown.class) {
                boolean choice = false;
                choice = askQuestion("You found the magic crown! Pick it up?");
                if (choice) {
                    map.getPlayer().getInventory().addToInventory(actorToInteractWith);
                    map.getPlayer().setDamage(map.getPlayer().getDamage() + 20);
                    map.getPlayer().move(dx, dy);
                }
            }
            else if(actorToInteractWith.getClass() == Door.class){
                boolean choice = false;
                boolean keyFound = false;


                for(Integer itemID:Inventory.inventory.keySet()){
                    if(itemID == 2){
                        keyFound = true;
                        break;
                    }
                }

                if(keyFound){
                    choice = askQuestion("The door seems to respond to the magic presence of the key you've found. Do you want to open the door ?");
                }
                else{
                    message("The massive door before you needs a key to be opened.");
                }

                if(choice){
                    message("The door before you crumbled into dust.");
                    actorToInteractWith.getCell().setActor(null);
                }
            } else {
                //JavaFX Logic to fight
                Player ourPlayer = map.getPlayer();
                ourPlayer.takeDamage(((Monster) actorToInteractWith).getDamage());
                ((Monster) actorToInteractWith).takeDamage(ourPlayer.getDamage());
            }

        }
    }


    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                if(checkIfWallCollision(0,-1))
                {
                    interactWithTheMap(0,-1);
                }
                refresh();
                break;
            case DOWN:
                if(checkIfWallCollision(0,1)) {
                    interactWithTheMap(0,1);
                }
                refresh();
                break;
            case LEFT:
                if(checkIfWallCollision(-1,0)) {
                    interactWithTheMap(-1,0);
                }
                refresh();
                break;
            case RIGHT:
                if(checkIfWallCollision(1,0)) {
                    interactWithTheMap(1,0);
                }
                refresh();
                break;
        }
    }

    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {

                Cell cell = map.getCell(x, y);

                if(cell.getActor() != null){
                    if(cell.getActor() instanceof Monster){
                        if(((Monster)cell.getActor()).getHealth() <= 0){
                            cell.setActor(null);
                        }
                    }
                    else if(cell.getActor() instanceof Player){
                        if(((Player)cell.getActor()).getHealth() <= 0){
                            cell.setActor(null);
                            message("Oh no! You died! ☹️ ");
                            System.exit(0);
                        }
                    }
                }

                if(cell.getActor() != null) {
                    if (cell.getActor().getClass() == Cat.class) {
                        System.out.println("Cell coordonate X: " + String.valueOf(cell.getX()) + "Cell coordonate Y: " + cell.getY());
                        if(Inventory.inventory.get(1) == null){
                            ((Cat)cell.getActor()).catMove(cell.getActor(),map);
                        }


                    }
                }
            }
        }

        if(currentLevel == 1 && levelOneDone){
            message("You have defeated the cat tyrant !");
            currentLevel++;
            loadLevel("/map2.txt");
        }

        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);

                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        healthLabel.setText("" + map.getPlayer().getHealth());
        damageLabel.setText("" + map.getPlayer().getDamage());
    }
}

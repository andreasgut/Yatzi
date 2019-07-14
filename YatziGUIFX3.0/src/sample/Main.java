package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main extends Application {
    Button startButton, neuWürfeln, anrechnen, fortunaMajor, highscore, highscore2, eintragen, highscoreBestätigen;
    TextField playerName1, playerName2, tVorname, tNachname;
    Scene scene1, highscoreScene, highscoreEnterScene, rangverkündigung;
    HBox hBoxName;
    HBox hBox1, hBox2, hBox3, hBox4;
    VBox vBox2, vBoxHighscore, vBoxHighscoreEnter;
    Label wurf, lPlayer1, lPlayer2, lAufforderung, lW1, lW1w, lW2, lW2w, lW3, lW3w, lW4, lW4w, lW5, lW5w, congrat, end,
    highscoreTitel, highscoreAsLabel, lVorname, lNachname, rangLabel;
    CheckBox cW1, cW2, cW3, cW4, cW5;
    BorderPane borderpane1;
    Player player1, player2, winner;
    Game game;
    ComboBox modus;
    ObservableList<Player> playerPunkte;
    TableView<Player> spielstand;
    TableView<Highscore> highscoreTableV;
    Insets inset10;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    ConnectionHighscore connectionHighscore;
    Stage sEintragen, highscoreStage, rang;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        // Datenbankverbindung
        connectionHighscore = new ConnectionHighscore();
        highscoreAsLabel = new Label(" ");
        if(connectionHighscore.isDatabaseConnected()){System.out.println("Datenbank verbunden");};






        //Startbildschirm Top
        lPlayer1 = new Label("Player 1: ");
        playerName1 = new TextField();
        playerName1.setMaxWidth(300);
        lPlayer2 = new Label("     Player 2: ");
        playerName2 = new TextField();
        playerName2.setMaxWidth(300);
        startButton = new Button("Start!");
        hBoxName = new HBox();
        hBoxName.getChildren().addAll(lPlayer1, playerName1, lPlayer2, playerName2, startButton);
        hBoxName.setSpacing(5);

        //Hauptbildschirm Top
        lAufforderung = new Label("Hier stehen die Infos");
        hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(lAufforderung);
        borderpane1 = new BorderPane();

        //Schlussbildschirm Top
        end = new Label("\n Das Spiel ist zu Ende.\n\n");
        hBox3 = new HBox();
        hBox3.setAlignment(Pos.CENTER);
        hBox3.getChildren().addAll(end);
        hBox3.setMinHeight(hBox1.getHeight());


        //Hauptbildschirm Bottom
        neuWürfeln = new Button("Würfeln"){};
        neuWürfeln.setDisable(true);
        anrechnen = new Button("Anrechnen");
        anrechnen.setDisable(true);
        highscore = new Button("Highscore");
        highscore.setDisable(false);
        anrechnen.setStyle("-fx-background-color: orange");
        fortunaMajor = new Button("Fortuna Major");
        fortunaMajor.setDisable(true);
        modus = new ComboBox();
        modus.getItems().addAll("1er", "2er", "3er", "4er", "5er","6er", "1 Paar", "2 Paar", "3 Gleiche",
                "4 Gleiche", "Kleine Strasse", "Grosse Strasse", "Full House", "Chance", "Yatzi");
        modus.getSelectionModel().selectFirst();
        modus.setDisable(true);
        wurf = new Label("   Wurf (zum neu Würfeln ankreuzen)");
        lW1 = new Label("Würfel: ");
        lW1w = new Label("-");
        lW1w.setMinWidth(30);
        lW2 = new Label("Würfel: ");
        lW2w = new Label("-");
        lW2w.setMinWidth(30);
        lW3 = new Label("Würfel: ");
        lW3w = new Label("-");
        lW3w.setMinWidth(30);
        lW4 = new Label("Würfel: ");
        lW4w = new Label("-");
        lW4w.setMinWidth(30);
        lW5 = new Label("Würfel: ");
        lW5w = new Label("-");
        lW5w.setMinWidth(30);

        hBox2 = new HBox();

        cW1 = new CheckBox();
        cW2 = new CheckBox();
        cW3 = new CheckBox();
        cW4 = new CheckBox();
        cW5 = new CheckBox();
        cW1.setDisable(true);
        cW2.setDisable(true);
        cW3.setDisable(true);
        cW4.setDisable(true);
        cW5.setDisable(true);

        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(fortunaMajor, wurf, cW1, lW1w, cW2, lW2w, cW3, lW3w, cW4, lW4w, cW5, lW5w, neuWürfeln, modus, anrechnen, highscore);
        hBox2.setSpacing(5);

        //Schlussbildschirm Bottom
        highscore2 = new Button("Highscore");
        eintragen = new Button("In Bestenliste eintragen");
        hBox4 = new HBox(10);
        hBox4.getChildren().addAll(eintragen, highscore2);
        hBox4.setAlignment(Pos.CENTER);




        //Hauptbildschirm Center

        //Spielstand

        TableColumn<Player, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(200);

        TableColumn<Player, String> einer = new TableColumn<>("1er");
        einer.setCellValueFactory(new PropertyValueFactory<>("einer"));
        einer.setMaxWidth(30);

        TableColumn<Player, String> zweier = new TableColumn<>("2er");
        zweier.setCellValueFactory(new PropertyValueFactory<>("zweier"));
        zweier.setMaxWidth(30);

        TableColumn<Player, String> dreier = new TableColumn<>("3er");
        dreier.setCellValueFactory(new PropertyValueFactory<>("dreier"));
        dreier.setMaxWidth(30);

        TableColumn<Player, String> vierer = new TableColumn<>("4er");
        vierer.setCellValueFactory(new PropertyValueFactory<>("vierer"));
        vierer.setMaxWidth(30);

        TableColumn<Player, String> fünfer = new TableColumn<>("5er");
        fünfer.setCellValueFactory(new PropertyValueFactory<>("fünfer"));
        fünfer.setMaxWidth(30);

        TableColumn<Player, String> sechser = new TableColumn<>("6er");
        sechser.setCellValueFactory(new PropertyValueFactory<>("sechser"));
        sechser.setMaxWidth(30);

        TableColumn<Player, String> bonus = new TableColumn<>("Bonus");
        bonus.setCellValueFactory(new PropertyValueFactory<>("bonus"));
        bonus.setMaxWidth(60);

        TableColumn<Player, String> einPaar = new TableColumn<>("1 Paar");
        einPaar.setCellValueFactory(new PropertyValueFactory<>("einPaar"));
        einPaar.setMaxWidth(60);

        TableColumn<Player, String> zweiPaar = new TableColumn<>("2 Paar");
        zweiPaar.setCellValueFactory(new PropertyValueFactory<>("zweiPaar"));
        zweiPaar.setMaxWidth(60);

        TableColumn<Player, String> dreiGleiche = new TableColumn<>("3 Gleiche");
        dreiGleiche.setCellValueFactory(new PropertyValueFactory<>("dreiGleiche"));
        dreiGleiche.setMaxWidth(80);

        TableColumn<Player, String> vierGleiche = new TableColumn<>("4 Gleiche");
        vierGleiche.setCellValueFactory(new PropertyValueFactory<>("vierGleiche"));
        vierGleiche.setMaxWidth(80);

        TableColumn<Player, String> kleineStrasse = new TableColumn<>("Kl. Strasse");
        kleineStrasse.setCellValueFactory(new PropertyValueFactory<>("kleineStrasse"));
        kleineStrasse.setMinWidth(100);

        TableColumn<Player, String> grosseStrasse = new TableColumn<>("Gr. Strasse");
        grosseStrasse.setCellValueFactory(new PropertyValueFactory<>("grosseStrasse"));
        grosseStrasse.setMinWidth(100);


        TableColumn<Player, String> fullHouse = new TableColumn<>("Full House");
        fullHouse.setCellValueFactory(new PropertyValueFactory<>("fullHouse"));
        fullHouse.setMinWidth(100);

        TableColumn<Player, String> chance = new TableColumn<>("Chance");
        chance.setCellValueFactory(new PropertyValueFactory<>("chance"));
        chance.setMaxWidth(60);

        TableColumn<Player, String> yatzi = new TableColumn<>("Yatzi");
        yatzi.setCellValueFactory(new PropertyValueFactory<>("yatzi"));
        yatzi.setMaxWidth(60);

        TableColumn<Player, String> total = new TableColumn<>("Total");
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        total.setMaxWidth(60);


        spielstand = new TableView<>();
        spielstand.getColumns().addAll(name, einer, zweier, dreier, vierer, fünfer, sechser, bonus,
                einPaar, zweiPaar, dreiGleiche, vierGleiche, kleineStrasse, grosseStrasse, fullHouse, chance,
                yatzi, total);


        vBox2 = new VBox();
        vBox2.getChildren().addAll(spielstand);

        //Highscore

        highscoreTitel = new Label("Das sind die besten bisher erzielten Resultate:");
        vBoxHighscore = new VBox();
        highscoreTableV = new TableView<>();

        TableColumn<Highscore, String> rang = new TableColumn<>("Rang");
        rang.setCellValueFactory(new PropertyValueFactory<>("rang"));
        TableColumn<Highscore, String> vorname = new TableColumn<>("Vorname");
        vorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        TableColumn<Highscore, String> nachname = new TableColumn<>("Nachname");
        nachname.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        TableColumn<Highscore, String> score = new TableColumn<>("Score");
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        TableColumn<Highscore, String> datum = new TableColumn<>("Datum");
        datum.setCellValueFactory(new PropertyValueFactory<>("datum"));



        highscoreTableV.getColumns().addAll(rang, vorname, nachname, score, datum);
        vBoxHighscore.getChildren().addAll(highscoreTitel, highscoreTableV);


        //HighscoreEnter

        lVorname = new Label("Vorname:");
        tVorname = new TextField();
        tVorname.setMaxWidth(300);
        lNachname = new Label("Nachname:");
        tNachname = new TextField();
        tNachname.setMaxWidth(300);
        highscoreBestätigen = new Button("Eintragen");

        vBoxHighscoreEnter = new VBox(10);
        vBoxHighscoreEnter.getChildren().addAll(lVorname, tVorname, lNachname, tNachname, highscoreBestätigen);







        //Startfenster, Spielfenster
        inset10 = new Insets(10, 10, 10, 10);
        borderpane1.setCenter(vBox2);
        borderpane1.setMargin(vBox2, inset10);
        borderpane1.setBottom(hBox2);
        borderpane1.setMargin(hBox2, inset10);
        borderpane1.setTop(hBoxName);
        borderpane1.setMargin(hBoxName, inset10);




        scene1 = new Scene(borderpane1, 1222, 500);
        scene1.getStylesheets().add("Edel.css");

        highscoreScene = new Scene(vBoxHighscore, 500, 322);
        highscoreScene.getStylesheets().add("Edel.css");

        highscoreEnterScene = new Scene(vBoxHighscoreEnter, 400, 200);
        highscoreEnterScene.getStylesheets().add("Edel.css");




        //Feldfunktionen
        startButton.setOnAction(event -> {
            player1 = new Player(playerName1.getText());
            player2 = new Player(playerName2.getText());
            game = new Game(player1, player2);
            borderpane1.setTop(hBox1);
            neuWürfeln.setDisable(false);
            cW1.setDisable(false);
            cW2.setDisable(false);
            cW3.setDisable(false);
            cW4.setDisable(false);
            cW5.setDisable(false);
            anrechnen.setDisable(false);
            modus.setDisable(false);
            fortunaMajor.setDisable(false);
            spielstand.setItems(getPlayerPunkte());
            spielstand.getSelectionModel().select(0);
            spielstand.getFocusModel().focus(0);
            spielstand.refresh();
            updateScreen();
        });

        fortunaMajor.setOnAction(event -> {
            cW1.setSelected(true);
            cW2.setSelected(true);
            cW3.setSelected(true);
            cW4.setSelected(true);
            cW5.setSelected(true);
        });

        modus.setOnAction(event -> {
            anrechnen.setDisable(false);
        });

        anrechnen.setOnAction(event -> {

            if(modus.getValue().toString().equals("1er")) {game.einer();}
            if(modus.getValue().toString().equals("2er")) {game.zweier();}
            if(modus.getValue().toString().equals("3er")) {game.dreier();}
            if(modus.getValue().toString().equals("4er")) {game.vierer();}
            if(modus.getValue().toString().equals("5er")) {game.fünfer();}
            if(modus.getValue().toString().equals("6er")) {game.sechser();}
            if(modus.getValue().toString().equals("1 Paar")) {game.einPaar();}
            if(modus.getValue().toString().equals("2 Paar")) {game.zweiPaare();}
            if(modus.getValue().toString().equals("3 Gleiche")) {game.dreiGleiche();}
            if(modus.getValue().toString().equals("4 Gleiche")) {game.vierGleiche();}
            if(modus.getValue().toString().equals("Kl. Strasse")) {game.kleineStrasse();}
            if(modus.getValue().toString().equals("Gr. Strasse")) {game.grosseStrasse();}
            if(modus.getValue().toString().equals("Full House")) {game.fullHouse();}
            if(modus.getValue().toString().equals("Chance")) {game.chance();}
            if(modus.getValue().toString().equals("Yatzi")) {game.yatzy();}

            player1.totalBerechnen();
            player2.totalBerechnen();
            player1.bonusBerechnen();
            player2.bonusBerechnen();
            spielstand.requestFocus();
            spielstand.getSelectionModel().select((game.getRundeNummer())%2);
            spielstand.getFocusModel().focus((game.getRundeNummer())%2);
            spielstand.refresh();


            if (game.getRundeNummer()<30){

                game.play();
                updateModusComboBox();
                updateScreen();
                neuWürfeln.setDisable(false);
                cW1.setSelected(false);
                cW2.setSelected(false);
                cW3.setSelected(false);
                cW4.setSelected(false);
                cW5.setSelected(false);}


            else{getWinner();}
        });

        highscore.setOnAction(event -> {

            highscoreTableV.setItems(connectionHighscore.getHighscore());
            highscoreStage = new Stage();
            highscoreStage.setScene(highscoreScene);
            highscoreStage.show();

        });

        highscore2.setOnAction(event -> {

            highscoreTableV.setItems(connectionHighscore.getHighscore());
            highscoreStage = new Stage();
            highscoreStage.setScene(highscoreScene);
            highscoreStage.show();

        });

        neuWürfeln.setOnAction(event -> {
            switch (game.getWurfNummer()){

                case 1: game.increaseWurfNummer();
                    if(cW1.isSelected()) {game.setW1(true);} else {game.setW1(false);}
                    if(cW2.isSelected()) {game.setW2(true);} else {game.setW2(false);}
                    if(cW3.isSelected()) {game.setW3(true);} else {game.setW3(false);}
                    if(cW4.isSelected()) {game.setW4(true);} else {game.setW4(false);}
                    if(cW5.isSelected()) {game.setW5(true);} else {game.setW5(false);}
                    game.roll2();
                    game.sendInfo();
                    updateScreen();
                    break;



                case 2: game.increaseWurfNummer();
                    if(cW1.isSelected()) {game.setW1(true);} else {game.setW1(false);}
                    if(cW2.isSelected()) {game.setW2(true);} else {game.setW2(false);}
                    if(cW3.isSelected()) {game.setW3(true);} else {game.setW3(false);}
                    if(cW4.isSelected()) {game.setW4(true);} else {game.setW4(false);}
                    if(cW5.isSelected()) {game.setW5(true);} else {game.setW5(false);}
                    game.roll3();
                    game.sendInfo();
                    neuWürfeln.setDisable(true);
                    updateScreen();
                    break;

            }

        });

        eintragen.setOnAction(event -> {
            sEintragen = new Stage();
            sEintragen.setScene(highscoreEnterScene);
            sEintragen.show();
        });

        highscoreBestätigen.setOnAction(event -> {
            //rang = new Stage();

            connectionHighscore.enter(tVorname.getText(), tNachname.getText(), winner.getTotal());
            sEintragen.close();


        });

        primaryStage.setTitle("Yatzi – Das Spiel für harte Kerle und Kerlinnen");
        primaryStage.setScene(scene1);
        primaryStage.show();



    }




    private void getWinner() {
        if (player1.getTotal() > player2.getTotal()) {winner = player1;}
        if (player2.getTotal() > player1.getTotal()) {winner = player2;}
        if (player1.getTotal() == player2.getTotal()) {winner = new Player("Niemand");}

        congrat = new Label(winner.getName() + " hat das Spiel mit " + winner.getTotal() + " Punkten gewonnen!");
        vBox2.getChildren().add(congrat);
        borderpane1.setTop(hBox3);
        borderpane1.setBottom(hBox4);
        borderpane1.setMargin(hBox4, inset10);

    }

    public ObservableList<Player> getPlayerPunkte(){
        playerPunkte = FXCollections.observableArrayList();
        playerPunkte.addAll(player1, player2);
        return playerPunkte;
    }

    public void updateScreen(){

        int[] dieTable;

        dieTable = game.getDieTable();
        lAufforderung.setText(game.sendInfo());
        lW1w.setText(Integer.toString(dieTable[0]) + "    ");
        lW2w.setText(Integer.toString(dieTable[1]) + "    ");
        lW3w.setText(Integer.toString(dieTable[2]) + "    ");
        lW4w.setText(Integer.toString(dieTable[3]) + "    ");
        lW5w.setText(Integer.toString(dieTable[4]) + "    ");


    }

    public void updateModusComboBox(){

        modus.getItems().clear();
        if (!game.getCurrentPlayer().isEinerC()) {modus.getItems().add("1er");}
        if (!game.getCurrentPlayer().isZweierC()) {modus.getItems().add("2er");}
        if (!game.getCurrentPlayer().isDreierC()) {modus.getItems().add("3er");}
        if (!game.getCurrentPlayer().isViererC()) {modus.getItems().add("4er");}
        if (!game.getCurrentPlayer().isFünferC()) {modus.getItems().add("5er");}
        if (!game.getCurrentPlayer().isSechserC()) {modus.getItems().add("6er");}

        if (!game.getCurrentPlayer().isEinPaarC()) {modus.getItems().add("1 Paar");}
        if (!game.getCurrentPlayer().isZweiPaarC()) {modus.getItems().add("2 Paar");}
        if (!game.getCurrentPlayer().isDreiGleicheC()) {modus.getItems().add("3 Gleiche");}
        if (!game.getCurrentPlayer().isVierGleicheC()) {modus.getItems().add("4 Gleiche");}
        if (!game.getCurrentPlayer().isKleineStrasseC()) {modus.getItems().add("Kl. Strasse");}
        if (!game.getCurrentPlayer().isGrosseStrasseC()) {modus.getItems().add("Gr. Strasse");}
        if (!game.getCurrentPlayer().isFullHouseC()) {modus.getItems().add("Full House");}
        if (!game.getCurrentPlayer().isChanceC()) {modus.getItems().add("Chance");}
        if (!game.getCurrentPlayer().isYatziC()) {modus.getItems().add("Yatzi");}
    }



    public static void main(String[] args) {
        launch(args);
    }


}


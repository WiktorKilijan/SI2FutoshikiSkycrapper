import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader {

    public Loader(){

    }

    public FGame readFuto(String fileName){
        String fullPath = "data/"+fileName;
        File file = new File(fullPath);
        FGame game = new FGame();
        try(Scanner scanner  = new Scanner(file)){
            int dim = scanner.nextInt();
            game.setSize(dim);
            String currLine;
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            String [] splited;
            int val;
            for (int i = 0; i<dim; i++){
                currLine = scanner.nextLine();
                splited = currLine.split(";");
                for (int j = 0; j<dim; j++){
                    val = Integer.parseInt(splited[j]);
                    game.setValue(val, i, j);
                }
            }
            System.out.println(scanner.nextLine());


        //TODO: wczytywanie ograniczen

            ArrayList<String> constraints = new ArrayList<>();
            while(scanner.hasNext()){
                currLine = scanner.nextLine();
                constraints.add(currLine);
            }
            game.addConstraints(constraints);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return game;
    }


}

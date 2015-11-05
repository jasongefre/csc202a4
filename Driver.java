package assignment4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;

/**
 * Created by JMG on 11/3/2015.
 */
public class Driver extends Application {
    static BST list = new BST();
    static Stage window;
    static Gui gui = new Gui();
    static Scene base;
    static String selected;

    public static void main(String[] args) {
        newFoodItemFromTxt();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setTitle("assignment 2");
        base = gui.setBase();
        window.setScene(base);
        window.show();
    }

    public static void newFoodItemFromTxt()
    {
        String[] line;
        String l;
        String filepath = "C:/_Java/";
        String filename = "importTXT.txt";
        String file = filepath + filename;

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            while((l=input.readLine())!=null)
            {
                line = l.split(",");
                list.add(new Food(line[0],line[1],line[2],line[3],line[4],line[5]));

            }
        } catch(FileNotFoundException e){
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO error.");
            e.printStackTrace();
        }
    }

    public static void newFoodItemFromExcel()
    {
        String filepath = "C:/_Java/";
        String filename = "importXLS.XLS";
        String file = filepath + filename;
        String line[] = new String[7];
        try {
            HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(file)));
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;
            int cols = 0;
            int tmp = 0;
            int rows;
            rows = sheet.getPhysicalNumberOfRows();

            for(int i = 0; i < 10 || i < rows; i++)
            {
                row = sheet.getRow(i);
                if(row != null)
                {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if(tmp > cols) cols = tmp;
                }
            }

            for(int r = 0; r < rows; r++)
            {
                row = sheet.getRow(r);
                if(row != null)
                {
                    for(int c = 0; c < 7; c++)
                    {
                        cell = row.getCell(c);
                        if(cell != null)
                        {
                            line[c]=cell.toString();
                        }
                        else
                        {
                            line[c] = "";
                        }
                    }
                    list.add(new Food(line[0],line[1], line[2], line[3], line[4], line[5]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO error.");
            e.printStackTrace();
        }
    }
}

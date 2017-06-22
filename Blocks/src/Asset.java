
import java.nio.file.Paths;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MyPC
 */
public class Asset {
    public static String path_asset = Paths.get("").toAbsolutePath().toString() + "/src/" + "Asset/";

    // directory
    public static String path_nulllBlock = path_asset + "blankBlock2.png";
    public static MyImage nullBlock = new MyImage(path_nulllBlock);
    
    public static String path_grassBlock = path_asset + "grassBlock1.png";
    public static MyImage grassBlock = new MyImage(path_grassBlock);

     
 
}

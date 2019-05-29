package back.valadzko.kseniya.utills;

import com.thoughtworks.xstream.XStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

public class XMLHelper {
    private static final String PATH = "D:/Университет/4 семестр/Hotel/src/back/valadzko/kseniya/resources/";
    private static final Logger LOGGER = LogManager.getLogger(XMLHelper.class.getName());

    public static void writeToXML(List<?> objects, String filename) {
        try (FileOutputStream fileOS = new FileOutputStream(PATH + filename,false)) {
            XStream xs = new XStream();
            xs.toXML(objects, fileOS);
            LOGGER.info("Write to file!");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static List<?> readFromXML(String filename) {
        try (FileInputStream fileIS = new FileInputStream(PATH + filename)) {
            XStream xs = new XStream();
            LOGGER.info("Read from file!");
            return (List<?>)  xs.fromXML(fileIS);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}

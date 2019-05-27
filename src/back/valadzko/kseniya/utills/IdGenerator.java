package back.valadzko.kseniya.utills;

import java.util.Random;

public class IdGenerator {
    public static int generateId(){
        return new Random().nextInt(1000)+1;
    }
}

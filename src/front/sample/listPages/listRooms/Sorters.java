package front.sample.listPages.listRooms;

public enum Sorters {
    PRICE,
    NUMBEROFSTARS,
    CAPACITY;

    @Override
    public String toString() {
        switch (this){
            case PRICE:
                return "цене";
            case NUMBEROFSTARS:
                return "количеству звезд";
            case CAPACITY:
                return "вместимости";
        }
        return "-1";
    }
}

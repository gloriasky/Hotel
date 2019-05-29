package front.sample.listPages.listServices;

public enum ServiceSorters {
    ALPHABETH,
    PRICE;


    @Override
    public String toString() {
        switch (this){
            case PRICE:
                return "цене";
            case ALPHABETH:
                return "алфавиту";
        }
        return "-1";
    }
}

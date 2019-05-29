package back.valadzko.kseniya.interfaces.model;

public enum Status {
    FREE(0),
    REPAIRING(1),
    BUSY(2);

    Status(int i) {
        getStatus(i);
    }

    Status getStatus(int i) {
        switch (i) {
            case 0:
                return FREE;
            case 1:
                return REPAIRING;
            case 2:
                return BUSY;
            default:
                return FREE;
        }
    }

    @Override
    public String toString() {
        switch (this){
            case FREE:
                return "Свободна";
            case BUSY:
                return "Занята";
            case REPAIRING:
                return "Находится на обслуживании";
        }
        return "-1";
    }
}


package lesson10.abstractExample;

public class MySQLProvider extends DbProvider {

    public MySQLProvider(String dbHost) {
        super(dbHost);
    }

    @Override
    void connectToDb() {

    }

    @Override
    void disconnectFromDb() {

    }

    @Override
    void printDbHost() {
        super.printDbHost();
    }
}

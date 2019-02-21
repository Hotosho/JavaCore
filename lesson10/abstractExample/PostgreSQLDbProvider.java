package lesson10.abstractExample;

public class PostgreSQLDbProvider extends DbProvider {

    public PostgreSQLDbProvider(String dbHost) {
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

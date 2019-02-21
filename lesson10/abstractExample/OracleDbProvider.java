package lesson10.abstractExample;

public class OracleDbProvider extends DbProvider {

    public OracleDbProvider(String dbHost) {
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

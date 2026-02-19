package src.design13_DataBase_Connection_Pool;

import java.sql.Connection;

/**
 * Class to maintain a single connection
 */
public class PooledConnection {
    private final Connection connection;
    private boolean inUse;

    public PooledConnection(Connection c) {
         this.connection =c;
         inUse=false;
    }

    public synchronized Connection getConnection(){
        inUse=true;
        return this.connection;
    }

    public synchronized void release(){
        inUse=false;
    }

    public synchronized boolean isInUse(){
        return inUse;
    }
}

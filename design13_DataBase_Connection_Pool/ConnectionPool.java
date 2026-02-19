package src.design13_DataBase_Connection_Pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionPool {

    private static ConnectionPool instance;

    private final Queue<PooledConnection> availableConnections;
    private final Set<PooledConnection> usedConnections;
    private static int maxPoolSize=100;// No dynamic
    private static int minPoolSize=10;// No dynamic

    //ObjectPool borrow
    public Connection borrowConnection() {

        if(usedConnections.size()==maxPoolSize){
            System.out.println(" Max connections reached .. delete some to access some ");
            return null;
        }

        PooledConnection pc=null;
        if(availableConnections==null||availableConnections.size()==0){

            try {
                // Create new connection
                pc= new PooledConnection(ConnectionFactory.createConnection());
                usedConnections.add(pc);
                return pc.getConnection();
            }
            catch (Exception e){
                System.out.println(" Not able to create a connection ");
            }
            finally {
                System.out.println(" Returning null ");
                return null;
            }
        }
        else{
           pc=availableConnections.poll();
           usedConnections.add(pc);
           return pc.getConnection();
        }

    }


    //ObjectPool Release
    public void returnConnection(Connection c){
        for(PooledConnection pc : usedConnections){
            if(pc.getConnection().equals(c)){
                pc.release();
                usedConnections.remove(pc);
                availableConnections.add(pc);
                System.out.println(" Connection released .... ");
                break;
            }
        }
        System.out.println("Connection not in the pool....");
    }


    //Singleton private constructor
    private ConnectionPool( int maxPoolSize) {
        this.availableConnections = new ConcurrentLinkedQueue<>();
        this.usedConnections = Collections.newSetFromMap(new ConcurrentHashMap<>());
        this.maxPoolSize = maxPoolSize;
        createObjectPool();
    }

    //ObjectPool create some objects
    private void createObjectPool() {
        try {
            for (int i = 0; i < minPoolSize; i++) {
                availableConnections.add(new PooledConnection(ConnectionFactory.createConnection()));
            }
        }
        catch (SQLException s){
            System.out.println(" Error on creating object pool .... "+s);
        }
    }

    // SingleTon GetInstance
    public static ConnectionPool getInstance(int max){
        if(instance!=null){
            System.out.println(" Already created pool "+maxPoolSize);
            return instance;
        }
        else{
            synchronized(ConnectionPool.class){
                if(instance==null){
                    instance=new ConnectionPool(max);
                }
            }
        }
        return instance;
    }

}

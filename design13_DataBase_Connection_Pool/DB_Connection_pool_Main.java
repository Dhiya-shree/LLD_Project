package src.design13_DataBase_Connection_Pool;

public class DB_Connection_pool_Main {
    public static void main(String[] args) {

        //ConcurrentLinkedHashMap
        //ConcurrentLinkedList
        ConnectionPool c=ConnectionPool.getInstance(100);
        for(int i=0;i<15;i++){
            c.borrowConnection();
        }

    }
}

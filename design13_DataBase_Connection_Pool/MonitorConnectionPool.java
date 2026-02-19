package src.design13_DataBase_Connection_Pool;

public class MonitorConnectionPool {
    /**

     1) Remove old dynamically
       for all timeStamp
       if any connection is not at all used
          remove it

     2) If available connections are less than x
         Do process 1 ...
         if issue still continues then,
         add more available connections

     3) Create LRU in connection Pool
         Remove least recently used in batch from monitor class

    */


}

package demo.HBase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;

public class DemoHBase {

    public static void main(String args[]) throws Exception {
        testCreateTable();
    }


    public static void testCreateTable() throws Exception{
        //??ZK
        Configuration conf = new Configuration();
        conf.set("hbase.zookeeper.quorum", "192.168.1.85");

        //??Hbase?admin
        HBaseAdmin admin = new HBaseAdmin(conf);
        //create 'Employee','info','grade'

        //????
        HTableDescriptor td = new HTableDescriptor(TableName.valueOf("Employee"));

        //????
        HColumnDescriptor cd1 = new HColumnDescriptor("info");
        HColumnDescriptor cd2 = new HColumnDescriptor("income");

        //??????
        td.addFamily(cd1);
        td.addFamily(cd2);

        //???
        admin.createTable(td);

        //????
        admin.close();
    }

    public static void testPut() throws Exception{
        //??ZK
        Configuration conf = new Configuration();
        conf.set("hbase.zookeeper.quorum", "192.168.1.85");

        //??????
        HTable table = new HTable(conf, "Employee");

        //????Put
        Put put = new Put("emp001".getBytes());
        //???????
        //family: ????
        //qualifier: ???
        //value: ?
        put.add("info".getBytes(), "ename".getBytes(), "Tom".getBytes());

        //????
        table.put(put);


        table.close();
    }

    public static void testGet(){
        //??ZK
        Configuration conf = new Configuration();
        conf.set("hbase.zookeeper.quorum", "192.168.1.85");

        //??

    }
}






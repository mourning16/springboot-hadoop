package cn.com.soft.hadoopdb.hbase;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

public class HbaseDao {

	
	@Test
	public void insertTest() throws Exception{
		
		Configuration conf =  HBaseConfiguration.create();
		//如下需要替换
		conf.set("hbase.zookeeper.quorum", "ZK集群地址");
		
		HTable nvshen = new HTable(conf, "nvshen");
		
		Put name = new Put(Bytes.toBytes("rk0001"));
		name.add(Bytes.toBytes("base_info"), Bytes.toBytes("name"), Bytes.toBytes("angelababy"));
		
		Put age = new Put(Bytes.toBytes("rk0001"));
		age.add(Bytes.toBytes("base_info"), Bytes.toBytes("age"), Bytes.toBytes(18));
		
		ArrayList<Put> puts = new ArrayList<>();
		puts.add(name);
		puts.add(age);
		
		nvshen.put(puts);
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		Configuration conf =  HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "weekend05:2181,weekend06:2181,weekend07:2181");
		
		HBaseAdmin admin = new HBaseAdmin(conf);
		
		TableName name = TableName.valueOf("nvshen");
		
		
		HTableDescriptor desc = new HTableDescriptor(name);
		
		
		HColumnDescriptor base_info = new HColumnDescriptor("base_info");
		HColumnDescriptor extra_info = new HColumnDescriptor("extra_info");
		base_info.setMaxVersions(5);
		
		desc.addFamily(base_info);
		desc.addFamily(extra_info);
		
		admin.createTable(desc);
		
		
	}
	
	
	
}

package com.atguigu.mapreduce.findcommonfriends.solution00.onemapreduce;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class OneShareFriendsMapper extends Mapper<LongWritable, Text, Text, Text>{

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
	    throws IOException, InterruptedException {

	// 1 获取一行 A:B,C,D,F,E,O
	String line = value.toString();

	// 2 切割
	String[] fields = line.split(":");

	// 3 获取person和好友
	String person = fields[0];
	String[] friends = fields[1].split(",");

	// 4写出去
	for(String friend: friends){

	    // 输出 <好友，人>
	    context.write(new Text(friend), new Text(person));
	}
    }
}
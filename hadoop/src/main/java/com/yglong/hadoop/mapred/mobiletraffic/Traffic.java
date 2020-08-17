package com.yglong.hadoop.mapred.mobiletraffic;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Traffic implements Writable  {
    private long up;  // 上行流量
    private long down; // 下行流量
    private long sum;  // 上下行总流量

    public Traffic() {}

    public Traffic(long up, long down) {
        this.up = up;
        this.down = down;
        this.sum = up + down;
    }

    public long getUp() {
        return up;
    }

    public void setUp(long up) {
        this.up = up;
    }

    public long getDown() {
        return down;
    }

    public void setDown(long down) {
        this.down = down;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(up);
        out.writeLong(down);
        out.writeLong(sum);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        up = in.readLong();
        down = in.readLong();
        sum = in.readLong();
    }

    @Override
    public String toString() {
        return up + "\t" + down + "\t" + sum;
    }
}

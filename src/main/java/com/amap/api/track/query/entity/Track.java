package com.amap.api.track.query.entity;

import com.amap.api.col.stln3.qd;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class Track {
    private int a;
    private long b;
    private double c;
    private long d;
    private ArrayList<Point> e;

    public static Track createTrack(String str) {
        qd a2 = new qd().a(str);
        return new Track(a2.h("counts"), a2.d("trid"), a2.e("distance"), a2.d("time"), Point.createLocs(a2.g("points")));
    }

    public static List<Track> createTracks(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Track createTrack = createTrack(jSONArray.getString(i));
                if (createTrack != null) {
                    arrayList.add(createTrack);
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            return new ArrayList();
        }
    }

    public Track(int i, long j, double d2, long j2, ArrayList<Point> arrayList) {
        this.a = i;
        this.b = j;
        this.c = d2;
        this.d = j2;
        this.e = arrayList;
    }

    public long getTrid() {
        return this.b;
    }

    public int getCount() {
        return this.a;
    }

    public double getDistance() {
        return this.c;
    }

    public long getTime() {
        return this.d;
    }

    public ArrayList<Point> getPoints() {
        return this.e;
    }
}

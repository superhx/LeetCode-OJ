import java.util.HashMap;
import java.util.Map;

class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points.length <= 1)
            return points.length;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int max = 0, inerMax = 0, sameNum = 0, verticalNum = 0;
        double slope;
        int slopeValue;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            verticalNum = 1;
            inerMax = sameNum = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y != points[j].y)
                    verticalNum++;
                else if (points[i].x == points[j].x && points[i].y == points[j].y)
                    sameNum++;
                else {
                    slope = (points[j].y - points[i].y * 1.0) / (points[j].x - points[i].x);
                    if (slope == 0)
                        slope = 0;
                    if (map.containsKey(slope)) {
                        slopeValue = map.get(slope);
                        map.put(slope, ++slopeValue);
                    } else {
                        slopeValue = 2;
                        map.put(slope, slopeValue);
                    }
                    inerMax = Math.max(inerMax, slopeValue);
                }
            }
            max = Math.max(max, Math.max(verticalNum, inerMax) + sameNum);
        }
        return max;
    }
}

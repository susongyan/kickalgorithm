/**
 * Tn = O(n^2)
 * Sn = O(n)
 */
class Solution{
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for(int i = 0; i < points.length; i++){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j = 0; j < points.length; j++){
                if(i==j){
                    continue;
                }

                // 两点之间的距离， 如果开根号就会存在浮点数 可能导致不准确
                int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                        +  (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]) ;

                if(!map.containsKey(distance)){
                    map.put(distance,1);
                }else{
                    map.put(distance,map.get(distance) + 1);
                }
            }
            Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer,Integer> entry = iterator.next();
                result += entry.getValue() * (entry.getValue()-1);
            }
        }
        return result;
    }
}
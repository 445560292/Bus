package com.utils
/**
 * Created by Administrator on 2016/4/6 0006.
 */
class Subway {
    private List<Station> outList = new ArrayList<Station>();//记录已经分析过的站点
    public List<String> targets = new ArrayList<String>();
    //计算从s1站到s2站的最短经过路径
    public Set<Station> calculate(Station s1, Station s2, boolean lessTime){
        if(outList.size() == DataBuilder.totalStaion){
            System.out.println("找到目标站点："+s2.getName()+"，共经过"+(s1.getAllPassedStations(s2).size()-1)+"站");
            for(Station station : s1.getAllPassedStations(s2)){
                System.out.print(station.getName()+"->");
                targets.add(station.name)
            }
            return s1.getAllPassedStations(s2) ;
        }
        if(!outList.contains(s1)){
            outList.add(s1);
        }
        //如果起点站的OrderSetMap为空，则第一次用起点站的前后站点初始化之
        if(s1.getOrderSetMap().isEmpty()){
            List<Station> Linkedstations = getAllLinkedStations(s1);
            for(Station s : Linkedstations){
                s1.getAllPassedStations(s).add(s);
            }
        }
        Station parent = getShortestPath(s1, lessTime);//获取距离起点站s1最近的一个站（有多个的话，随意取一个）
        if(parent == s2){
            System.out.println("找到目标站点："+s2+"，共经过"+(s1.getAllPassedStations(s2).size()-1)+"站");
            for(Station station : s1.getAllPassedStations(s2)){
                System.out.print(station.getName()+"->");
                targets.add(station.getName())
            }
            return s1.getAllPassedStations(s2);
        }
        for(Station child : getAllLinkedStations(parent)){
            if(outList.contains(child)){
                continue;
            }
            int shortestPath = (s1.getAllPassedStations(parent).size()-1) + 1;//前面这个1表示计算路径需要去除自身站点，后面这个1表示增加了1站距离
            if(s1.getAllPassedStations(child).contains(child)){
                //如果s1已经计算过到此child的经过距离，那么比较出最小的距离
                if((s1.getAllPassedStations(child).size()-1) > shortestPath){
                    //重置S1到周围各站的最小路径
                    s1.getAllPassedStations(child).clear();
                    s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
                    s1.getAllPassedStations(child).add(child);
                }
            } else {
                //如果s1还没有计算过到此child的经过距离
                s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
                s1.getAllPassedStations(child).add(child);
            }
        }
        outList.add(parent);
        calculate(s1,s2, lessTime);//重复计算，往外面站点扩展
    }

    //取参数station到各个站的最短距离，相隔1站，距离为1，依次类推
    private Station getShortestPath(Station station, boolean lessTime){
        int minPatn = Integer.MAX_VALUE;
        Station rets = null;
        for(Station s :station.getOrderSetMap().keySet()){
            if(outList.contains(s)){
                continue;
            }
            LinkedHashSet<Station> set  = station.getAllPassedStations(s);//参数station到s所经过的所有站点的集合
            int size = 0;
            if(lessTime){
                set.each {
                    sta->
                        size += sta.size
                }
            }else {
                size = set.size();
            }

            if(size < minPatn){
                minPatn = size;
                rets = s;
            }
        }
        return rets;
    }

    //获取参数station直接相连的所有站，包括交叉线上面的站
    public List<Station> getAllLinkedStations(Station station){
        List<Station> linkedStaions = new ArrayList<Station>();
        for(List<Station> line : DataBuilder.lineSet){
            if(line.contains(station)){//如果某一条线包含了此站，注意由于重写了hashcode方法，只有name相同，即认为是同一个对象
                Station s = line.get(line.indexOf(station));
                if(s.prev != null){
                    linkedStaions.add(s.prev);
                }
                if(s.next != null){
                    linkedStaions.add(s.next);
                }
            }
        }
        return linkedStaions;
    }

    /**
     * desc: How to use the method
     * author chaisson
     * since 2015-5-31
     * version 1.0
     */
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        Subway sw = new Subway();
        sw.calculate(new Station("化肥厂"), new Station("新风桥停车场"), true);
        long t2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("耗时："+(t2-t1)+"ms");
    }
}

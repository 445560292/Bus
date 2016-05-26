package com.utils
/**
 * Created by Administrator on 2016/4/6 0006.
 */

class Station {
    private String name; //地铁站名称，假设具备唯一性

    private String line;

    public Station prev; //本站在lineNo线上面的前一个站

    public Station next; //本站在lineNo线上面的后一个站

    public int size = 0;

    public String strlons;

    public String strlats;

    //本站到某一个目标站(key)所经过的所有站集合(value)，保持前后顺序
    private Map<Station,LinkedHashSet<Station>> orderSetMap = new HashMap<Station,LinkedHashSet<Station>>();

    public ArrayList<Station> relationNodes = new ArrayList<Station>();

    public Station(String name, String line, int size){
        this.name = name;
        this.line = line;
        this.size = size;
    }
    public Station(String name, String line){
        this.name = name;
        this.line = line;
    }

    public Station(String name){
        this.name = name;
    }

    public String getLine(){
        return line;
    }

    public String setLine(String line){
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedHashSet<Station> getAllPassedStations(Station station) {
        if(orderSetMap.get(station) == null){
            LinkedHashSet<Station> set = new LinkedHashSet<Station>();
            set.add(this);
            orderSetMap.put(station, set);
        }
        return orderSetMap.get(station);
    }

    public Map<Station, LinkedHashSet<Station>> getOrderSetMap() {
        return orderSetMap;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.is(obj)){
            return true;
        } else if(obj instanceof Station){
            Station s = (Station) obj;
            if(s.getName() == this.getName()){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    public List<Station> getRelationNodes() {
        return relationNodes;
    }

    public void setRelationNodes(List<Station> relationNodes) {
        this.relationNodes = relationNodes;
    }
}

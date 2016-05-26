/**
 * Created by Administrator on 2016/4/6 0006.
 */
package com.utils

class DataBuilder {
    public static List<Station> line1 = new ArrayList<Station>();//1
    public static List<Station> line2 = new ArrayList<Station>();//10
    public static List<Station> line3 = new ArrayList<Station>();//3
    public static List<Station> line5d = new ArrayList<Station>();//5d
    public static List<Station> line5x = new ArrayList<Station>();//10
    public static List<Station> line6 = new ArrayList<Station>();//10
    public static List<Station> line8 = new ArrayList<Station>();//10
    public static List<Station> line9 = new ArrayList<Station>();//9x
    public static List<Station> line10 = new ArrayList<Station>();//10x
    public static List<Station> line11d = new ArrayList<Station>();//11d
    public static List<Station> line11x = new ArrayList<Station>();//11x
    public static List<Station> line12 = new ArrayList<Station>();//10
    public static List<Station> line13 = new ArrayList<Station>();//10
    public static List<Station> line15 = new ArrayList<Station>();//10
    public static List<Station> line18 = new ArrayList<Station>();//18
    public static List<Station> line19= new ArrayList<Station>();//10
    public static List<Station> line20 = new ArrayList<Station>();//20
    public static List<Station> line21 = new ArrayList<Station>();//210
    public static List<Station> line32= new ArrayList<Station>();//10
    public static List<Station> line33 = new ArrayList<Station>();//20
    public static List<Station> line35 = new ArrayList<Station>();//210
    public static List<Station> line201 = new ArrayList<Station>();//210
    public static List<Station> line202= new ArrayList<Station>();//10
    public static List<Station> line203 = new ArrayList<Station>();//20
    public static List<Station> line205 = new ArrayList<Station>();//210
    public static List<Station> line206 = new ArrayList<Station>();//210
    public static List<Station> line207= new ArrayList<Station>();//10
    public static List<Station> line208 = new ArrayList<Station>();//20
    public static List<Station> line209 = new ArrayList<Station>();//210
    public static List<Station> line210 = new ArrayList<Station>();//210
    public static List<Station> line211= new ArrayList<Station>();//10
    public static List<Station> line212 = new ArrayList<Station>();//20
    public static List<Station> line213 = new ArrayList<Station>();//20
    public static List<Station> line215 = new ArrayList<Station>();//210
    public static List<Station> line216 = new ArrayList<Station>();//210
    public static List<Station> line217= new ArrayList<Station>();//10
    public static List<Station> line218 = new ArrayList<Station>();//20
    public static List<Station> line219 = new ArrayList<Station>();//210
    public static List<Station> line220 = new ArrayList<Station>();//210
    public static List<Station> line221= new ArrayList<Station>();//10
    public static List<Station> line222 = new ArrayList<Station>();//20
    public static List<Station> line223 = new ArrayList<Station>();//20
    public static List<Station> line225 = new ArrayList<Station>();//210
    public static List<Station> line226 = new ArrayList<Station>();//210
    public static List<Station> line227= new ArrayList<Station>();//10
    public static List<Station> line228 = new ArrayList<Station>();//20
    public static List<Station> line229 = new ArrayList<Station>();//210
    public static List<Station> line233= new ArrayList<Station>();//10
    public static List<Station> line301 = new ArrayList<Station>();//210
    public static List<Station> line302= new ArrayList<Station>();//10
    public static List<Station> line303 = new ArrayList<Station>();//20
    public static List<Station> line305 = new ArrayList<Station>();//210
    public static List<Station> line306 = new ArrayList<Station>();//210
    public static List<Station> line311 = new ArrayList<Station>();//210
    public static List<Station> line312= new ArrayList<Station>();//10
    public static List<Station> line313 = new ArrayList<Station>();//20
    public static List<Station> line315 = new ArrayList<Station>();//210
    public static List<Station> line316 = new ArrayList<Station>();//210
    public static List<Station> line321 = new ArrayList<Station>();//210
    public static List<Station> line322= new ArrayList<Station>();//10
    public static List<Station> line323 = new ArrayList<Station>();//20
    public static List<Station> line325 = new ArrayList<Station>();//210
    public static List<Station> line326 = new ArrayList<Station>();//210
    public static List<Station> line339 = new ArrayList<Station>();//210
    public static List<Station> line334 = new ArrayList<Station>();//210


    public static Set<List<Station>> lineSet = new HashSet<List<Station>>();//所有线集合
    public static int totalStaion = 0;//总的站点数量
    static {
        def strlons1 = "120.589709|120.597167|120.600973|120.600139|120.599565|120.598102|120.593209|120.586244|120.583821|120.583538|120.582982|120.579809|120.577844|120.575566|120.571004|120.570263|120.572851|120.572389|120.568493|120.560809|120.558278|120.553596|120.547304|120.545266|120.542021|120.542426|120.541098|120.543253|120.545853|120.546937|";
        def strlats1 = "31.871662|31.870421|31.865669|31.859798|31.854194|31.852833|31.854371|31.855643|31.851288|31.845788|31.843162|31.843582|31.843844|31.844177|31.845732|31.848065|31.852545|31.858645|31.859583|31.861166|31.861627|31.861993|31.863396|31.86382|31.86708|31.869353|31.872482|31.878507|31.882956|31.884783|"
        def strsns1 = "蒋桥公交首末站|骏马工业园|毛家堂|双鹿村|骏马农林科技|信和纺织|新乘花苑北门|庆安大桥|蒋乘路|新丰路|申洲毛纺|乘航菜场|工贸中学|乘航派出所|香港城|兴华豪苑|张视电商会展中心|东二环路|梁丰生态园北门|梁丰花园北门|花园浜|前溪巷|市一中|移动公司|实验小学|慕嘏桥|滋生桥|电信大厦|城北新村|城北立交桥|"
        String[] line1Arr = strsns1.split("\\|");
        String[] line1Lons = strlons1.split("\\|");
        String[] line1Lats =strlats1 .split("\\|");
        for(int i = 0 ; i < line1Arr.size(); i ++ ){
            Station station = new Station(line1Arr[i], "1路",2)
            station.strlats =  line1Lats[i] ;
            station.strlons =  line1Lons[i] ;
            line1.add(station);
        }
        for(int i =0;i<line1.size();i++){
            if(i<line1.size()-1){
                line1.get(i).next = line1.get(i+1);
                line1.get(i+1).prev = line1.get(i);
            }
        }

        def strlons2 = "120.502424|120.506394|120.514661|120.518037|120.522067|120.525133|120.529176|120.534033|120.536761|120.53955|120.538432|120.540465|120.540989|120.539532|120.540793|120.541582|120.54217|120.543336|120.541423|120.542585|120.544952|120.549413|120.551876|120.556522|120.564599|120.569966|120.57111|";
        def strlats2 = "31.893214|31.89223|31.889604|31.888471|31.886789|31.885426|31.88354|31.881784|31.881051|31.879296|31.875956|31.875026|31.872374|31.87047|31.86823|31.866556|31.863331|31.858762|31.85211|31.849486|31.846287|31.846272|31.84388|31.842438|31.843955|31.847772|31.848452|";
        def strsns2 = "泗港|泗港路|人民西路停车场|陈东庄|江南十二府|悦丰新村|海陆锅炉厂|邮政局|广电大厦|游泳馆|龙潭路|华芳金陵西|滋生桥|庆丰新村|西菜场|实验小学|国际购物中心|港城汽车站|澳洋医院西门|湖滨国际|东湖苑西|东湖苑东|暨阳湖实验学校|梁丰机电城|交通大厦东站|兴华豪苑|香港城|";
        String[] line2Arr = strsns2.split("\\|");
        String[] line2Lons = strlons2.split("\\|");
        String[] line2Lats =strlats2.split("\\|");
        for(int i = 0 ; i < line2Arr.size(); i ++ ){
            Station station = new Station(line2Arr[i], "2路",2)
            station.strlats =  line2Lats[i] ;
            station.strlons =  line2Lons[i] ;
            line2.add(station);
        }
        for(int i =0;i<line2.size();i++){
            if(i<line2.size()-1){
                line2.get(i).next = line2.get(i+1);
                line2.get(i+1).prev = line2.get(i);
            }
        }

        def strlons3 = "120.523509|120.529055|120.534439|120.539229|120.551278|120.552989|120.55542|120.555632|120.550683|120.551633|120.554157|120.552919|120.550959|120.551143|120.551224|120.552215|120.556522|120.55679|120.554265|120.549617|120.546912|120.543413|120.542648|120.542021|120.543943|120.545883|120.546252|120.547014|120.549306|120.550534|120.547077|120.539389|120.536483|120.535353|120.53412|120.529305|120.523694|120.521513|120.520258|120.518037|120.514597|";
        def strlats3 = "31.810498|31.81252|31.812158|31.811706|31.798438|31.801768|31.805479|31.809269|31.813051|31.817131|31.818949|31.820059|31.82305|31.827859|31.836508|31.840803|31.842438|31.84643|31.849797|31.852279|31.855303|31.858541|31.862909|31.86708|31.867917|31.870706|31.874872|31.876916|31.882482|31.886475|31.88973|31.891742|31.892503|31.893734|31.896843|31.898366|31.898264|31.892601|31.88912|31.888471|31.889994|";
        def strsns3 = "李巷公交首末站|金港物流|紫荆路|河南公寓|黄棋桥|九州毛条厂|科力公司|园区桥|澳洋服饰|塘市|塘市北站|农民街|芦庄花苑|棋杆花苑|棋杆路|南二环路|梁丰机电城|李家桥|北庄路|庄河桥|赵庄新村|港城汽车站|国际购物中心|实验小学|杨舍老街|沙洲公园|扬帆社区|农业银行|城北小学|海关桥|国泰科技园|新城路|梁丰食品|振兴路东|港城大道|悦丰路|振兴路西|科技创业园|省开发区|陈东庄|人民西路停车场|";

        String[] line3Arr = strsns3.split("\\|");
        String[] line3Lons = strlons3.split("\\|");
        String[] line3Lats =strlats3.split("\\|");
        for(int i = 0 ; i < line3Arr.size(); i ++ ){
            Station station = new Station(line3Arr[i], "3路",2)
            station.strlats =  line3Lats[i] ;
            station.strlons =  line3Lons[i] ;
            line3.add(station);
        }
        for(int i =0;i<line3.size();i++){
            if(i<line3.size()-1){
                line3.get(i).next = line3.get(i+1);
                line3.get(i+1).prev = line3.get(i);
            }
        }

        def strlons5d = "120.560967|120.558378|120.559797|120.560451|120.56109|120.559215|120.558299|120.559878|120.556618|120.551798|120.545966|120.542393|120.540989|120.539532|120.536494|120.533225|120.529873|120.525848|120.529852|120.534298|120.537339|120.541792|120.543336|120.544874|120.553145|";
        def strlats5d = "31.848637|31.85543|31.859957|31.862126|31.86565|31.86704|31.869292|31.874916|31.875904|31.877272|31.878749|31.878293|31.872374|31.87047|31.867844|31.865656|31.865871|31.860677|31.860338|31.861207|31.860835|31.860514|31.858762|31.852593|31.854297|";
        def strsns5d = "客运站|实验小学东校区|梁丰花园|张高中|外国语学校|太平洋保险|妇保所|检察院|电视大学|市政府|国贸酒店|电信大厦|滋生桥|庆丰新村|图书馆|西门新村|大润发|小河坝路|中港花苑|沙洲中学北门|南门路（优博特）|国税局|港城汽车站|澳洋医院北门|东方明珠|";
        String[] line5dArr = strsns5d.split("\\|");
        String[] line5dLons = strlons5d.split("\\|");
        String[] line5dLats =strlats5d.split("\\|");
        for(int i = 0 ; i < line5dArr.size(); i ++ ){
            Station station = new Station(line5dArr[i], "5路东线",2)
            station.strlats =  line5dLats[i] ;
            station.strlons =  line5dLons[i] ;
            line5d.add(station);
        }
        for(int i =0;i<line5d.size();i++){
            if(i<line5d.size()-1){
                line5d.get(i).next = line5d.get(i+1);
                line5d.get(i+1).prev = line5d.get(i);
            }
        }

        def strlons5x = "120.560967|120.554674|120.544569|120.543413|120.541909|120.537351|120.534379|120.529151|120.526144|120.526783|120.529486|120.533783|120.536534|120.538242|120.541098|120.543253|120.545269|120.549799|120.556583|120.559467|120.558188|120.55932|120.561034|120.560397|120.559641|120.558288|";
        def strlats5x = "31.848637|31.854174|31.852815|31.858541|31.860589|31.860888|31.861316|31.860081|31.859967|31.863465|31.865838|31.865573|31.867445|31.869301|31.872482|31.878507|31.878721|31.877562|31.875705|31.874876|31.869323|31.866907|31.865789|31.862579|31.860003|31.855433|";
        def strsns5x = "客运站|东方明珠|澳洋医院北门|港城汽车站|国税局|南门路（优博特）|沙洲中学北门|中港花苑|小河坝路|张家港公园东门|大润发|西门新村|图书馆|庆丰新村|滋生桥|电信大厦|国贸酒店|市政府|电视大学|检察院|妇保所|太平洋保险|外国语学校|张高中|梁丰花园|实验小学东校区|";
        String[] line5xArr = strsns5x.split("\\|");
        String[] line5xLons = strlons5x.split("\\|");
        String[] line5xLats =strlats5x.split("\\|");
        for(int i = 0 ; i < line5xArr.size(); i ++ ){
            Station station = new Station(line5xArr[i], "5路西线",2)
            station.strlats =  line5xLats[i] ;
            station.strlons =  line5xLons[i] ;
            line5x.add(station);
        }
        for(int i =0;i<line5x.size();i++){
            if(i<line5x.size()-1){
                line5x.get(i).next = line5x.get(i+1);
                line5x.get(i+1).prev = line5x.get(i);
            }
        }

        def strlons6 = "120.506058|120.509109|120.514971|120.518842|120.522381|120.525161|120.529852|120.532956|120.535655|120.536534|120.538242|120.541098|120.543253|120.545853|120.547257|120.549126|120.5502|120.550152|120.551304|120.552723|120.552108|120.54858|120.545385|120.546686|120.549012|";
        def strlats6 = "31.846962|31.849389|31.852355|31.854002|31.855948|31.857621|31.860338|31.862209|31.864705|31.867445|31.869301|31.872482|31.878507|31.882956|31.886152|31.889983|31.893973|31.898873|31.900959|31.904197|31.907071|31.907328|31.909332|31.912251|31.909894|";
        def strsns6 = "包基|包基菜场|百桥花园南|西湖苑南|小城市新村|馨苑度假村|中港花苑|人武部|中医院|图书馆|庆丰新村|滋生桥|电信大厦|城北新村|锦绣花苑|农机公司|斜桥|看守所|交警大队|北二环路|福前书场|福前|彩虹苑|福新苑|福前公交首末站|";
        String[] line6Arr = strsns6.split("\\|");
        String[] line6Lons = strlons6.split("\\|");
        String[] line6Lats =strlats6.split("\\|");
        for(int i = 0 ; i < line6Arr.size(); i ++ ){
            Station station = new Station(line6Arr[i], "6路",2)
            station.strlats =  line6Lats[i] ;
            station.strlons =  line6Lons[i] ;
            line6.add(station);
        }
        for(int i =0;i<line6.size();i++){
            if(i<line6.size()-1){
                line6.get(i).next = line6.get(i+1);
                line6.get(i+1).prev = line6.get(i);
            }
        }

        def strlons8 = "120.555856|120.554157|120.551645|120.549061|120.543612|120.542005|120.54208|120.54154|120.541628|120.541534|120.541105|120.541423|120.543413|120.542648|120.538151|120.535729|";
        def strlats8 = "31.819727|31.818949|31.817182|31.817344|31.817768|31.819858|31.825806|31.830007|31.835121|31.838366|31.844476|31.85211|31.858541|31.862909|31.863756|31.864695|";
        def strsns8 = "塘市公交首末站|塘市北站|塘市|塘市菜场|同德里|金塘路|南庄|南庄北|九洲装饰城|吾悦广场|暨阳湖|澳洋医院西门|港城汽车站|国际购物中心|朱港巷路|中医院|";
        String[] line8Arr = strsns8.split("\\|");
        String[] line8Lons = strlons8.split("\\|");
        String[] line8Lats =strlats8.split("\\|");
        for(int i = 0 ; i < line8Arr.size(); i ++ ){
            Station station = new Station(line8Arr[i], "8路",2)
            station.strlats =  line8Lats[i] ;
            station.strlons =  line8Lons[i] ;
            line8.add(station);
        }
        for(int i =0;i<line8.size();i++){
            if(i<line8.size()-1){
                line8.get(i).next = line8.get(i+1);
                line8.get(i+1).prev = line8.get(i);
            }
        }

        def strlons9 = "120.600074|120.587719|120.585936|120.58352|120.581593|120.580396|120.578686|120.574592|120.569763|120.566442|120.562103|120.559878|120.556618|120.551798|120.545966|120.542393|120.540989|120.539532|120.536494|120.536986|120.540699|120.538151|120.535729|";
        def strlats9 = "31.912059|31.90532|31.900292|31.892941|31.887445|31.884232|31.879542|31.870759|31.872048|31.872893|31.874244|31.874916|31.875904|31.877272|31.878749|31.878293|31.872374|31.87047|31.867844|31.866224|31.865384|31.863756|31.864695|";
        def strsns9 = "青草巷首末站|二圩村|南横桥|南桥村东|农联花苑|农联村|农联金街|汇金中心|文化中心|勤丰苑|东渡大厦|检察院|电视大学|市政府|国贸酒店|电信大厦|滋生桥|庆丰新村|图书馆|机关宾馆|商业大厦|朱港巷路|中医院|";
        String[] line9Arr = strsns9.split("\\|");
        String[] line9Lons = strlons9.split("\\|");
        String[] line9Lats =strlats9.split("\\|");
        for(int i = 0 ; i < line9Arr.size(); i ++ ){
            Station station = new Station(line9Arr[i], "9路",2)
            station.strlats =  line9Lats[i] ;
            station.strlons =  line9Lons[i] ;
            line9.add(station);
        }
        for(int i =0;i<line9.size();i++) {
            if (i < line9.size() - 1) {
                line9.get(i).next = line9.get(i + 1);
                line9.get(i + 1).prev = line9.get(i);
            }
        }

        def strlons10 = "120.632658|120.634205|120.630521|120.628767|120.624589|120.620009|120.613541|120.603707|120.601436|120.59579|120.593961|120.592534|120.582687|120.580306|120.576612|120.574977|120.572003|120.568955|120.566876|120.565093|120.562103|120.559878|120.556618|120.552694|120.549086|120.54413|120.540989|120.542444|120.541582|120.54217|120.543336|120.544874|120.553145|120.560498|120.562656|120.560967|";
        def strlats10 = "31.905233|31.897264|31.896488|31.896097|31.895213|31.894127|31.893358|31.893386|31.893563|31.892433|31.888078|31.88441|31.88785|31.888276|31.886923|31.8833|31.882934|31.883717|31.882017|31.875673|31.874244|31.874916|31.875904|31.873512|31.872001|31.873533|31.872374|31.86973|31.866556|31.863331|31.858762|31.852593|31.854297|31.853273|31.850213|31.848637|";
        def strsns10 = "交通村|庆东站（东）|庆东站|庆东小学|庆桥站（东）|庆桥站|百得医疗|东莱菜场|东莱中学|东莱车站|南桥站|红蕾学校|农联花苑|老年公寓|党校|弘法寺|江帆花苑北区|华昌路|江帆花苑|东门立交桥|东渡大厦|检察院|电视大学|范庄花苑西|松坟桥|华芳金陵东|滋生桥|慕嘏桥|实验小学|国际购物中心|港城汽车站|澳洋医院北门|东方明珠|帝景豪园|交运时代广场|客运站|";
        String[] line10Arr = strsns10.split("\\|");
        String[] line10Lons = strlons10.split("\\|");
        String[] line10Lats =strlats10.split("\\|");
        for(int i = 0 ; i < line10Arr.size(); i ++ ){
            Station station = new Station(line10Arr[i], "10路",2)
            station.strlats =  line10Lats[i] ;
            station.strlons =  line10Lons[i] ;
            line10.add(station);
        }
        for(int i =0;i<line10.size();i++){
            if(i<line10.size()-1){
                line10.get(i).next = line10.get(i+1);
                line10.get(i+1).prev = line10.get(i);
            }
        }
        def strlons11d = "120.543743|120.542648|120.5444|120.547304|120.553596|120.558278|120.560451|120.56109|120.559215|120.554026|120.549793|120.545883|120.543785|120.538205|120.535077|120.531228|120.526414|120.5202|";
        def strlats11d = "31.859182|31.862909|31.863832|31.863396|31.861993|31.861627|31.862126|31.86565|31.86704|31.868508|31.869619|31.870706|31.87058|31.871581|31.872378|31.872984|31.874037|31.875999|";
        def strsns11d = "港城汽车站|国际购物中心|移动公司|市一中|前溪巷|花园浜|张高中|外国语学校|太平洋保险|新市河路|东方宾馆|沙洲公园|慕嘏桥|市二中|暨阳新村|云盘小学|少年宫|第一人民医院南门|";
        String[] line11dArr = strsns11d.split("\\|");
        String[] line11dLons = strlons11d.split("\\|");
        String[] line11dLats =strlats11d.split("\\|");
        for(int i = 0 ; i < line11dArr.size(); i ++ ){
            Station station = new Station(line11dArr[i], "11东路",2)
            station.strlats =  line11dLats[i] ;
            station.strlons =  line11dLons[i] ;
            line11d.add(station);
        }
        for(int i =0;i<line11d.size();i++){
            if(i<line11d.size()-1){
                line11d.get(i).next = line11d.get(i+1);
                line11d.get(i+1).prev = line11d.get(i);
            }
        }

        def strlons11x = "120.543743|120.542648|120.538151|120.533225|120.529873|120.524724|120.521104|120.519559|120.518047|120.514304|120.512979|120.514522|120.515497|120.520539|";
        def strlats11x = "31.859182|31.862909|31.863756|31.865656|31.865871|31.866993|31.867932|31.864812|31.858145|31.858505|31.863909|31.870945|31.874341|31.875691|";
        def strsns11x = "港城汽车站|国际购物中心|朱港巷路|西门新村|大润发|张家港公园北门|万红三村|清水湾东|西湖苑北|梁丰中学东门|职教中心西门|购物公园东门|今日家园东门|第一人民医院南门|";
        String[] line11xArr = strsns11x.split("\\|");
        String[] line11xLons = strlons11x.split("\\|");
        String[] line11xLats =strlats11x.split("\\|");
        for(int i = 0 ; i < line11xArr.size(); i ++ ){
            Station station = new Station(line11xArr[i], "11西路",2)
            station.strlats =  line11xLats[i] ;
            station.strlons =  line11xLons[i] ;
            line11x.add(station);
        }
        for(int i =0;i<line11x.size();i++){
            if(i<line11x.size()-1){
                line11x.get(i).next = line11x.get(i+1);
                line11x.get(i+1).prev = line11x.get(i);
            }
        }
        def strlons12 = "120.560967|120.554674|120.551371|120.552253|120.547304|120.545266|120.542021|120.542426|120.538205|120.535077|120.531228|120.526414|120.5202|120.515335|120.51416|120.51062|120.506888|";
        def strlats12 = "31.848637|31.854174|31.856751|31.861046|31.863396|31.86382|31.86708|31.869353|31.871581|31.872378|31.872984|31.874037|31.875999|31.874229|31.870875|31.870227|31.870524|";
        def strsns12 = "客运站|东方明珠|长江新城|前溪花园|市一中|移动公司|实验小学|慕嘏桥|市二中|暨阳新村|云盘小学|少年宫|第一人民医院南门|今日家园东门|购物公园东门|购物公园南门|购物公园|";
        String[] line12Arr = strsns12.split("\\|");
        String[] line12Lons = strlons12.split("\\|");
        String[] line12Lats =strlats12.split("\\|");
        for(int i = 0 ; i < line12Arr.size(); i ++ ){
            Station station = new Station(line12Arr[i], "12路",2)
            station.strlats =  line12Lats[i] ;
            station.strlons =  line12Lons[i] ;
            line12.add(station);
        }
        for(int i =0;i<line12.size();i++){
            if(i<line12.size()-1){
                line12.get(i).next = line12.get(i+1);
                line12.get(i+1).prev = line12.get(i);
            }
        }

        def strlons13 = "120.450645|120.449088|120.449961|120.451542|120.456852|120.460994|120.467673|120.472405|120.474399|120.474918|120.481856|120.487096|120.493055|120.496005|120.501197|120.505091|120.511758|120.51616|120.519205|120.521706|120.528007|120.532026|120.535985|120.538056|120.539532|120.536494|120.538151|120.54217|120.543336|120.544874|120.553145|120.560967|";
        def strlats13 = "31.904697|31.906259|31.909024|31.911478|31.898445|31.898465|31.898374|31.897864|31.895128|31.890339|31.89077|31.89054|31.888907|31.888225|31.886923|31.885951|31.883089|31.881677|31.880675|31.879882|31.877924|31.875614|31.874101|31.871545|31.87047|31.867844|31.863756|31.863331|31.858762|31.852593|31.854297|31.848637|";
        def strsns13 = "新塍小区首末站|新塍小区|新塍小区北站|后塍办事处|金港中队|朱家宕村|龙角桥|宝力管桩|闸上小学|闸上|夏家埭|章卿十三组|章卿村|蒋西路|幸福桥|泗港建行|张家港中心医院|悦盛花苑北|泗港办事处|第一人民医院北门|万红一村|云盘新村|龙潭桥|市二中|庆丰新村|图书馆|朱港巷路|国际购物中心|港城汽车站|澳洋医院北门|东方明珠|客运站|";
        String[] line13Arr = strsns13.split("\\|");
        String[] line13Lons = strlons13.split("\\|");
        String[] line13Lats =strlats13.split("\\|");
        for(int i = 0 ; i < line13Arr.size(); i ++ ){
            Station station = new Station(line13Arr[i], "13路",2)
            station.strlats =  line13Lats[i] ;
            station.strlons =  line13Lons[i] ;
            line13.add(station);
        }
        for(int i =0;i<line13.size();i++){
            if(i<line13.size()-1){
                line13.get(i).next = line13.get(i+1);
                line13.get(i+1).prev = line13.get(i);
            }
        }

        def strlons15 = "120.651152|120.647078|120.647175|120.643673|120.639944|120.63908|120.634945|120.631478|120.629489|120.62912|120.628033|120.631223|120.624993|120.620612|120.605733|120.598078|120.584933|120.574592|120.569763|120.566442|120.558188|120.55345|120.549086|120.54413|120.540989|120.539532|120.540793|120.541582|120.54217|120.543743|";
        def strlats15 = "31.843474|31.843325|31.846523|31.847391|31.847972|31.851666|31.852638|31.852877|31.854491|31.856867|31.857735|31.861357|31.863182|31.864295|31.868352|31.870475|31.873919|31.870759|31.872048|31.872893|31.869323|31.870627|31.872001|31.873533|31.872374|31.87047|31.86823|31.866556|31.863331|31.859182|";
        def strsns15 = "巨桥公交首末站|巨桥|巨桥菜场|华茂毛纺|鹿东站|鹿苑中学|金桥花苑|鹿苑医院|鹿苑幼儿园|鹿苑|鹿苑|鹿苑中转站|东渡苑|滩里村|恒昌化工|骏马工业园|蒋桥|汇金中心|文化中心|勤丰苑|妇保所|范庄花苑|松坟桥|华芳金陵东|滋生桥|庆丰新村|西菜场|实验小学|国际购物中心|港城汽车站|";
        String[] line15Arr = strsns15.split("\\|");
        String[] line15Lons = strlons15.split("\\|");
        String[] line15Lats =strlats15.split("\\|");
        for(int i = 0 ; i < line15Arr.size(); i ++ ){
            Station station = new Station(line15Arr[i], "13路",2)
            station.strlats =  line15Lats[i] ;
            station.strlons =  line15Lons[i] ;
            line15.add(station);
        }
        for(int i =0;i<line15.size();i++){
            if(i<line15.size()-1){
                line15.get(i).next = line15.get(i+1);
                line15.get(i+1).prev = line13.get(i);
            }
        }
        def strlons18 = "120.494999|120.499437|120.509481|120.513282|120.514304|120.512979|120.516316|120.521517|120.5246|120.527818|120.528474|120.531298|120.533819|120.538205|120.541098|120.543253|120.545269|120.549799|120.556583|120.559878|120.562835|120.566642|120.569512|120.57359|120.576606|120.579541|120.581006|120.582165|120.583709|120.58329|";
        def strlats18 = "31.861622|31.862267|31.856505|31.857284|31.858505|31.863909|31.868668|31.867713|31.866791|31.867941|31.870694|31.872762|31.872383|31.871581|31.872482|31.878507|31.878721|31.877562|31.875705|31.874916|31.87383|31.872611|31.871737|31.870557|31.870867|31.88126|31.885439|31.8885|31.892882|31.896067|";
        def strsns18 = "白鹿村|小河坝桥|西庄花苑|梁丰中学南门|梁丰中学东门|职教中心西门|职教中心北门|万红三村|张家港公园北门|保意电器|公安局|云盘小学|暨阳新村|市二中|滋生桥|电信大厦|国贸酒店|市政府|电视大学|检察院|东渡大厦|勤丰苑|文化中心|汇金中心|联发汽车城（阳光e驾港城驾校）|农联金街|农联村|农联花苑|南桥村东|公交城北停车场|";
        String[] line18Arr = strsns18.split("\\|");
        String[] line18Lons = strlons18.split("\\|");
        String[] line18Lats =strlats18.split("\\|");
        for(int i = 0 ; i < line18Arr.size(); i ++ ){
            Station station = new Station(line15Arr[i], "18路",2)
            station.strlats =  line18Lats[i] ;
            station.strlons =  line18Lons[i] ;
            line18.add(station);
        }
        for(int i =0;i<line18.size();i++){
            if(i<line18.size()-1){
                line18.get(i).next = line18.get(i+1);
                line18.get(i+1).prev = line18.get(i);
            }
        }

        def strlons19 = "120.604043|120.598102|120.593243|120.586244|120.582831|120.579601|120.575778|120.572817|120.568324|120.56377|120.559215|120.554043|120.552702|120.547038|120.545266|120.54217|120.541909|120.537351|120.534379|120.532848|120.533225|120.529873|120.524724|120.521104|120.515572|120.51062|120.505541|120.499568|120.497041|120.4966|120.496404|";
        def strlats19 = "31.851132|31.852833|31.854149|31.855643|31.856338|31.857123|31.858047|31.863157|31.864089|31.86576|31.86704|31.866625|31.863054|31.863556|31.86382|31.863331|31.860589|31.860888|31.861316|31.862639|31.865656|31.865871|31.866993|31.867932|31.869139|31.870227|31.871852|31.874247|31.878706|31.880615|31.883198|";
        def strsns19 = "庆安村|信和纺织|新乘花苑北门|庆安大桥|钢材市场|民丰村|第一加油站|万东医院|民丰苑|外国语学校|太平洋保险|亨通花园|气象新村|市一中|移动公司|国际购物中心|国税局|南门路（优博特）|沙洲中学北门|人武部|西门新村|大润发|张家港公园北门|万红三村|职教中心北门|购物公园南门|汇景豪苑|张义巷|七里庙小区|章卿小区东门|章卿小区北门|";
        String[] line19Arr = strsns19.split("\\|");
        String[] line19Lons = strlons19.split("\\|");
        String[] line19Lats =strlats19.split("\\|");
        for(int i = 0 ; i < line19Arr.size(); i ++ ){
            Station station = new Station(line19Arr[i], "19路",2)
            station.strlats =  line19Lats[i] ;
            station.strlons =  line19Lons[i] ;
            line19.add(station);
        }
        for(int i =0;i<line19.size();i++){
            if(i<line19.size()-1){
                line19.get(i).next = line19.get(i+1);
                line19.get(i+1).prev = line19.get(i);
            }
        }

        def strlons20 = "120.579404|120.569227|120.563424|120.564708|120.568929|120.566876|120.565093|120.562103|120.559878|120.556618|120.551798|120.545966|120.542393|120.541098|120.539532|120.536494|120.535655|120.534224|120.534298|120.537339|120.541792|120.543743|";
        def strlats20 = "31.906324|31.898973|31.898226|31.892486|31.89061|31.882017|31.875673|31.874244|31.874916|31.875904|31.877272|31.878749|31.878293|31.872482|31.87047|31.867844|31.864705|31.863063|31.861207|31.860835|31.860514|31.859182|";
        def strsns20 = "沙洲工学院西门|科技新城北门|科技新城西门|科技新城南门|长兴路|江帆花苑|东门立交桥|东渡大厦|检察院|电视大学|市政府|国贸酒店|电信大厦|滋生桥|庆丰新村|图书馆|中医院|人武部|沙洲中学北门|南门路（优博特）|国税局|港城汽车站|";
        String[] line20Arr = strsns20.split("\\|");
        String[] line20Lons = strlons20.split("\\|");
        String[] line20Lats =strlats20.split("\\|");
        for(int i = 0 ; i < line20Arr.size(); i ++ ){
            Station station = new Station(line20Arr[i], "20路",2)
            station.strlats =  line20Lats[i] ;
            station.strlons =  line20Lons[i] ;
            line20.add(station);
        }
        for(int i =0;i<line20.size();i++){
            if(i<line20.size()-1){
                line20.get(i).next = line20.get(i+1);
                line20.get(i+1).prev = line20.get(i);
            }
        }

        def strlons21 = "120.546431|120.548572|120.550907|120.552559|120.551218|120.549817|120.548873|120.543157|120.535229|120.529721|120.525223|120.523694|120.521513|120.520258|120.517877|120.516208|120.511974|120.510752|120.509176|120.507557|120.506079|120.508244|120.516954|120.520386|120.521301|120.524618|120.533672|120.536346|120.539675|120.544874|120.553145|120.560967|";
        def strlats21 = "31.907318|31.907196|31.906945|31.904602|31.900984|31.898349|31.896342|31.898024|31.900347|31.902125|31.902172|31.898264|31.892601|31.88912|31.88278|31.881847|31.880992|31.877921|31.874193|31.870098|31.866318|31.862626|31.862118|31.858254|31.85466|31.85209|31.850893|31.853868|31.854355|31.852593|31.854297|31.848637|";
        def strsns21 = "福前小区|福前|福前书场|北二环路|交警大队|看守所|斜桥|旭东学校|港城大道|悦丰路|长兴路|振兴路|科技创业园|省开发区|人民保险|悦盛花苑北|城市风景|景巷花苑|购物公园西门|白鹿花苑|白鹿小学|杨舍镇政府|清水湾|西湖苑东|长安南路|蓝湖湾|暨阳湖北|湖滨新村|南城花园|澳洋医院北门|东方明珠|客运站|";
        String[] line21Arr = strsns21.split("\\|");
        String[] line21Lons = strlons21.split("\\|");
        String[] line21Lats =strlats21.split("\\|");
        for(int i = 0 ; i < line21Arr.size(); i ++ ){
            Station station = new Station(line21Arr[i], "21路",2)
            station.strlats =  line21Lats[i] ;
            station.strlons =  line21Lons[i] ;
            line21.add(station);
        }
        for(int i =0;i<line21.size();i++){
            if(i<line21.size()-1){
                line21.get(i).next = line21.get(i+1);
                line21.get(i+1).prev = line21.get(i);
            }
        }

        def strlons32 = "120.512073|120.514107|120.516007|120.521306|120.52423|120.5235|120.524618|120.521301|120.520641|120.519225|120.512979|120.514522|120.515497|120.520539|120.526367|120.529504|120.534033|120.536761|120.544033|120.545853|120.547257|120.549126|120.5502|120.550152|120.551304|120.557278|120.563424|120.564708|120.569845|120.576333|120.58329|";
        def strlats32 = "31.837979|31.839347|31.841593|31.842187|31.845483|31.848286|31.85209|31.85466|31.859017|31.862103|31.863909|31.870945|31.874341|31.875691|31.873924|31.875632|31.881784|31.881051|31.880552|31.882956|31.886152|31.889983|31.893973|31.898873|31.900959|31.901847|31.898226|31.892486|31.892564|31.896761|31.896067|";
        def strsns32 = "城南公交首末站|佳暖纺织|城南工业区|西区大道|湿地大桥|镜湖公园|蓝湖湾|长安南路|西湖苑东|清水湾|职教中心西门|购物公园东门|今日家园东门|第一人民医院南门|少年宫|云盘二村|邮政局|广电大厦|长安广场|城北新村|锦绣花苑|农机公司|斜桥|看守所|交警大队|仓基村|科技新城西门|科技新城南门|科技新城东门|南桥村西|公交城北停车场|";
        String[] line32Arr = strsns32.split("\\|");
        String[] line32Lons = strlons32.split("\\|");
        String[] line32Lats =strlats32.split("\\|");
        for(int i = 0 ; i < line32Arr.size(); i ++ ){
            Station station = new Station(line32Arr[i], "32路",2)
            station.strlats =  line32Lats[i] ;
            station.strlons =  line32Lons[i] ;
            line32.add(station);
        }
        for(int i =0;i<line32.size();i++){
            if(i<line32.size()-1){
                line32.get(i).next = line32.get(i+1);
                line32.get(i+1).prev = line32.get(i);
            }
        }

        def strlons33 = "120.549012|120.54766|120.545236|120.546431|120.548572|120.550907|120.552559|120.557278|120.563424|120.564708|120.569845|120.576333|120.581507|120.58352|120.581593|120.580396|120.578686|120.576033|120.574784|120.573794|120.572851|120.569657|120.566297|120.560967|";
        def strlats33 = "31.909894|31.912249|31.90908|31.907318|31.907196|31.906945|31.904602|31.901847|31.898226|31.892486|31.892564|31.896761|31.895497|31.892941|31.887445|31.884232|31.879542|31.869263|31.861925|31.857288|31.852545|31.847683|31.846578|31.848637|";
        def strsns33 = "福前公交首末站|福新苑|彩虹苑|福前小区|福前|福前书场|北二环路|仓基村|科技新城西门|科技新城南门|科技新城东门|南桥村西|公交城北停车场|南桥村东|农联花苑|农联村|农联金街|联发汽车城|暨阳东路|第一加油站|张视电商会展中心|兴华豪苑|交通大厦|客运站|";
        String[] line33Arr = strsns33.split("\\|");
        String[] line33Lons = strlons33.split("\\|");
        String[] line33Lats =strlats33.split("\\|");
        for(int i = 0 ; i <line33Arr.size(); i ++ ){
            Station station = new Station(line33Arr[i], "33路",2)
            station.strlats =  line33Lats[i] ;
            station.strlons =  line33Lons[i] ;
            line33.add(station);
        }
        for(int i =0;i<line33.size();i++){
            if(i<line33.size()-1){
                line33.get(i).next = line33.get(i+1);
                line33.get(i+1).prev = line33.get(i);
            }
        }

        lineSet.add(line2);lineSet.add(line3);lineSet.add(line5d); lineSet.add(line5x);lineSet.add(line6);
        lineSet.add(line1);lineSet.add(line8);lineSet.add(line9) ; lineSet.add(line10); lineSet.add(line11d);
        lineSet.add(line11x); lineSet.add(line12); lineSet.add(line13); lineSet.add(line15);lineSet.add(line18)
        lineSet.add(line20); lineSet.add(line21); lineSet.add(line32); lineSet.add(line33)

        totalStaion  = line1.size() + line2.size() + line3.size() + line5d.size() + line5d.size()+ line6.size()
        + line8.size()+line9.size()+ line10.size() + line11d.size() + line11x.size() + line12.size() + line12.size()
        + line15.size() + line18.size() + line20.size() + line21.size() + line33.size()


    }
    public static void buildLine(String lineStr, String busName,def distance){
        List<Station> lineStations = new ArrayList<Station>();
        String[] lineS8Arr = lineStr.split(" - ");
        for(int i = 0; i< lineS8Arr.size(); i++){
            lineStations.add(new Station(lineS8Arr[i], busName,distance[i]));
        }
        for(int i =0;i<lineStations.size();i++){
            if(i<lineStations.size()-1){
                lineStations.get(i).next = lineStations.get(i+1);
                lineStations.get(i+1).prev = lineStations.get(i);
            }
        }
        lineSet.add(lineStations)
    }
}

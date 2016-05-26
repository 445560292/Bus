import com.bus.Bus
import com.bus.BusType
import com.bus.Company
import com.bus.Line
import com.bus.Station
import com.hank.Person
import com.utils.DataBuilder

import java.nio.charset.Charset

class BootStrap {

    def init = { servletContext ->

        if(!Person.findByUsername("hank")){
            Person person = new Person()
            person.username = 'hank'
            person.password = 'hank'
            person.save()
        }


        Line.findAll().each {
            line->
                line.delete(flush: true)
        }
        Station.findAll().each {
            station->
                station.delete(flush: true)
        }
        Bus.findAll().each{
            bus->
                bus.delete(flush: true)
        }
        if(!Station.findByName("first")){
            Station first = new Station()
            first.name = "first"
            first.strlats = ''
            first.strlons = ''
            first.save()
        }
        if(!Station.findByName("last")){
            Station last = new Station()
            last.name = "last"
            last.strlats = ''
            last.strlons = ''
            last.save()
        }

        DataBuilder.lineSet.each {
            lineSet ->
                lineSet.each{
                    station->
                        Station busStation = new Station()
                        if(!Bus.findByName(station.line)){
                            Bus bus = new Bus()
                            bus.name = station.line
                            bus.company = Company.get(1)
                            bus.endTime = new Date()
                            bus.startTime = new Date()
                            bus.busType= BusType.get(1)
                            bus.isCircle = false
                            bus.save()
                        }
                        if(!Station.findByName(station.name)){
                            busStation.name = station.name
                            busStation.strlons = station.strlons
                            busStation.strlats= station.strlats
                            busStation.save()
                        }
                }
                lineSet.each {
                    station->
                        Line line = new Line()
                        if(station.prev)
                            line.start =Station.findByName(station.prev.name)
                        else
                            line.start = Station.findByName("first")
                        if(station.next)
                            line.next = Station.findByName(station.next.name)
                        else
                            line.next = Station.findByName("last")
                        line.station = Station.findByName(station.name)
                        line.bus = Bus.findByName(station.line)
                        line.distance = Math.random() * 100
                        line.save()
                }
        }
        getLineInfo()
    }

    private getLineInfo(){
        clearDataBuilder()
        Bus.findAll().each{
            bus->
                def lineStr = ""
                def distances = []
                Line line =Line.findByBusAndStart(bus, Station.findByName("first"))
                lineStr = line.station.name
                distances.add(line.distance)
                while (line.next.name != "last"){
                    line = Line.findByBusAndStation(bus,line.next)
                    lineStr += " - " +line.station.name
                    distances.add(line.distance)
                }
                DataBuilder.buildLine(lineStr,bus.name,distances)
        }
        DataBuilder.lineSet.each {
            lineSet ->
                DataBuilder.totalStaion += lineSet.size()
        }
    }

    private clearDataBuilder(){
        DataBuilder.totalStaion = 0;
        DataBuilder.lineSet.clear()
    }
    def destroy = {
    }
}

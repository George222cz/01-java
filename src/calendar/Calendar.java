/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author rodi0878
 */
public class Calendar implements Iterable<EventSet>{
    private final Tree<EventSet> calendar;

    public Calendar() {
        calendar = new Tree<>();
    }

    public void addEvent(Event event) {
        EventSet eventSet = new EventSet(event.getDate());
        if (calendar.contain(eventSet)) {
            eventSet = calendar.get(eventSet);
        } else {
            calendar.add(eventSet);
        }
        eventSet.eventSet.add(event);
    }
    
    public EventSet eventsList(Date date) {
        return calendar.get(new EventSet(date));
    }
    
    public void DeleteAll(Date date) {
        calendar.erase(new EventSet(date));
    }

    @Override
    public Iterator<EventSet> iterator() {
        return calendar.iterator();
    }
}

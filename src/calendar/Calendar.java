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

    @Override
    public Iterator<EventSet> iterator() {
        return calendar.iterator();
    }
    
    
    private Tree<EventSet> calendar;

    public Calendar() {
        calendar = new Tree<>();
    }
    
    
    
    public void addEv(Event ev) {
        EventSet es = new EventSet(ev.getDate());
        if (calendar.contaix(es)) {
            es = calendar.get(es);
        } else {
            calendar.add(es);
        }
        
        es.eventSet.add(ev);
    }
    
    public EventSet eventsList(Date date) {
        return calendar.get(new EventSet(date));
    }
    
    public void DeleteAll(Date date) {
        calendar.erase(new EventSet(date));
    }
    
    
}

package headfirst.designpatterns.iterator.dinermergeri;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<Object> {
    MenuItem[] items;
    int position;

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        position = Calendar.DAY_OF_WEEK % 2;
    }

    public Object next() {
        MenuItem menuItem = items[position];
        position = position + 2;
        return menuItem;
    }

    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    public void remove() {
        throw new UnsupportedOperationException(
                "Alternating Diner Menu Iterator does not support remove()");
    }
}

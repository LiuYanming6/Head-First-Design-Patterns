package headfirst.designpatterns.iterator.dinermergercafe;

import java.util.Iterator;

public interface Menu {
	Iterator<MenuItem> createIterator();
}

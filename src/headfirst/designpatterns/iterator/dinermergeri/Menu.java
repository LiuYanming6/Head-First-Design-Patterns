package headfirst.designpatterns.iterator.dinermergeri;

import java.util.Iterator;

public interface Menu {
	Iterator<MenuItem> createIterator();
}

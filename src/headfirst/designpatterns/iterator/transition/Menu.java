package headfirst.designpatterns.iterator.transition;

import java.util.Iterator;

public interface Menu {
	Iterator<?> createIterator();
}

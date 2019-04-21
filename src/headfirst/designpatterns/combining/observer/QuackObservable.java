package headfirst.designpatterns.combining.observer;

public interface QuackObservable {
	void registerObserver(Observer observer);
	void notifyObservers();
}

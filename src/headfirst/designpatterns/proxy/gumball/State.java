package headfirst.designpatterns.proxy.gumball;

import java.io.Serializable;

public interface State extends Serializable {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}

package fr.unantes.heating;

/**
 * Created by sunye on 21/11/2016.
 */
public class HeatingSystemImpl implements HeatingSystem {

    private final HeatingState IDLE = new Idle();
    private final HeatingState HEATING = new Heating();
    private final HeatingState FAILURE = new Failure();

    private HeatingState state = IDLE;

    @Override
    public void tooCool() {
        this.state.tooCool();
    }

    @Override
    public void ok() {
        this.state.ok();
    }

    @Override
    public void cleared() {
        this.state.cleared();
    }

    @Override
    public void failure() {
        this.state.failure();
    }

    private void startUp() {
       // startUp() behavior
    }

    private void shutDown() {
       // shutDown() behavior
    }

    private void startAlarm() {
       // startAlarm() behavior
    }

    private void stopAlarm() {
        // stopAlarm() behavior
    }

    private void setState(HeatingState hs) {
        state.exit();
        state = hs;
        state.exit();
    }

    abstract class HeatingState implements HeatingSystem {

        public void entry() {}
        public void exit() {}

        @Override
        public void tooCool() {
            throw new RuntimeException("Unsupported method call");
        }

        @Override
        public void ok() {
            throw new RuntimeException("Unsupported method call");
        }

        @Override
        public void cleared() {
            throw new RuntimeException("Unsupported method call");
        }

        @Override
        public void failure() {
            throw new RuntimeException("Unsupported method call");
        }
    }

    class Idle extends HeatingState {
        public void tooCool() {
            // tooCool behavior
            setState(HEATING);
        }
    }

    class Heating extends HeatingState {
        public void entry() {
            startUp();
        }

        public void exit() {
            shutDown();
        }

        public void failure() {
            // failure() behavior
            setState(FAILURE);
        }

        public void ok() {
            // ok() behavior
            setState(IDLE);
        }

    }
    class Failure extends HeatingState {
        public void entry() {
            startAlarm();
        }

        public void exit() {
            stopAlarm();
        }

        public void cleared() {
            // cleared() behavior
            setState(IDLE);
        }
    }
}

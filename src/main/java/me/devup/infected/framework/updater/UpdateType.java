package me.devup.infected.framework.updater;

public enum UpdateType {

    MINUTE(60000L), MINUTE_5(300000L), MINUTE_10(600000L), MINUTE_15(900000L), SECOND(1000L), SECOND_5(5000L), SECOND_10(10000L), SECOND_15(15000L), TICK(50L), TICK_2(100L), TICK_3(150L), TICK_4(200L), TICK_5(250L);

    private long time, lastUpdate;

    UpdateType(long time) {
        this.time = time;

        this.lastUpdate = System.currentTimeMillis();
    }

    public boolean elapsed() {
        if (System.currentTimeMillis() - lastUpdate > time) {
            lastUpdate = System.currentTimeMillis();

            return true;
        }
        return false;
    }
}


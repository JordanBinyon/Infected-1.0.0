package me.devup.infected.plugin.game.leaderboard;

import lombok.Getter;
import me.devup.infected.plugin.game.leaderboard.leaderboards.AllTime;
import me.devup.infected.plugin.game.leaderboard.leaderboards.Daily;
import me.devup.infected.plugin.game.leaderboard.leaderboards.Monthly;
import me.devup.infected.plugin.game.leaderboard.leaderboards.Weekly;

@Getter
public class LeaderboardManager {

    private static LeaderboardManager instance = new LeaderboardManager();

    protected Leaderboard[] leaderboards = new Leaderboard[] { new Daily(LeaderboardType.DAILY), new Weekly(LeaderboardType.WEEKLY), new Monthly(LeaderboardType.MONTHLY), new AllTime(LeaderboardType.ALLTIME) };

    public static LeaderboardManager getInstance() {
        return instance;
    }

    public Leaderboard getDaily() {
        return leaderboards[0];
    }

    public Leaderboard getWeekly() {
        return leaderboards[1];
    }

    public Leaderboard getMonthly() {
        return leaderboards[2];
    }

    public Leaderboard getAllTime() {
        return leaderboards[3];
    }

    public void updateAll() {
        for(Leaderboard leaderboard : leaderboards) {
            leaderboard.update();
        }
    }

}
